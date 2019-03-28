package com.example.quickdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.net.Uri;
import android.widget.EditText;
import android.widget.Toast;

public class Extras extends AppCompatActivity {

    private Button home;
    private Button emergency;
    private Button contact;
    private Button myprofile;
    private Button aboutus;
    private Button faq;
    RatingBar ratingBar;
    private Button rate;
    private Button feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);

        home = (Button)findViewById(R.id.btHome);
        emergency = (Button) findViewById(R.id.btnEmergency);
        contact = (Button) findViewById(R.id.contactus);
        myprofile = (Button) findViewById(R.id.myprofile);
        aboutus = (Button) findViewById(R.id.aboutus);
        faq = (Button) findViewById(R.id.faq);
        ratingBar=(RatingBar) findViewById(R.id.ratingBar1);
        rate=(Button)findViewById(R.id.rateus);
        feedback=(Button)findViewById(R.id.feedback);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Extras.this, ContactUs.class);
                startActivity(intent);
            }
        });
        myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Extras.this, MyProfile.class);
                startActivity(intent);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Extras.this, AboutUs.class);
                startActivity(intent);
            }
        });
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Extras.this, FAO.class);
                startActivity(intent);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Extras.this, Home.class);
                startActivity(intent);
            }
        });
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialContactPhone("9819713028");
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float ratingvalue = ratingBar.getRating();
                Toast.makeText(getApplicationContext(), "Rating is: "+ratingvalue,Toast.LENGTH_SHORT).show();
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Extras.this, Feedback.class);
                startActivity(intent);
            }
        });
    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}
