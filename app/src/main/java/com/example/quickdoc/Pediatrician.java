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

public class Pediatrician extends AppCompatActivity {
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
        setContentView(R.layout.activity_pediatrician);

        call1 = (Button)findViewById(R.id.doc1no);
        call2 = (Button)findViewById(R.id.doc2no);
        call3 = (Button)findViewById(R.id.doc3no);

        settings = (Button) findViewById(R.id.btSettings);
        emergency = (Button) findViewById(R.id.btnEmergency);
        home = (Button)findViewById(R.id.btHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pediatrician.this, Home.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Pediatrician.this, Extras.class);
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
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dr.+Prashant+Gandhi,+child+specialist,+Pediatrician,+vaccination+centre+Borivali/@19.2333975,72.8352955,14z/data=!4m8!1m2!2m1!1spedriaticians+in+borivali!3m4!1s0x3be7b12b2961fcbd:0xe79422974df8142e!8m2!3d19.2209015!4d72.8513731"));
        startActivity(browserIntent);
    }
    public void browser2(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dr+Ira+Shah+Clinic/@19.0879318,72.8261358,14z/data=!4m8!1m2!2m1!1spedriaticians+in+santacruz!3m4!1s0x3be7c90839b0344d:0x9e27a991d87362f2!8m2!3d19.0800172!4d72.8376912"));
        startActivity(browserIntent);
    }
    public void browser3(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dr.+Anuja+Pethe/@19.0980258,72.8408224,14z/data=!4m8!1m2!2m1!1spedriaticians+in+ville+parle!3m4!1s0x3be7c9b45efc83d3:0xb69afd90a5cc10dc!8m2!3d19.101218!4d72.846198"));
        startActivity(browserIntent);
    }
}
