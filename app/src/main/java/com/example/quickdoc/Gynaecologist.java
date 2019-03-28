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

public class Gynaecologist extends AppCompatActivity {
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
        setContentView(R.layout.activity_gynaecologist);

        call1 = (Button)findViewById(R.id.doc1no);
        call2 = (Button)findViewById(R.id.doc2no);
        call3 = (Button)findViewById(R.id.doc3no);

        settings = (Button) findViewById(R.id.btSettings);
        emergency = (Button) findViewById(R.id.btnEmergency);
        home = (Button)findViewById(R.id.btHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gynaecologist.this, Home.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gynaecologist.this, Extras.class);
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
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Total+Women/@19.242449,72.8662884,18.29z/data=!4m8!1m2!2m1!1sGynaecologists+in+dahisar!3m4!1s0x0:0xcb7c393f8edf2574!8m2!3d19.2424868!4d72.8665433"));
        startActivity(browserIntent);
    }
    public void browser2(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dr.+Ranjana+Vilas+Dhanu/@19.0690913,72.8297029,16z/data=!4m8!1m2!2m1!1sGynaecologists+in+khar!3m4!1s0x3be7c938b7446413:0xe8ff0d25793978cb!8m2!3d19.0685202!4d72.8350362"));
        startActivity(browserIntent);
    }
    public void browser3(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dr.Sangeeta+Agrawal/@19.005199,72.8171811,14z/data=!4m8!1m2!2m1!1sGynaecologists+in+lower+parel!3m4!1s0x3be7cec0ba47428f:0xbc4b16fc3d7bba03!8m2!3d19.016083!4d72.828021"));
        startActivity(browserIntent);
    }

}
