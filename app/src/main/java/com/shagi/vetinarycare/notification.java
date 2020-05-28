package com.shagi.vetinarycare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class notification extends AppCompatActivity {

    Spinner ItemName,BankName;
    EditText Branch,Ifsc,AccountNo,AnnualIncome,Mainjob;
    RadioGroup Scst,Bpl,Women,Handcap,Girl,Befor;
    RadioButton scstY,scstN,womenY,womenN,bplY,bplN,handcapY,handcapN,girlY,girlN,beforY,beforN;
    String itemname,bankname,branch,ifsc,accountno,annualincome,mainjob,scst,bpl,women,handcap,girl,before;
    Button submit;
    NotificationConstructor n1;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        n1=new NotificationConstructor();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Applications");



        Branch=(EditText)findViewById(R.id.Branch);
        Ifsc=(EditText)findViewById(R.id.Ifsc);
        AccountNo=(EditText)findViewById(R.id.AccountNo);
        AnnualIncome=(EditText)findViewById(R.id.AnnualIncome);
        Mainjob=(EditText)findViewById(R.id.MainJob);

        Scst=(RadioGroup)findViewById(R.id.scst);
        Bpl=(RadioGroup)findViewById(R.id.bpl);
        Women=(RadioGroup)findViewById(R.id.Women);
        Handcap=(RadioGroup)findViewById(R.id.Handcap);
        Girl=(RadioGroup)findViewById(R.id.Girl);
        Befor=(RadioGroup)findViewById(R.id.Befor);

        ItemName=(Spinner)findViewById(R.id.ItemName);
        BankName=(Spinner)findViewById(R.id.BankName);

        submit=(Button)findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                itemname=ItemName.getSelectedItem().toString();
                bankname=BankName.getSelectedItem().toString();
                branch=Branch.getText().toString();
                ifsc=Ifsc.getText().toString();
                accountno=AccountNo.getText().toString();
                annualincome=AnnualIncome.getText().toString();
                mainjob=Mainjob.getText().toString();

                int SCST=Scst.getCheckedRadioButtonId();
                scstN=(RadioButton)findViewById(SCST);
                scst=scstN.getText().toString();

                int BPL=Bpl.getCheckedRadioButtonId();
                bplN=(RadioButton)findViewById(BPL);
                bpl=bplN.getText().toString();

                int WOMEN=Women.getCheckedRadioButtonId();
                womenN=(RadioButton)findViewById(WOMEN);
                women=womenN.getText().toString();

                int HANDCAP=Handcap.getCheckedRadioButtonId();
                handcapN=(RadioButton)findViewById(HANDCAP);
                handcap=handcapN.getText().toString();

                int GIRL=Girl.getCheckedRadioButtonId();
                girlN=(RadioButton)findViewById(GIRL);
                girl=girlN.getText().toString();

                int BEFORE=Befor.getCheckedRadioButtonId();
                beforN=(RadioButton)findViewById(BEFORE);
                before=beforN.getText().toString();

                n1.setItemname(itemname);
                n1.setBankname(bankname);
                n1.setBranch(branch);
                n1.setIfsc(ifsc);
                n1.setAccountno(accountno);
                n1.setAnnualincome(annualincome);
                n1.setMainjob(mainjob);
                n1.setScst(scst);
                n1.setBpl(bpl);
                n1.setWomen(women);
                n1.setHandcap(handcap);
                n1.setGirl(girl);
                n1.setBefore(before);
                databaseReference.push().setValue(n1);

            }
        });
    }
}
