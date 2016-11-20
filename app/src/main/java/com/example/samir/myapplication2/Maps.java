package com.example.samir.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Maps extends AppCompatActivity {
    Button buttonShowMap;
    EditText editTextMapLatitude;
    EditText editTextMapLongitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        editTextMapLatitude = (EditText) findViewById(R.id.editTextMapLatitude);
        editTextMapLongitude = (EditText) findViewById(R.id.editTextMapLongitude);
        buttonShowMap = (Button) findViewById(R.id.buttonShowMap);

        buttonShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonShowMapClick();
            }
        });
    }
    void buttonShowMapClick() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: +" + editTextMapLatitude.getText() + "," + editTextMapLongitude.getText() + "?z=10"));
        startActivity(intent);
    }
}
