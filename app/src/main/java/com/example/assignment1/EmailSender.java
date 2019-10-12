package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;



public class EmailSender extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sender);

        Button sendbtn = (Button) findViewById(R.id.sendEmail);

        sendbtn.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                sendMail();
            }
        });
    }


    public void sendMail()
    {
        EditText subtxt =  findViewById(R.id.editText5); //For Subject of Mail..
        EditText bodytxt = findViewById(R.id.editText3); //for Body of mail....
        EditText ml   = findViewById(R.id.editText2) ; //Mail
        String stxt = subtxt.getText().toString();
        String TO = ml.getText().toString();
        String btxt  = bodytxt.getText().toString();
        String[] Rmail = new String[] {TO};
        Log.i("Send Email" , "");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("plain/text");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT , stxt); //Subject of mail
        emailIntent.putExtra(Intent.EXTRA_TEXT , btxt);// Body of Email
        emailIntent.putExtra(Intent.EXTRA_EMAIL , Rmail);

        try
        {
                startActivity(Intent.createChooser(emailIntent, "sending Mail"));
                finish();
        }catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(this, "Error to Mail", Toast.LENGTH_SHORT).show();
        }

    }
}
