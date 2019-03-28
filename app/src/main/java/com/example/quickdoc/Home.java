package com.example.quickdoc;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.*;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class Home extends AppCompatActivity {

    private Button settings;
    private Button emergency;
    private Button physician;
    private Button gynaecologist;
    private Button dermatologist;
    private Button pediatrician;
    private Button dietitian;
    private Button orthopedician;
    private TextView scrollingText;
    private TextSwitcher textSwitcher ;
    private Button Next ;
     private int StringIndex = 0 ;
    private String[] Row = {
            "Step 1: Choose a type of practitioner according to your symptoms.",
            "Step 2: Choose a doctor which best suits your criteria.",
            "Step 3: Consult the desired doctor.",
            "Step 4: Rate and share 'QuickDoc' for rewards."
    };
    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textSwitcher = (TextSwitcher)findViewById(R.id.textswitcher1);
        Next = (Button)findViewById(R.id.nextstep);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if(StringIndex == Row.length-1){

                    StringIndex = 0;

                    textSwitcher.setText(Row[StringIndex]);
                }
                else{

                    textSwitcher.setText(Row[++StringIndex]);
                }
            }
        });
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory(){
            @Override
            public View makeView() {
                textView = new TextView(Home.this);
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(20);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                return textView;
            }});

        textSwitcher.setText(Row[StringIndex]);


        settings = (Button) findViewById(R.id.btSettings);
        emergency = (Button) findViewById(R.id.btnEmergency);
        physician = (Button) findViewById(R.id.physician);
        gynaecologist = (Button) findViewById(R.id.gynaecologist);
        dermatologist = (Button) findViewById(R.id.dermatologist);
        pediatrician = (Button) findViewById(R.id.pediatrician);
        dietitian = (Button) findViewById(R.id.dietitian);
        orthopedician = (Button) findViewById(R.id.orthopedician);
        scrollingText = (TextView)findViewById(R.id.scrollingtext);
        scrollingText.setSelected(true);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Extras.class);
                startActivity(intent);
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialContactPhone("9819713028");
            }
        });

        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Physician.class);
                startActivity(intent);
            }
        });

        gynaecologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Gynaecologist.class);
                startActivity(intent);
            }
        });

        dermatologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Dermatologist.class);
                startActivity(intent);
            }
        });

        pediatrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Pediatrician.class);
                startActivity(intent);
            }
        });

        dietitian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Dietitian.class);
                startActivity(intent);
            }
        });

        orthopedician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Orthopedician.class);
                startActivity(intent);
            }
        });
    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}

