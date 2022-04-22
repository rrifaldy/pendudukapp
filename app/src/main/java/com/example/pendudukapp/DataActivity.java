package com.example.pendudukapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        String nik = getIntent().getExtras().getString("nik");
        String nama = getIntent().getExtras().getString("nama");
        String tempat = getIntent().getExtras().getString("tempat");
        String dp = getIntent().getExtras().getString("dp");
        String alamat = getIntent().getExtras().getString("alamat");
        String jk = getIntent().getExtras().getString("jk");
        String job = getIntent().getExtras().getString("job");
        String status = getIntent().getExtras().getString("status");

        result = findViewById(R.id.tampilNik);
        result.setText(nik);
        result = findViewById(R.id.tampilNama);
        result.setText(nama);
        result = findViewById(R.id.tampilLahir);
        result.setText(tempat);
        result = findViewById(R.id.tampilDate);
        result.setText(dp);
        result = findViewById(R.id.tampilAlamat);
        result.setText(alamat);
        result = findViewById(R.id.tampilJk);
        result.setText(jk);
        result = findViewById(R.id.tampilJob);
        result.setText(job);
        result = findViewById(R.id.tampilStatus);
        result.setText(status);
    }

        public void Back (View view){
            Intent i = new Intent(DataActivity.this, HomeActivity.class);
            startActivity(i);
        }
}