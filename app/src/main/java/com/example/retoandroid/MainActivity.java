package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView et_N ;
    private TextView et_P;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_P = findViewById(R.id.eT_P);
        et_N = findViewById(R.id.eT_N);
    }
    public void pInicial(View view) {
        Intent i = new Intent(this, Pantalla_Inicial.class );
        startActivity(i);
    }
}