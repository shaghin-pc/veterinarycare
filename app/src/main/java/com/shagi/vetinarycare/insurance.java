package com.shagi.vetinarycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insurance extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    Button b1;
    Spinner s1,s2;
    String tag,specious,sex,colr,idmrk,mlk,age,heit,noclv,calvdate,pregn;
    InsureConstructor c1;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);

        c1=new InsureConstructor();
        reference= FirebaseDatabase.getInstance().getReference().child("InsureDetails");

        e1=(EditText)findViewById(R.id.Eartag);
        e2=(EditText)findViewById(R.id.Species);
        s1=(Spinner)findViewById(R.id.petSex);
        e3=(EditText)findViewById(R.id.color);
        e4=(EditText)findViewById(R.id.Idmark);
        e5=(EditText)findViewById(R.id.Milk);
        e6=(EditText)findViewById(R.id.age);
        e7=(EditText)findViewById(R.id.height);
        e8=(EditText)findViewById(R.id.nofcalv);
        e9=(EditText)findViewById(R.id.calvingDate);
        s2=(Spinner)findViewById(R.id.pregnant);
        b1=(Button)findViewById(R.id.submit);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag=e1.getText().toString();
                specious=e2.getText().toString();
                sex=s1.getSelectedItem().toString();
                colr=e3.getText().toString();
                idmrk=e4.getText().toString();
                mlk=e5.getText().toString();
                age=e6.getText().toString();
                heit=e7.getText().toString();
                noclv=e8.getText().toString();
                calvdate=e9.getText().toString();
                pregn=s2.getSelectedItem().toString();

                if(tag.isEmpty())
                {
                    e1.setError("Tag number required");
                    e1.requestFocus();
                }
                else if (specious.isEmpty())
                {
                    e2.setError("Species required");
                    e2.requestFocus();
                }else if (colr.isEmpty())
                {
                    e3.setError("Color required");
                    e3.requestFocus();
                }else if (idmrk.isEmpty())
                {
                    e4.setError("Identification mark  required");
                    e4.requestFocus();
                }else if (mlk.isEmpty())
                {
                    e2.setError("Milk Quantity required");
                    e2.requestFocus();
                }else if (age.isEmpty())
                {
                    e2.setError("Age required");
                    e2.requestFocus();
                }else if (heit.isEmpty())
                {
                    e2.setError("Height required");
                    e2.requestFocus();
                }
                else{
                    c1.setEarTag_no(tag);
                    c1.setSpecies(specious);
                    c1.setPetSex(sex);
                    c1.setColor(colr);
                    c1.setIdentification_Mark(idmrk);
                    c1.setMilk_Per_Day(mlk);
                    c1.setAge(age);
                    c1.setHeight(heit);
                    c1.setNo_of_Calves(noclv);
                    c1.setLast_Calving_Date(calvdate);
                    c1.setPregnency(pregn);
                    reference.push().setValue(c1).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isComplete())
                            {
                                Toast.makeText(getApplicationContext(), "Request will be process", Toast.LENGTH_LONG).show();
                            }else {
                                Toast.makeText(getApplicationContext(), "Something is went Wrong", Toast.LENGTH_LONG).show();

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
                        }
                    });
                }
            }
        });

    }
}
