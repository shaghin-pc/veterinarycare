package com.shagi.vetinarycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminLogedIn extends AppCompatActivity {

    Button user,pet,complaint,notify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_loged_in);

        user=(Button)findViewById(R.id.Buseretails);
        pet=(Button)findViewById(R.id.Bpetdetails);
        complaint=(Button)findViewById(R.id.Bcomplaints);
        notify=(Button)findViewById(R.id.Bnotify);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),UserView.class);
                startActivity(intent);
            }
        });
        pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),PetDetailsView.class);
                startActivity(intent);
            }
        });
        complaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ComplaintsView.class);
                startActivity(intent);
            }
        });
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),notification_view.class);
                startActivity(intent);
            }
        });


    }
}
