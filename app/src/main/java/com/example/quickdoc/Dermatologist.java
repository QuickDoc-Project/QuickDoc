package com.example.quickdoc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dermatologist extends AppCompatActivity {
    final Context context = this;
    private Button call1;
    private Button call2;
    private Button call3;
    private Button settings;
    private Button emergency;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dermatologist);

        call1 = (Button)findViewById(R.id.doc1no);
        call2 = (Button)findViewById(R.id.doc2no);
        call3 = (Button)findViewById(R.id.doc3no);

        settings = (Button) findViewById(R.id.btSettings);
        emergency = (Button) findViewById(R.id.btnEmergency);
        home = (Button)findViewById(R.id.btHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dermatologist.this, Home.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dermatologist.this, Extras.class);
                startActivity(intent);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9819713028", null)));
            }
        });

        call1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Confirm Appointment?");
                alertDialogBuilder.setMessage("").setCancelable(false).setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Physician.this.finish();
                    }
                })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9819713028", null)));
                                //  dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        call2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Confirm Appointment?");
                alertDialogBuilder.setMessage("").setCancelable(false).setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Physician.this.finish();
                    }
                })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9819713028", null)));
                                //  dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        call3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Confirm Appointment?");
                alertDialogBuilder.setMessage("").setCancelable(false).setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Physician.this.finish();
                    }
                })
                        .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9819713028", null)));
                                //  dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

    }
    public void browser1(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dr+Radhika+Khambhaati+(Nirrmit+Skin+Clinic)/@19.1870089,72.8099698,13z/data=!4m8!1m2!2m1!1sskin+doctors+in+mumbai!3m4!1s0x3be7b6db21374cff:0x9f8c005b22d0692e!8m2!3d19.204861!4d72.840766"));
        startActivity(browserIntent);
    }
    public void browser2(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/DR+GEETANJALI+SHETTY+SKIN+CLINIC/@19.1870089,72.8099698,13z/data=!4m8!1m2!2m1!1sskin+doctors+in+mumbai!3m4!1s0x3be7b65aa3bef3fb:0xb37e6f8ce66babf4!8m2!3d19.1632583!4d72.8406647"));
        startActivity(browserIntent);
    }
    public void browser3(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dr+Ishani+Chakravarty@Aviva+skin+clinic/@19.123595,72.8781221,13z/data=!4m8!1m2!2m1!1sskin+doctors+in+mumbai!3m4!1s0x3bc2c3e0550ac12f:0x57c02efec056504c!8m2!3d19.123595!4d72.913141"));
        startActivity(browserIntent);
    }
}
