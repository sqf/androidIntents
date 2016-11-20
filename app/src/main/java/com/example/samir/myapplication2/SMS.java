package com.example.samir.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SMS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        final Button buttonSend = (Button) findViewById(R.id.buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText smsRecipientEt = (EditText) findViewById(R.id.smsRecipientEt);
                String phoneNumber = smsRecipientEt.getText().toString();
                EditText payloadEt = (EditText) findViewById(R.id.payloadEt);
                String payload = payloadEt.getText().toString();
                sendMessage(phoneNumber, payload);
            }
        });
    }

    private void sendMessage(String phoneNumber, String payload) {
        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", payload);
        startActivity(it);
    }
}
