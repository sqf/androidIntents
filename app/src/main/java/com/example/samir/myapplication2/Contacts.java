package com.example.samir.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);


        final Button buttonPickContact = (Button) findViewById(R.id.buttonPickContact);
        buttonPickContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        switch (reqCode) {
            case (1) :
                if (resultCode == Activity.RESULT_OK) {
                    Uri contactData = data.getData();
                    Cursor c =  getContentResolver().query(contactData, null, null, null, null);
                    if (c.moveToFirst()) {
                        String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        TextView ContactsName = (TextView) findViewById(R.id.textViewContactsName);
                        ContactsName.setText(name);
                    }
//                    Uri contactData2 = data.getData();
//                    Cursor d =  getContentResolver().query(contactData2, null, null, null, null);
//                    if (d.moveToFirst()) {
//                        String id = d.getString(d.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
//                        String number = d.getString(d.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id));
//                        TextView ContactsNumber = (TextView) findViewById(R.id.textViewContactsNumber);
//                        ContactsNumber.setText(number);
//                    }
                }
                break;
        }
    }
}
