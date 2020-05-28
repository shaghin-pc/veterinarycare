package com.shagi.vetinarycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class notification_view extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<NotificationConstructor> application_list;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);

        recyclerView=(RecyclerView)findViewById(R.id.notificationview);
        recyclerView.setHasFixedSize(true);
        application_list=new ArrayList<>();
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Applications");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot studentDatasnapshot:dataSnapshot.getChildren())
                {
                    NotificationConstructor notificationConstructor=studentDatasnapshot.getValue(NotificationConstructor.class);
                    application_list.add(notificationConstructor);

                }
                adapter=new NotificationAdapter(application_list,getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
