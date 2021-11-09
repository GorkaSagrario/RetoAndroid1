package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuNavegacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_navegacion);
    }

    public void crearTarea(View view) {
        Intent i = new Intent(this, AgregarTarea.class );
        startActivity(i);
    }

    public void ListadoDeTarea(View view) {
        Intent i = new Intent(this, ListadoDeTareas.class );
        startActivity(i);
    }
}