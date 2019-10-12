package com.example.assignment1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int My_PERMISSION_REQUEST_SEND_SMS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button messagebtn = (Button) findViewById(R.id.button2);

        messagebtn.setOnClickListener(new  View.OnClickListener() {
            public void onClick(View v){
//                Intent MessageIntent = new Intent(Intent.ACTION_SEND);
//                MessageIntent.putExtra(Intent.EXTRA_TEXT, "textMessage");
//                MessageIntent.setType("text/plan");
                try
                {
                    Intent messScreen = new Intent(Intent.ACTION_SEND);
                    messScreen.setType("text/plain");
                    startActivity(messScreen);
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button phbtn = (Button) findViewById(R.id.button3);

        phbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                PhoneShow();
            }
        });


         Button emailbtn = findViewById(R.id.button);
         emailbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 ShowEmailScreen();
             }
         });

    }


    public void ShowEmailScreen() {
        try {
            Intent einten = new Intent(MainActivity.this, EmailSender.class);
            startActivity(einten);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }


    public void PhoneShow(){

        Intent dialph = new Intent(this , PhoneDial.class);
        startActivity(dialph);

//

//        CheckPermission();
//        Intent pintent = new Intent(Intent.ACTION_CALL);
//        String ph = "0317-0000000";
//        pintent.setType("phone");
//        pintent.putExtra("phnum",ph);
//        try
//        {
//            startActivity(pintent);
//        }
//        catch(Exception e)
//        {
//            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
    }




}
