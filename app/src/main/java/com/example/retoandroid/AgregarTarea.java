package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
        Intent i = new Intent(this, ListadoDeTareas.class );
        startActivity(i);
        finish();
    }

    public void onClickBotonGuardar() {

        validarDatos();

    }

    public void validarDatos(){

        boolean validado = true;

        Toast notificacion=Toast.makeText(this,"Faltan campos por rellenar",Toast.LENGTH_LONG);

        if(nTarea.getText().toString().equals("") || descripcion.getText().toString().equals("") || fecha.getText().toString().equals("") || coste.getText().toString().equals("")){

            validado = false;
        }

        if(!hecha.isChecked() && !sinhacer.isChecked()){

            validado = false;
        }


        if(validado){

            registrarDatos();
        }else{

            notificacion.show();

        }


    }

    public void registrarDatos(){

        AdminSQLiteOpenHelper sql = new AdminSQLiteOpenHelper(this,"bd_tareas",null,1);

        SQLiteDatabase db = sql.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("nombre",nTarea.getText().toString());
        cv.put("descripcion",descripcion.getText().toString());
        cv.put("fecha",fecha.getText().toString());
        cv.put("coste",coste.getText().toString());
        cv.put("prioridad",spinner.getSelectedItem().toString());

        if(hecha.isChecked()){

            cv.put("estado","Hecha");

        }else{

            cv.put("estado","Sin hacer");

        }

        long newRowId = db.insert("tareas", null, cv);


        Toast notificacion=Toast.makeText(this,"Actividad registrada",Toast.LENGTH_LONG);

        notificacion.show();

        Intent i = new Intent(this, ListadoDeTareas.class );
        startActivity(i);
        finish();

    }



}