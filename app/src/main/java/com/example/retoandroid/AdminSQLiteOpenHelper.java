package com.example.retoandroid;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    final String CREAR_TABLA_TAREAS = "create table tareas (nombre text primary key, descripcion text, fecha text, coste text, prioridad text, estado text )";
    final String ELIMINAR_TABLA_TAREAS = "drop table if exists tareas";


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_TAREAS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionActual, int versionNueva) {
        db.execSQL(ELIMINAR_TABLA_TAREAS);
        db.execSQL(CREAR_TABLA_TAREAS);


    }

    public ArrayList<Tarea> fetchAllData(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from tareas", null, null);

        ArrayList <Tarea> arrayTareas = new ArrayList<>();

        String nombre = null;
        String descripcion = null;
        String fecha = null;
        String coste = null;
        String prioridad = null;
        String estado = null;

        while(c.moveToNext()){

            nombre = c.getString(0);
            descripcion = c.getString(1);
            fecha = c.getString(2);
            coste = c.getString(3);
            prioridad = c.getString(4);
            estado = c.getString(5);
            Tarea t = new Tarea(nombre,descripcion,fecha,coste,prioridad,estado);
            arrayTareas.add(t);
        }

        return arrayTareas;




    }
}
