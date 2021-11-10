package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView et_N ;
    private TextView et_P;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences("sharedprefs", Context.MODE_PRIVATE);
        et_P = findViewById(R.id.eT_P);
        et_N = findViewById(R.id.eT_N);
        if (getLoginContraseña() == "") {
            setLogin("Admin", "1234");
        }
        getSupportActionBar().hide();

        AdminSQLiteOpenHelper sql = new AdminSQLiteOpenHelper(this,"bd_tareas",null,1);


    }
    public void pInicial(View view) {
        Intent i = new Intent(this, ListadoDeTareas.class );
        et_P = findViewById(R.id.eT_P);
        et_N = findViewById(R.id.eT_N);
        Toast notificacion= Toast.makeText(this,"Usuario o contraseña erróneos",Toast.LENGTH_LONG);

        if(et_N.getText().toString().equals(getLoginUsuario()) && et_P.getText().toString().equals(getLoginContraseña())){
            startActivity(i);
        }else{
            notificacion.show();
        }


    }

    public void setLogin(String usuario, String contraseña){

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",usuario);
        editor.putString("pass",contraseña);

        editor.apply();
    }

    public String getLoginUsuario(){

        String usuario = preferences.getString("user","");
        return usuario;

    }

    public String getLoginContraseña(){

        String contraseña = preferences.getString("pass","");

        return contraseña;

    }


}