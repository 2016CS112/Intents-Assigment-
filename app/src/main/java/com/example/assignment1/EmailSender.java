package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class EmailSender extends AppCompatActivity {


    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sender);
        EditText txt = findViewById(R.id.editText2);
        Intent mainIntent = getIntent();
        String receivermail = mainIntent.getStringExtra("Receiver");
        txt.setText(receivermail);
        email = receivermail;

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

        String stxt = subtxt.getText().toString();

        String btxt  = bodytxt.getText().toString();

        Log.i("Send Email" , "");
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plan");
        emailIntent.putExtra(Intent.EXTRA_EMAIL ,email); // Receiver Mail Address
        emailIntent.putExtra(Intent.EXTRA_SUBJECT , stxt); //Subject of mail
        emailIntent.putExtra(Intent.EXTRA_TEXT , btxt);// Body of Email
        try
        {
            startActivity(Intent.createChooser(emailIntent , "SendMail..."));
            finish();
        }catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(this, "Error to Mail", Toast.LENGTH_SHORT).show();
        }

    }
}
