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
                Intent MessageIntent = new Intent(Intent.ACTION_SEND);
                MessageIntent.putExtra(Intent.EXTRA_TEXT, "textMessage");
                MessageIntent.setType("text/plan");
                try
                {
                    startActivity(MessageIntent);
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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void EmailShow(View v)
    {
        Intent einten = new Intent(MainActivity.this , EmailSender.class);
        einten.putExtra("Receiver" , "problem9876543@gmail.com");
        startActivity(einten);
    }

    public void CheckPermission()
    {
        if(ActivityCompat.checkSelfPermission(this  , Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED)
        {
            Log.d("Phone", "getString(R.string.permission_not_granted)");
            ActivityCompat.requestPermissions(this  ,  new String[]{Manifest.permission.CALL_PHONE},My_PERMISSION_REQUEST_SEND_SMS);
        }

        else
        {
            Log.d("phone ", "getString(R.string.permission_granted)");
        }
    }

    public void PhoneShow(){

        Uri number = Uri.parse("tel:"  + "0310-0000000");
        Intent i = new Intent(Intent.ACTION_DIAL, number);
        startActivity(i);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
