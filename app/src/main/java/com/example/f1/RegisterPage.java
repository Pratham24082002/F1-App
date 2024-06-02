package com.example.f1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterPage extends AppCompatActivity {

    EditText Registeremail,Regpwd,Confirmpwd;
    ImageButton Regbtn;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        Registeremail = findViewById(R.id.Registeremail);
        Regpwd = findViewById(R.id.Regpwd);
        Confirmpwd = findViewById(R.id.Confirmpwd);
        Regbtn = findViewById(R.id.Regbtn);

        firebaseAuth = FirebaseAuth.getInstance();
        Regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if (Regpwd.getText().toString().equals(Confirmpwd.getText().toString())){
                firebaseAuth.createUserWithEmailAndPassword(Registeremail.getText().toString(),Regpwd.getText().toString()).addOnCompleteListener(RegisterPage.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"User registered",Toast.LENGTH_LONG).show();
                            Intent login_intent = new Intent(getApplicationContext(), LoginPage.class);
                            startActivity(login_intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"User not registered",Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
            else {
                Toast.makeText(getApplicationContext(),"Password didn't matched",Toast.LENGTH_LONG).show();
            }

            }
        });
    }
}