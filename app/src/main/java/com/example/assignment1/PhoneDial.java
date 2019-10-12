package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneDial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dial);

        Button btnPh = findViewById(R.id.button6);
        btnPh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialNumber();
            }
        });
    }

    public void DialNumber() {
        try {
            EditText ph = findViewById(R.id.editText9);
            String num = ph.getText().toString();
            Uri number = Uri.parse("tel:" + num);
            Intent i = new Intent(Intent.ACTION_DIAL, number);
            startActivity(i);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


}
