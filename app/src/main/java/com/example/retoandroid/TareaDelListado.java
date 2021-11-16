package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;

public class TareaDelListado extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_del_listado);

    mostrarTarea();

    }


    public void pVolver(View view) {
        finish();
    }


    public void mostrarTarea(){


        ArrayList<Tarea> arrayTareas = getIntent().getExtras().getParcelableArrayList("miArray");
        String nombre = getIntent().getExtras().getString("nombre");

        Tarea t = null;

        for(int i = 0; i<arrayTareas.size(); i++){

            if(arrayTareas.get(i).getNombre().equals(nombre)){


                t = arrayTareas.get(i);
                i = arrayTareas.size();

            }



        }


        if(t!=null){

            TextView txtNombre = findViewById(R.id.textViewNombreTarea);
            txtNombre.setText(t.getNombre().toString());

            TextView txtDescripcion = findViewById(R.id.textViewDescripcion);
            txtDescripcion.setText(t.getDescripcion());

            TextView txtFecha = findViewById(R.id.textViewFechaTarea);
            txtFecha.setText(t.getFecha());

            TextView txtPrioridad = findViewById(R.id.textViewPrioridad);
            txtPrioridad.setText(t.getPrioridad());

            TextView txtCoste = findViewById(R.id.textViewPrecioTarea);
            txtCoste.setText("Tiene un coste de: "+t.getCoste() + " €");

        }





    }
}