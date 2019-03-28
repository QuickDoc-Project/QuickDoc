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

public class Dietitian extends AppCompatActivity {
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
        setContentView(R.layout.activity_dietitian);

        call1 = (Button)findViewById(R.id.doc1no);
        call2 = (Button)findViewById(R.id.doc2no);
        call3 = (Button)findViewById(R.id.doc3no);

        settings = (Button) findViewById(R.id.btSettings);
        emergency = (Button) findViewById(R.id.btnEmergency);
        home = (Button)findViewById(R.id.btHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dietitian.this, Home.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dietitian.this, Extras.class);
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
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Krupa+Parekh/@19.1235884,72.878122,13z/data=!4m8!1m2!2m1!1sDieticians+in+mumbai!3m4!1s0x3be7c87fe1d95555:0x5dd2f6e4bd4546de!8m2!3d19.1393936!4d72.8294027"));
        startActivity(browserIntent);
    }
    public void browser2(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Geetanjali+Medical+Nutrition+Clinic/@19.1235321,72.7730552,11z/data=!4m8!1m2!2m1!1sDieticians+in+bandra!3m4!1s0x3be7c96d8b1abdc1:0x574927f8a3e31fca!8m2!3d19.068239!4d72.823614"));
        startActivity(browserIntent);
    }
    public void browser3(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Anjali+Mukerjee+Health+Total+-+Best+Dietician,+Nutritionist+%26+Weight+Loss+Center./@18.9380635,72.8069452,14z/data=!4m8!1m2!2m1!1sDieticians+in+churchgate!3m4!1s0x3be7d1914e93760b:0xfe810addfbc226f9!8m2!3d18.9122676!4d72.8218413"));
        startActivity(browserIntent);
    }
}
