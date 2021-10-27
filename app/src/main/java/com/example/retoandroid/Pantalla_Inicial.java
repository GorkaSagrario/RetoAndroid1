package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Pantalla_Inicial extends AppCompatActivity {
    private TextView nTarea;
    private TextView descripcion;
    private TextView fecha;
    private TextView coste;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicial);

        nTarea = findViewById(R.id.eT_NTarea);
        descripcion = findViewById(R.id.etDescripcion);
        fecha = findViewById(R.id.et_fecha);
        coste = findViewById(R.id.eT_Coste);

        spinner =findViewById(R.id.spinner);
        String []option={"Urgente","Alta","Media","Baja"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, option);
        spinner.setAdapter(adapter);

    }
}