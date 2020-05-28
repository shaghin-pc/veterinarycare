package com.shagi.vetinarycare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class Bath extends AppCompatActivity {

   private TextView textViewDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bath);

        textViewDate=(TextView)findViewById(R.id.date);

    }

    public void getDate(View v)
    {
        Calendar c=Calendar.getInstance();

        Date today=c.getTime();

        c.add(Calendar.DATE,3);
        c.add(Calendar.MONTH,1);
        c.add(Calendar.YEAR,1);

        Date future=c.getTime();



        textViewDate.setText(""+ future);
    }
}
