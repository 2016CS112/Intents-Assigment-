package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_screen);

        Button btn = (Button) findViewById(R.id.button5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendSms();
            }
        });
    }

    public void SendSms()
    {
        EditText ph = findViewById(R.id.editText8);
        EditText ms = findViewById(R.id.editText4);
        String mess = ms.getText().toString();
        String phn  = ph.getText().toString();
        try
        {
                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(ph.getText().toString() ,null , ms.getText().toString() , null , null);
                Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
                ph.setText("");
                ms.setText("");
                Toast.makeText(this, "Both Fields are Required", Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

}
