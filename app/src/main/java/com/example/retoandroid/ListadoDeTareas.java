package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ListadoDeTareas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_de_tareas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.nTarea) {
            Intent i = new Intent(this, AgregarTarea.class );
            startActivity(i);
        }
        if (id==R.id.cPass) {

        }
        if (id==R.id.acercaDe) {

        }
        if (id==R.id.desconectar) {
            Intent i = new Intent(this, MainActivity.class );
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}