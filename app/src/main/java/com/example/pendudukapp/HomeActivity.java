package com.example.pendudukapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText dp,nik,nama,tempat,alamat;
    RadioGroup jk,status,job;
    RadioButton namaJk, namaStatus,namaJob;
    Calendar calendar;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        dp = findViewById(R.id.txtDate);
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateCalendar();
            }
            private void updateCalendar(){
                String Format = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.US);
                dp.setText(sdf.format(calendar.getTime()));

            }
        };

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(HomeActivity.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        nik = findViewById(R.id.txtNik);
        nama = findViewById(R.id.txtNama);
        tempat = findViewById(R.id.txtTempat);
        alamat = findViewById(R.id.txtAlamat);
        dp = findViewById(R.id.txtDate);
        jk = findViewById(R.id.txtJk);
        job = findViewById(R.id.txtJob);
        status = findViewById(R.id.txtStatus);
        send = findViewById(R.id.btnSubmit);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioId = jk.getCheckedRadioButtonId();
                namaJk = (RadioButton) findViewById(radioId);
                int radioId2 = status.getCheckedRadioButtonId();
                namaStatus = (RadioButton) findViewById(radioId2);
                int radioId3 = job.getCheckedRadioButtonId();
                namaJob = (RadioButton) findViewById(radioId3);
                Intent i = new Intent(HomeActivity.this,DataActivity.class);
                i.putExtra("nik", nik.getText().toString());
                i.putExtra("nama", nama.getText().toString());
                i.putExtra("tempat", tempat.getText().toString());
                i.putExtra("dp", dp.getText().toString());
                i.putExtra("alamat", alamat.getText().toString());
                i.putExtra("jk", namaJk.getText().toString());
                i.putExtra("job", namaJob.getText().toString());
                i.putExtra("status", namaStatus.getText().toString());
            startActivity(i);

                nik.setText("");
                nama.setText("");
                tempat.setText("");
                dp.setText("");
                alamat.setText("");
                jk.clearCheck();
                job.clearCheck();
                status.clearCheck();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

        }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}