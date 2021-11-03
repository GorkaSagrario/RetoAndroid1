package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class AgregarTarea extends AppCompatActivity {
    private TextView nTarea;
    private TextView descripcion;
    private TextView fecha;
    private TextView coste;
    private Spinner spinner;
    private RadioButton hecha;
    private RadioButton sinhacer;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicial);
        getSupportActionBar().hide();

        enviar = findViewById(R.id.botonEnviar);
        
        nTarea = findViewById(R.id.eT_NTarea);
        descripcion = findViewById(R.id.etDescripcion);
        fecha = findViewById(R.id.et_fecha);
        coste = findViewById(R.id.eT_Coste);

        spinner =findViewById(R.id.spinner);
        String []option={"Urgente","Alta","Media","Baja"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, option);
        spinner.setAdapter(adapter);

        hecha = findViewById(R.id.radioHecha);
        sinhacer = findViewById(R.id.radioSinHacer);

        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickBotonGuardar();
            }
        });



    }
    public void pLogin(View view) {
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }

    public void onClickBotonGuardar() {




    }

}