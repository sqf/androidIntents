package com.example.samir.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText MultiplyEt;
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
                MultiplyEt = (EditText) findViewById(R.id.MultiplyEt);
                String numberS = MultiplyEt.getText().toString();
                extras.putString("kij", numberS);
                Intent intent = new Intent(MainActivity.this, MyActivity.class);
                intent.putExtras(extras);
                startActivity(intent);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");
            TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
            textViewResult.setText(message);
        }
    }

}
