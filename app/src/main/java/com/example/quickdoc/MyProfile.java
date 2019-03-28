package com.example.quickdoc;

import android.hardware.Camera;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.camera2.*;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyProfile extends AppCompatActivity {

    Button signout;
    Button delete;
    FirebaseAuth mAuth;

    private DatabaseReference databaseRef;
    private TextView fullName;
    private TextView email;
    private TextView number;
    private TextView dob;
    private TextView gender;
    private String currentId;
    private Button settings;
    private Button emergency;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        fullName = findViewById(R.id.username1);
        email = findViewById(R.id.email1);
        number = findViewById(R.id.phone1);
        dob = findViewById(R.id.dob1);
        gender = findViewById(R.id.gender1);
        mAuth = FirebaseAuth.getInstance();
        currentId = mAuth.getCurrentUser().getUid();
        signout=(Button)findViewById(R.id.logout);
        delete=(Button)findViewById(R.id.delete);
        databaseRef = FirebaseDatabase.getInstance().getReference().child("user").child(currentId);

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists())
                {
                    FirebaseUser user = mAuth.getCurrentUser();

                    String profEmail = dataSnapshot.child("email").getValue().toString();
                    String profName = dataSnapshot.child("name").getValue().toString();
                    String profNumber = dataSnapshot.child("phone").getValue().toString();
                    String profDob = dataSnapshot.child("dob").getValue().toString();
                    String profGender = dataSnapshot.child("gender").getValue().toString();

                    email.setText(profEmail);
                    fullName.setText(profName);
                    number.setText(profNumber);
                    dob.setText(profDob);
                    gender.setText(profGender);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        settings = (Button) findViewById(R.id.btSettings);
        emergency = (Button) findViewById(R.id.btnEmergency);
        home = (Button)findViewById(R.id.btHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfile.this, Home.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfile.this, Extras.class);
                startActivity(intent);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9819713028", null)));
            }
        });

        signout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        } );

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase.getInstance().getReference("user")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).removeValue();
                mAuth.getCurrentUser().delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        signOut();
                    }
                });
            }
        });
    }

    public void signOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MyProfile.this, Login.class);
        startActivity(intent);
    }
}
