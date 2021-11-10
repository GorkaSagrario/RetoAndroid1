package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CambiarContrasena extends AppCompatActivity {
    private MainActivity m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasena);
        m = new MainActivity();
    }

    public void onClickBotonCambiar(View view){

        String contraVieja = findViewById(R.id.idContraAnterior).toString();
        String contraNueva = findViewById(R.id.idContraNueva).toString();

    if(comprobarContrasena(contraVieja)){


        m.setLogin(m.getLoginUsuario(),contraNueva);

        finish();
    }


    }

    public boolean comprobarContrasena(String contrasenaActual_1){

       String contrasenaActual_2 = m.getLoginContraseña();
       boolean validado = false;

        if(contrasenaActual_1.equalsIgnoreCase(contrasenaActual_2) && findViewById(R.id.idContraNueva).toString()!=""){

        validado = true;

        }

        return validado;

    }
}