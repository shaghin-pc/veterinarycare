package com.shagi.vetinarycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    TextView t1,t2;
    SharedPreferences sharedPreferences;
    DatabaseReference reference;
    String save,mil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        reference= FirebaseDatabase.getInstance().getReference().child("UserDetails");
        t1=(TextView)findViewById(R.id.proName);
        t2=(TextView)findViewById(R.id.proPhone);

        sharedPreferences=getSharedPreferences("Login",MODE_PRIVATE);
        save=sharedPreferences.getString("email",null);

        mil=save;

        Query query=reference.orderByChild("email").equalTo(mil);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot studentdatasnapshot:dataSnapshot.getChildren())
                {
                    RegisterConstructor studentModel=studentdatasnapshot.getValue(RegisterConstructor.class);
                    String nme=studentModel.Name;
                    String phone=studentModel.Phone_no;

                   // String img=studentModel.profilepic;

                    t1.setText(nme);
                    t2.setText(phone);

                 //   Picasso.with(getActivity()).load(img).into(images);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
