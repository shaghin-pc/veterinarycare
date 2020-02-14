package com.shagi.vetinarycare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12;
    Spinner s1;
    Button b1,b2,b3;
    String nme,ad,dis,talu,panch,war,hou,rat,adaa,mail,pho,pass,conf;
    RegisterConstructor c1;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        reference= FirebaseDatabase.getInstance().getReference().child("UserDetails");
        c1=new RegisterConstructor();
        e1=(EditText)findViewById(R.id.Name);
        e2=(EditText)findViewById(R.id.Address);
        s1=(Spinner)findViewById(R.id.District);
        e3=(EditText)findViewById(R.id.Taluk);
        e4=(EditText)findViewById(R.id.Panchayath);
        e5=(EditText)findViewById(R.id.Wardnumber);
        e6=(EditText)findViewById(R.id.HouseNumber);
        e7=(EditText)findViewById(R.id.Rationcard);
        e8=(EditText)findViewById(R.id.Adhaarcard);
        e9=(EditText)findViewById(R.id.Email);
        e10=(EditText)findViewById(R.id.Phonenumber);
        e11=(EditText)findViewById(R.id.Password);
        e12=(EditText)findViewById(R.id.Confirmpassword);
        b1=(Button)findViewById(R.id.Submit);
        b2=(Button)findViewById(R.id.SLogin);
        b3=(Button)findViewById(R.id.BSignup);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nme = e1.getText().toString();
                ad = e2.getText().toString();
                dis = s1.getSelectedItem().toString();
                talu = e3.getText().toString();
                panch = e4.getText().toString();
                war = e5.getText().toString();
                hou = e6.getText().toString();
                rat = e7.getText().toString();
                adaa = e8.getText().toString();
                mail = e9.getText().toString();
                pho = e10.getText().toString();
                pass = e11.getText().toString();
                conf = e12.getText().toString();
                if (nme.isEmpty()) {
                    e1.setError("requird");
                    e1.requestFocus();
                } else if (ad.isEmpty()) {
                    e2.setError("required");
                    e2.requestFocus();
                } else if (talu.isEmpty()) {
                    e3.setError("required");
                    e3.requestFocus();
                } else if (panch.isEmpty()) {
                    e4.setError("required");
                    e4.requestFocus();
                } else if (war.isEmpty()) {
                    e5.setError("required");
                    e5.requestFocus();
                } else if (hou.isEmpty()) {
                    e6.setError("required");
                    e6.requestFocus();
                } else if (rat.isEmpty()) {
                    e7.setError("required");
                    e7.requestFocus();
                } else if (adaa.isEmpty()) {
                    e8.setError("required");
                    e8.requestFocus();
                } else if (mail.isEmpty()) {
                    e9.setError("required");
                    e9.requestFocus();
                } else if (pho.isEmpty()) {
                    e10.setError("required");
                    e10.requestFocus();
                } else if (pass.isEmpty()) {
                    e11.setError("required");
                    e11.requestFocus();
                } else if (conf.isEmpty()) {
                    e12.setError("required");
                    e12.requestFocus();
                } else {
                    if (conf.equals(pass)) {

                        c1.setName(nme);
                        c1.setAddress(ad);
                        c1.setDistrict(dis);
                        c1.setTaluk(talu);
                        c1.setPanchayath(panch);
                        c1.setWard_no(war);
                        c1.setHouse_no(hou);
                        c1.setRationcard_no(rat);
                        c1.setAdhaar_no(adaa);
                        c1.setEmail(mail);
                        c1.setPhone_no(pho);
                        c1.setPassword(pass);
                        reference.push().setValue(c1);
                        Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), LogedIn.class);
                        startActivity(intent);
                        SharedPreferences.Editor preference = getSharedPreferences("Login", MODE_PRIVATE).edit();
                        preference.putString("email", mail);
                        preference.commit();

                    } else {
                        Toast.makeText(getApplicationContext(), "password is not correct", Toast.LENGTH_LONG).show();
                    }
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    e5.setText("");
                    e6.setText("");
                    e7.setText("");
                    e8.setText("");
                    e9.setText("");
                    e10.setText("");
                    e11.setText("");
                    e12.setText("");
                }
            }
        });
    }
}
