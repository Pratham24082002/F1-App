package com.example.f1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    EditText Loginemail,Loginpwd;

    TextView registerlink;
    ImageButton Loginbtn;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Loginemail = findViewById(R.id.Loginemail);
        Loginpwd = findViewById(R.id.Loginpwd);
        Loginbtn = findViewById(R.id.Loginbtn);
        registerlink = findViewById(R.id.registerlink);

        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               firebaseAuth = FirebaseAuth.getInstance();
               firebaseAuth.signInWithEmailAndPassword(Loginemail.getText().toString(),Loginpwd.getText().toString()).addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()){
                           Toast.makeText(getApplicationContext(),"user successfully logged in",Toast.LENGTH_LONG).show();
                           Intent points = new Intent(getApplicationContext(), MainActivity.class);
                           startActivity(points);
                       }
                       else {
                           Toast.makeText(getApplicationContext(),"user not logged in",Toast.LENGTH_LONG).show();
                       }
                   }
               });
            }
        });

        registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_intent = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(register_intent);
            }
        });

    }
}