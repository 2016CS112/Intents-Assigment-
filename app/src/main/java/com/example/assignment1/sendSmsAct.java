package com.example.assignment1;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.provider.ContactsContract;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class sendSmsAct extends AppCompatActivity {

    private static final int My_PERMISSION_REQUEST_SEND_SMS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button sms = (Button) findViewById(R.id.button4);

        sms.setOnClickListener(new View.OnClickListener(){
         public void onClick(View v)
         {
             SendMsg();
         }
        }
        );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void CheckPermission()
    {
        if(ActivityCompat.checkSelfPermission(this  , Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED)
        {
            Log.d("SMS_Sending ", "getString(R.string.permission_not_granted)");
            ActivityCompat.requestPermissions(this  ,  new String[]{Manifest.permission.SEND_SMS},My_PERMISSION_REQUEST_SEND_SMS);
        }

        else
        {
            Log.d("SMS_Sending ", "getString(R.string.permission_granted)");
        }
    }


    public void SendMsg()
    {
        CheckPermission();
        EditText phone = findViewById(R.id.editText7);
        EditText txt = findViewById(R.id.editText6);

        String Phone = phone.getText().toString();
        String text = txt.getText().toString();
        try
        {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(Phone , null ,text , null , null);
        }
        catch(Exception e) {
            Log.d("SMS_sending", e.getMessage());
        }}
}