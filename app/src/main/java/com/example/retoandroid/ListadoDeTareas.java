package com.example.retoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
                txt.setTextSize(20);

                txt.setOnLongClickListener(new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View v) {




                        Bundle b = new Bundle();
                        String nombre = txt.getText().toString();
                        Intent pantalla = new Intent(c, TareaDelListado.class);

                        b.putParcelableArrayList("miArray",arrayTareas);
                        b.putString("nombre",nombre);

                        pantalla.putExtras(b);

                        startActivity(pantalla);


                        return false;
                    }
                });

            txt.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                txt.setText(arrayTareas.get(i).getNombre());
                txt.setId(i + 1);
                row.addView(txt);

            layout.addView(row);
        }

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