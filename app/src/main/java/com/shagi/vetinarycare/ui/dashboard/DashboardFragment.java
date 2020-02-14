package com.shagi.vetinarycare.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.shagi.vetinarycare.PetConstructor;
import com.shagi.vetinarycare.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    EditText e1,e2,e3,e4;
    Spinner s1;
    Button b1;
    String typ,ayg,colo,sx,id;
    PetConstructor p1;
    DatabaseReference reference;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        reference= FirebaseDatabase.getInstance().getReference().child("PetDetails");
        p1=new PetConstructor();
        e1=(EditText)root.findViewById(R.id.petType);
        e2=(EditText)root.findViewById(R.id.petAge);
        e3=(EditText)root.findViewById(R.id.petColor);
        s1=(Spinner)root.findViewById(R.id.petSex);
        e4=(EditText)root.findViewById(R.id.petIdMark);
        b1=(Button)root.findViewById(R.id.Baddpet);



        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        typ=e1.getText().toString();
                        ayg=e2.getText().toString();
                        colo=e3.getText().toString();
                        sx=s1.getSelectedItem().toString();
                        id=e4.getText().toString();

                        p1.setType(typ);
                        p1.setAge(ayg);
                        p1.setColor(colo);
                        p1.setSex(sx);
                        p1.setIdentifyMark(id);
                        reference.push().setValue(p1).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isComplete())
                                {
                                    Toast.makeText(getActivity(),"Pet Added Success Fully",Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    Toast.makeText(getActivity(),"failed",Toast.LENGTH_LONG).show();
                                }
                            }
                        });

                    }
                });
                    }
                });
        return root;
    }
}