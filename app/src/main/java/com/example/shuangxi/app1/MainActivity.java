package com.example.shuangxi.app1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button SF_Button;
    private Button NY_Button;
    private static final String TOAST_INTENT_SF =    // intent action for choosing San Francisco
            "com.example.shuangxi.app1.SF";
    private static final String TOAST_INTENT_NY =    // intent action for choosing New York
            "com.example.shuangxi.app1.NY";
    private static final String SXZHU_PERMISSION =    // permission strings
            "edu.uic.cs478.f18.project3" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        checkPermission();
        SF_Button =  findViewById(R.id.button1);
        NY_Button =  findViewById(R.id.button2);

        // when clicking San Francisco Button, check the permission and send Broadcast
        SF_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentBroadcast(TOAST_INTENT_SF);
            }
        });


        // when clicking New York Button, check the permission and send Broadcast
        NY_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentBroadcast(TOAST_INTENT_NY);
            }
        });
    }

      // function of sending Broadcast
    private void sentBroadcast(String TOAST_INTENT) {
        if (ContextCompat.checkSelfPermission(this, SXZHU_PERMISSION)
                == PackageManager.PERMISSION_GRANTED) {
            Intent aIntent = new Intent(TOAST_INTENT) ;
            sendOrderedBroadcast(aIntent, SXZHU_PERMISSION) ;
        }
    }

    // function of checking permission
    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, SXZHU_PERMISSION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{SXZHU_PERMISSION}, 0);
        }
    }

}
