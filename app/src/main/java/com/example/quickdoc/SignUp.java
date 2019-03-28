package com.example.quickdoc;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {

    private EditText Name;
    private EditText Email;
    private EditText Password1;
    private EditText Password2;
    private EditText Phone;
    private Button SignUp;
    private EditText gender;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    Button Date;
    TextView date;
    DatePickerDialog datePicker;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Name = (EditText) findViewById(R.id.etUsername);
        Email = (EditText) findViewById(R.id.editText8);
        Password1 = (EditText) findViewById(R.id.editText9);
        Password2 = (EditText) findViewById(R.id.etPassword2);
        Phone = (EditText) findViewById(R.id.etPhone);
        SignUp = (Button) findViewById(R.id.btnSignup);
        gender = (EditText) findViewById(R.id.gender);
        mAuth = FirebaseAuth.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference();
        FirebaseApp.initializeApp( SignUp.this );

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

        Date = findViewById(R.id.date);
        date = findViewById(R.id.textView6);

        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePicker = new DatePickerDialog(SignUp.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
                        date.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);
                datePicker.show();
            }
        });

    }

    private void validate(){
        final String name = Name.getText().toString().trim();
        final String email=Email.getText().toString().trim();
        final String password1=Password1.getText().toString().trim();
        final String password2=Password2.getText().toString().trim();
        final String phone=Phone.getText().toString().trim();
        final String DATE=date.getText().toString().trim();
        final String Gender=gender.getText().toString().trim();
        if("".equals(name)){
            Toast.makeText(getApplicationContext(), "Please Enter Username.",Toast.LENGTH_LONG).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(getApplicationContext(), "Please Enter a Valid E-mail.",Toast.LENGTH_LONG).show();
        }
        else if("".equals(email)){
            Toast.makeText(getApplicationContext(), "Please Enter E-mail.",Toast.LENGTH_LONG).show();
        }
        else if("".equals(Gender)){
            Toast.makeText(getApplicationContext(), "Please Enter Gender.",Toast.LENGTH_LONG).show();
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
        else if("".equals(password2)){
            Toast.makeText(getApplicationContext(), "Please Re-Enter Password.",Toast.LENGTH_LONG).show();
        }
        else if(!(password1.equals(password2))){
            Toast.makeText(getApplicationContext(), "Passwords do not match.",Toast.LENGTH_LONG).show();
        }
        else if("".equals(phone)){
            Toast.makeText(getApplicationContext(), "Please Enter Phone Number.",Toast.LENGTH_LONG).show();
        }
        else if(phone.length()!=10){
            Toast.makeText(getApplicationContext(), "Please Enter a Valid Phone Number.",Toast.LENGTH_LONG).show();
        }
        mAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User user=new User(email,name,phone,DATE,Gender);
                    FirebaseDatabase.getInstance().getReference("user")
                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                        .addOnCompleteListener(new OnCompleteListener<Void>(){
                            @Override
                            public void onComplete(@NonNull Task<Void> task){
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignUp.this, Home.class);
                                    startActivity(intent);
                                }
                                else{
                                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                    Toast.makeText(getApplicationContext(),"Error: Email already exists", Toast.LENGTH_SHORT).show();
                                }   else{
                                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                                }
                            }
                                               }
                        );


                }
            }
        });
}

}
