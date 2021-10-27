package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        setLogin("Admin","1234");


    }
    public void pInicial(View view) {
        Intent i = new Intent(this, Pantalla_Inicial.class );
        startActivity(i);
    }

    public void setLogin(String usuario, String contraseña){


        SharedPreferences preferences=getSharedPreferences("sharedprefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",usuario);
        editor.putString("pass",contraseña);
    }

    public String getLoginUsuario(){

        SharedPreferences preferences=getSharedPreferences("sharedprefs", Context.MODE_PRIVATE);
        String usuario = preferences.getString("user","");


        return usuario;

    }

    public String getLoginContraseña(){

        SharedPreferences preferences=getSharedPreferences("sharedprefs", Context.MODE_PRIVATE);
        String contraseña = preferences.getString("pass","");


        return contraseña;

    }


}