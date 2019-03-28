package com.example.quickdoc;

import android.content.Intent;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private Button Account;
    private Vibrator vibrator;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);
        Account = (Button)findViewById(R.id.Account);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        mAuth = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp( Login.this );

        Info.setText("No. of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
                    vibrator.vibrate(200);
            }
        });

        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allow();
            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity( new Intent( Login.this, Home.class ) );
                }
            }
        };


    }

    private void validate(String userName, String userPassword){

        final String email=Name.getText().toString().trim();
        final String password1=Password.getText().toString().trim();
        if("".equals(email)){
            Toast.makeText(getApplicationContext(), "Please Enter E-mail.",Toast.LENGTH_LONG).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(getApplicationContext(), "Please Enter a Valid E-mail.",Toast.LENGTH_LONG).show();
        }
        else if(email.indexOf("@",0)<0){
            Toast.makeText(getApplicationContext(), "Please Enter a Valid E-mail.",Toast.LENGTH_LONG).show();
        }
        else if(email.indexOf(".",0)<0){
            Toast.makeText(getApplicationContext(), "Please Enter a Valid E-mail.",Toast.LENGTH_LONG).show();
        }
        else if("".equals(password1)){
            Toast.makeText(getApplicationContext(), "Please Enter Password.",Toast.LENGTH_LONG).show();
        }
        mAuth.signInWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent intent1 = new Intent(Login.this, Home.class);
                    startActivity(intent1);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    counter--;
                    Info.setText("No. of attempts remaining: " + String.valueOf(counter));

                    if(counter == 0){
                        Login.setEnabled(false);
                    }
                }
            }});

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener( authStateListener );
    }
    private void allow(){

        Intent intent1 = new Intent(Login.this, SignUp.class);
        startActivity(intent1);
    }
}

