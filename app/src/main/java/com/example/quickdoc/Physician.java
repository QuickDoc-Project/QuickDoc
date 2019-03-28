package com.example.quickdoc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Physician extends AppCompatActivity {

    final Context context = this;
    private Button call1;
    private Button call2;
    private Button call3;
  //  private Button loc1;
  //  private Button loc2;
  //  private Button loc3;
    private Button settings;
    private Button emergency;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physician);

        call1 = (Button)findViewById(R.id.doc1no);
        call2 = (Button)findViewById(R.id.doc2no);
        call3 = (Button)findViewById(R.id.doc3no);
        //loc1 = (Button)findViewById(R.id.doc1loc);
        //loc2 = (Button)findViewById(R.id.doc2loc);
        //loc3 = (Button)findViewById(R.id.doc3loc);

        settings = (Button) findViewById(R.id.btSettings);
        emergency = (Button) findViewById(R.id.btnEmergency);
        home = (Button)findViewById(R.id.btHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Physician.this, Home.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Physician.this, Extras.class);
                startActivity(intent);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9819713028", null)));
            }
        });

        call1.setOnClickListener(new OnClickListener(){
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

        call2.setOnClickListener(new OnClickListener(){
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

        call3.setOnClickListener(new OnClickListener(){
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
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dr.+Ameya+Vijaykar+General+Physician/@19.0224099,72.8369377,16.97z/data=!4m8!1m2!2m1!1sphysicians!3m4!1s0x3be7cec504daaaa9:0x2b6d1c5222252b8f!8m2!3d19.0214028!4d72.8374699"));
        startActivity(browserIntent);
    }
    public void browser2(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dr.+Sunil+Vallabhdas+Shah/@19.1870191,72.8362347,15z/data=!4m8!1m2!2m1!1sphysicians+in+malad!3m4!1s0x3be7b6e571e820a3:0x36879ceeabf85af4!8m2!3d19.1825304!4d72.8466732"));
        startActivity(browserIntent);
    }
    public void browser3(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/dr+sujeet+yadav.clinic/@19.1870156,72.8099699,13z/data=!4m8!1m2!2m1!1sphysicians+in+jogeshwari!3m4!1s0x3be7b63942a46bf3:0xead3c2c6ff9e7233!8m2!3d19.1450412!4d72.8352705"));
        startActivity(browserIntent);
    }
}

