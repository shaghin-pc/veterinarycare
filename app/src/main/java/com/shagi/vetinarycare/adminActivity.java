package com.shagi.vetinarycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class adminActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    String admin,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        e1=(EditText)findViewById(R.id.Ladmin);
        e2=(EditText)findViewById(R.id.Lpassword);
        b1=(Button)findViewById(R.id.BLogin);

        admin=e1.getText().toString();
        pass=e2.getText().toString();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),AdminLogedIn.class);
                startActivity(intent);

            }
        });
    }
}
