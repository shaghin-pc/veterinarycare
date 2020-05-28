package com.shagi.vetinarycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewPet extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    List<PetConstructor> my_list;
    String save,maile,type;
    DatabaseReference reference,ref;
    SharedPreferences sharedPreferences;
    PetConstructor p1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pet);

        recyclerView=(RecyclerView)findViewById(R.id.petcycle);
        recyclerView.setHasFixedSize(true);

        my_list=new ArrayList<>();

        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        reference= FirebaseDatabase.getInstance().getReference().child("PetDetails");


        sharedPreferences=getSharedPreferences("Pet",MODE_PRIVATE);
        save=sharedPreferences.getString("target",null);


        ref=FirebaseDatabase.getInstance().getReference().child("PetDetails");
        Query query = ref.orderByChild("email").equalTo(save);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            for (DataSnapshot petDatasnapshot : dataSnapshot.getChildren()) {
                                PetConstructor pet = petDatasnapshot.getValue(PetConstructor.class);
                                maile=pet.mail;
                                if(save.equals(maile)){
                                    String a=pet.Type;
                                    Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();

                                    SharedPreferences.Editor preference = getSharedPreferences("PET", MODE_PRIVATE).edit();
                                    preference.putString("type",a);
                                    preference.commit();
                                my_list.add(pet);}

                            }


                            adapter = new PetAdapter(my_list, getApplicationContext());
                            recyclerView.setAdapter(adapter);
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });






    }
}
