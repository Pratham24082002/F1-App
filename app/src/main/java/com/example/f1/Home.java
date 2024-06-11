package com.example.f1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends AppCompatActivity {
ImageButton carbtn;

Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        carbtn=findViewById(R.id.carbtn);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        carbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.profile){
            Toast.makeText(getApplicationContext(),"Profile Selected",Toast.LENGTH_LONG).show();
            Intent profileintent = new Intent(getApplicationContext(), Profile.class);
           startActivity(profileintent);
        }
        if (id==R.id.editprofile){
            Intent editintent = new Intent(getApplicationContext(), EditProfile.class);
            startActivity(editintent);
        }
        return true;
    }
}