package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TareaDelListado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea_del_listado);
    }


    public void pVolver(View view) {
        finish();
    }

    public void mostrarTarea(String nombre, ArrayList<Tarea> arrayTareas){

        Tarea t = null;

        for(int i = 0; i<arrayTareas.size(); i++){

            if(arrayTareas.get(i).getNombre().equalsIgnoreCase(nombre)){

                t = arrayTareas.get(i);
                i = arrayTareas.size();
            }

        }

        TextView txtNombre = new TextView(this);
        txtNombre.setTextSize(40);
        txtNombre.setText(t.getNombre());

        TextView txtDescripcion = new TextView(this);
        txtDescripcion.setTextSize(30);
        txtDescripcion.setText(t.getDescripcion());

        TextView txtFecha = new TextView(this);
        txtFecha.setTextSize(30);
        txtFecha.setText(t.getFecha());

        TextView txtPrioridad = new TextView(this);
        txtPrioridad.setTextSize(30);
        txtPrioridad.setText(t.getPrioridad());

        TextView txtCoste = new TextView(this);
        txtCoste.setTextSize(30);
        txtCoste.setText("Tiene un coste de: "+t.getCoste());



    }
}