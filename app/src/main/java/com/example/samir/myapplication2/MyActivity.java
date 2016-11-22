package com.example.samir.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        String value = getIntent().getExtras().getString("kij");
        TextView textViewMyActivity = (TextView) findViewById(R.id.textViewMyActivity);
        textViewMyActivity.setText(value);

    }
}
