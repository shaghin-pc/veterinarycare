package com.shagi.vetinarycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2,b3;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reference= FirebaseDatabase.getInstance().getReference().child("UserDetails");
        e1=(EditText) findViewById(R.id.Lemail);
        e2=(EditText) findViewById(R.id.Lpassword);
        b1=(Button) findViewById(R.id.BLogin);
        b2=(Button) findViewById(R.id.BSignup);
        b3=(Button) findViewById(R.id.SLogin);

        SharedPreferences preferences=getSharedPreferences("Login",MODE_PRIVATE);
        String value=preferences.getString("email",null);
        if(value!=null)
        {
            Intent in=new Intent(getApplicationContext(),LogedIn.class);
            startActivity(in);
        }

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignupActivity.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String mail = e1.getText().toString();
                final String pass = e2.getText().toString();
                if (mail.isEmpty()) {
                    e1.setError("please enter Email-id");
                    e1.requestFocus();
                } else if (pass.isEmpty()) {
                    e2.setError("required");
                    e2.requestFocus();
                } else {
                    Query query = reference.orderByChild("email").equalTo(mail);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot loginSnapshot : dataSnapshot.getChildren()) {
                                RegisterConstructor login = loginSnapshot.getValue(RegisterConstructor.class);
                                String password = login.Password;
                                String mail = login.Email;
                                if (pass.equals(password)) {
                                    Toast.makeText(getApplicationContext(), "Loged in successfully", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), LogedIn.class);
                                    SharedPreferences.Editor preference = getSharedPreferences("Login", MODE_PRIVATE).edit();
                                    preference.putString("email",mail);
                                    preference.commit();
                                    startActivity(intent);
                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });
    }
}
