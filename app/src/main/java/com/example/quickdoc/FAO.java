package com.example.quickdoc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FAO extends AppCompatActivity {

    private Button settings;
    private Button emergency;
    private Button home;
    private Button docadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fao);


        settings = (Button) findViewById(R.id.btSettings);
        emergency = (Button) findViewById(R.id.btnEmergency);
        home = (Button)findViewById(R.id.btHome);
        docadd = (Button)findViewById(R.id.docadd);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FAO.this, Home.class);
                startActivity(intent);
            }
        });
        docadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FAO.this, ContactUs.class);
                startActivity(intent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FAO.this, Extras.class);
                startActivity(intent);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "9819713028", null)));
            }
        });

    }
}
