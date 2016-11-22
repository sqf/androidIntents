package com.example.samir.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {
        EditText Multiply2Et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        String value = getIntent().getExtras().getString("kij");
        TextView textViewMyActivity = (TextView) findViewById(R.id.textViewMyActivity);
        textViewMyActivity.setText(value);

        final Button buttonOk = (Button) findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Multiply2Et = (EditText) findViewById(R.id.MultiplyEt);
                String number2S = Multiply2Et.getText().toString();
                double number2D = Double.parseDouble(number2S);
                String value = getIntent().getExtras().getString("kij");
                double numberD = Double.parseDouble(value);
                numberD = numberD * number2D;
                Intent intent=new Intent();
                String numberS = String.valueOf(numberD);
                intent.putExtra("MESSAGE", numberS);
                setResult(2,intent);
                finish();//finishing activity
            }
        });


    }
}
