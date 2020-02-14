package com.shagi.vetinarycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Addpet extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    TextView t1;
    Spinner s1;
    Button b1,b2;
    String typ,ayg,colo,sx,id,save,mil;
    PetConstructor p1;
    RegisterConstructor c1;
    DatabaseReference reference;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpet);

        reference=FirebaseDatabase.getInstance().getReference().child("PetDetails");

        sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        save=sharedPreferences.getString("email",null);
        mil=save;
        SharedPreferences.Editor preference = getSharedPreferences("Pet", MODE_PRIVATE).edit();
        preference.putString("target",mil);
        preference.commit();
        p1=new PetConstructor();
        c1=new RegisterConstructor();
        e1=(EditText)findViewById(R.id.petType);
        e2=(EditText)findViewById(R.id.petAge);
        e3=(EditText)findViewById(R.id.petColor);
        s1=(Spinner)findViewById(R.id.petSex);
        e4=(EditText)findViewById(R.id.petIdMark);
        t1=(TextView)findViewById(R.id.mail);
        b1=(Button)findViewById(R.id.Baddpet);
        b2=(Button)findViewById(R.id.Bviewpet);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ViewPet.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typ = e1.getText().toString();
                ayg = e2.getText().toString();
                colo = e3.getText().toString();
                sx = s1.getSelectedItem().toString();
                id = e4.getText().toString();
                t1.setText(mil);
                if (typ.isEmpty()) {
                    e1.setError("type required");
                    e1.requestFocus();
                } else if (ayg.isEmpty()) {
                    e2.setError("age required");
                    e2.requestFocus();
                } else if (colo.isEmpty()) {
                    e3.setError("age required");
                    e3.requestFocus();
                } else if (id.isEmpty()) {
                    e4.setError("age required");
                    e4.requestFocus();
                } else {

                    p1.setType(typ);
                    p1.setAge(ayg);
                    p1.setColor(colo);
                    p1.setSex(sx);
                    p1.setIdentifyMark(id);
                    p1.setMail(mil);

                    reference.push().setValue(p1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isComplete()) {
                                Toast.makeText(getApplicationContext(), "Pet Added Success Fully", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "failed", Toast.LENGTH_LONG).show();
                            }
                            e1.setText("");
                            e2.setText("");
                            e3.setText("");
                            e4.setText("");

                        }
                    });

                }
            }
        });
    }
}
