package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CambiarContrasena extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_contrasena);
    }

    public void onClickBotonCambiar(){

        String contraVieja = findViewById(R.id.idContraAnterior).toString();
        String contraNueva = findViewById(R.id.idContraNueva).toString();
        MainActivity m = new MainActivity();
    if(comprobarContrasena(contraVieja)){

        m.setLogin(m.getLoginUsuario(),contraNueva);

    }


    }

    public boolean comprobarContrasena(String contrasenaActual_1){

        MainActivity m = new MainActivity();
       String contrasenaActual_2 = m.getLoginContraseña();
       boolean validado = false;

        if(contrasenaActual_1.equalsIgnoreCase(contrasenaActual_2) && findViewById(R.id.idContraNueva).toString()!=""){

        validado = true;

        }

        return validado;

    }
}