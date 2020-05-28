package com.shagi.vetinarycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class otp_verification extends AppCompatActivity {

    RegisterConstructor c1;
    String nme,ad,dis,talu,panch,war,hou,rat,adaa,mail,pho,pass,verificationcode;
    EditText editText;
    Button button;
    FirebaseAuth mAuth;
    DatabaseReference reference;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        editText=(EditText)findViewById(R.id.signupOTP);
        button=(Button)findViewById(R.id.signupOTP_verificationButton);

        mAuth=FirebaseAuth.getInstance();
        progressBar=(ProgressBar)findViewById(R.id.progressbar);

        c1=new RegisterConstructor();

        reference= FirebaseDatabase.getInstance().getReference().child("UserDetails");

        Intent intent=getIntent();
        nme=intent.getStringExtra("nme");
        ad=intent.getStringExtra("ad");
        dis=intent.getStringExtra("dis");
        talu=intent.getStringExtra("talu");
        panch=intent.getStringExtra("panch");
        war=intent.getStringExtra("war");
        hou=intent.getStringExtra("hou");
        rat=intent.getStringExtra("rat");
        adaa=intent.getStringExtra("adaa");
        mail=intent.getStringExtra("mail");
        pho=intent.getStringExtra("pho");
        pass=intent.getStringExtra("pass");



        sendVerificationCode(pho);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String code=editText.getText().toString().trim();
                if (code.isEmpty()||code.length()<6)
                {
                    editText.setError("Enter code...!");
                    editText.requestFocus();
                    return;
                }
                verfyCode(code);

            }
        });

    }
    public void verfyCode(String code)
    {
        editText.setText(code);
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(verificationcode, code);
        signInWithCredential(credential);
    }
    void signInWithCredential(PhoneAuthCredential credential)
    {
        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if (task.isSuccessful())
                {


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

                    reference.push().setValue(c1).addOnSuccessListener(new OnSuccessListener<Void>()
                    {
                        @Override
                        public void onSuccess(Void aVoid)
                        {
                            Toast.makeText(getApplicationContext(), "Sucessfully Registered", Toast.LENGTH_SHORT).show();
                        }
                    });

                    Intent intent = new Intent(getApplicationContext(), LogedIn.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }

            }
        });
    }

    public void sendVerificationCode(String num)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(num,30, TimeUnit.SECONDS,this,mCallBack);

    }
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
        {
            String code=phoneAuthCredential.getSmsCode();
            if (code!=null)
            {
                progressBar.setVisibility(View.VISIBLE);
                verfyCode(code);
            }

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationcode=s;
        }

        @Override
        public void onVerificationFailed(FirebaseException e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    };

}
