package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CambiarContrasena extends AppCompatActivity {
    private SharedPreferences p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasena);

    }

    public void onClickBotonCambiar(View view) {

        TextView TVcontraVieja = findViewById(R.id.idContraAnterior);
        TextView TVcontraNueva = findViewById(R.id.idContraNueva);

        String contraVieja = String.valueOf(TVcontraVieja.getText()) ;
        String contraNueva = String.valueOf(TVcontraNueva.getText());

        p = getSharedPreferences("sharedprefs", Context.MODE_PRIVATE);


    TextView tv = findViewById(R.id.textView5);
    tv.setText(contraVieja);

    if(comprobarContrasena(contraVieja,contraNueva)){
        setLogin(getLoginUsuario(),contraNueva);
        finish();
    }

    }


    public boolean comprobarContrasena(String contraVieja, String contraNueva){
        boolean validado = false;
        if(contraVieja.equals(getLoginContraseña()) && contraNueva != ""){
        validado = true;
        }
        return validado;
    }

    public void setLogin(String usuario, String contraseña){
        SharedPreferences.Editor editor = p.edit();
        editor.putString("user",usuario);
        editor.putString("pass",contraseña);
        editor.apply();
    }

    public String getLoginUsuario(){
        String usuario = p.getString("user","");
        return usuario;
    }

    public String getLoginContraseña(){
        String contraseña = p.getString("pass","");
        return contraseña;
    }
}