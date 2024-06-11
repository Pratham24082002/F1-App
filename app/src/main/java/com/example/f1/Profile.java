package com.example.f1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    EditText name,email;
    Button fetch;

DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);


        dataBaseHelper = new DataBaseHelper(this);

        Cursor cursor = dataBaseHelper.getUser();
        if (cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndex("name");
            int emailIndex = cursor.getColumnIndex("email");

            if (nameIndex != -1 && emailIndex != -1) {
                String userName = cursor.getString(nameIndex);
                String userEmail = cursor.getString(emailIndex);
                name.setText(userName);
                email.setText(userEmail);
                Toast.makeText(getApplicationContext(), "Record found", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Column not found", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "No record found", Toast.LENGTH_LONG).show();
        }
        cursor.close();

    }
}