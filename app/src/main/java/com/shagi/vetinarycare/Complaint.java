package com.shagi.vetinarycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Complaint extends AppCompatActivity {

    EditText e1;
    SharedPreferences sharedPreferences;
    String mil,save;
    Button button;
    RegisterConstructor r1;
ComplaintConstrructor c1;
DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);




        reference= FirebaseDatabase.getInstance().getReference().child("Complaint");

        sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        save=sharedPreferences.getString("email",null);
        mil=save;
        SharedPreferences.Editor preference = getSharedPreferences("Pet", MODE_PRIVATE).edit();
        preference.putString("target",mil);
        preference.commit();

        c1=new ComplaintConstrructor();
        r1=new RegisterConstructor();
        e1=(EditText)findViewById(R.id.complaintapp);
        button=(Button)findViewById(R.id.register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String compl=e1.getText().toString();
                c1.setComplaint(compl);
                c1.setEmail(mil);
                reference.push().setValue(c1);
            }
        });
    }
}
