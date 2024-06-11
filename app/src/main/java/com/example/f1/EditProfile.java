package com.example.f1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
public class EditProfile extends AppCompatActivity {

    EditText name,email;
    Button create,update,delete;

    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        create=findViewById(R.id.create);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);

        dataBaseHelper = new DataBaseHelper(this);
        if (dataBaseHelper == null) {
            Log.e("EditProfile", "dataBaseHelper is null");
        } else {
            Log.d("EditProfile", "dataBaseHelper initialized successfully");
        }
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty()){
                    boolean res = dataBaseHelper.createUser(name.getText().toString(),email.getText().toString());
                    if(res==true){
                        Toast.makeText(getApplicationContext(),"record inserted",Toast.LENGTH_LONG).show();
                        Intent homeintent = new Intent(getApplicationContext(), Home.class);
                        startActivity(homeintent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"record not inserted",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!name.getText().toString().isEmpty() && !email.getText().toString().isEmpty()) {
                    boolean res = dataBaseHelper.updateUser(email.getText().toString(), name.getText().toString());
                    if (res) {
                        Toast.makeText(getApplicationContext(), "Record updated", Toast.LENGTH_LONG).show();
                        Intent homeintent = new Intent(getApplicationContext(), Home.class);
                        startActivity(homeintent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Record not updated", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill all fields", Toast.LENGTH_LONG).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!email.getText().toString().isEmpty()) {
                    boolean res = dataBaseHelper.deleteUser(email.getText().toString());
                    if (res) {
                        Toast.makeText(getApplicationContext(), "Record deleted", Toast.LENGTH_LONG).show();
                        Intent homeintent = new Intent(getApplicationContext(), Home.class);
                        startActivity(homeintent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Record not deleted", Toast.LENGTH_LONG).show();

                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please provide an email", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}