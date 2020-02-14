package com.shagi.vetinarycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogedIn extends AppCompatActivity {

    Button b1,b2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged_in);

        b1=(Button)findViewById(R.id.Baddpet);
        b2=(Button)findViewById(R.id.Binsurance);
        t1=(TextView) findViewById(R.id.logout);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),insurance.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Addpet.class);
                startActivity(intent);
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("Login",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
                Intent logout=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(logout);
            }
        });
    }
}
