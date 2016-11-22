package com.example.samir.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonSms = (Button) findViewById(R.id.buttonSms);
        buttonSms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SMS.class));
            }
        });

        final Button buttonContacts = (Button) findViewById(R.id.buttonContacts);
        buttonContacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Contacts.class));
            }
        });

        final Button buttonMap = (Button) findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Maps.class));
            }
        });

        final Button buttonMyActivity = (Button) findViewById(R.id.buttonMyActivity);
        buttonMyActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle extras = new Bundle();
                extras.putString("kij", "janusz");
                Intent intent = new Intent(MainActivity.this, MyActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });

    }

}
