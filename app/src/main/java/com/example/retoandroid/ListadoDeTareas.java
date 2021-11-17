package com.example.retoandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;



public class ListadoDeTareas extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TareaDelListado t = new TareaDelListado();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_de_tareas);
        AdminSQLiteOpenHelper sql = new AdminSQLiteOpenHelper(this,"bd_tareas",null,1);
        ArrayList<Tarea> arrayTareas = sql.fetchAllData();

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        layout.setOrientation(LinearLayout.VERTICAL);  //Can also be done in xml by android:orientation="vertical"

        Context c = this;




        for (int i = 0; i < arrayTareas.size(); i++) {
            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));


                TextView txt = new TextView(this);
                TextView br = new TextView(this);

                txt.setTextSize(20);
                br.setTextSize(15);

                txt.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {




                        Bundle b = new Bundle();
                        String nombre = txt.getText().toString();
                        Intent pantalla = new Intent(c, TareaDelListado.class);

                        b.putParcelableArrayList("miArray",arrayTareas);
                        b.putString("nombre",nombre);

                        pantalla.putExtras(b);

                        startActivity(pantalla);



                    }
                });

            txt.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v) {


                    registerForContextMenu(txt);

                    return false;
                }
            });

            txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                txt.setText(arrayTareas.get(i).getNombre());
                br.setText("\n");
                txt.setId(i + 1);
                row.addView(txt);
                row.addView(br);

            layout.addView(row);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()){

            case R.id.Modificar:

                

            case R.id.Eliminar:



        }

        return false;

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
            Intent i = new Intent(this, CambiarContrasena.class );
            startActivity(i);


        }
        if (id==R.id.acercaDe) {

        }
        if (id==R.id.desconectar) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



}