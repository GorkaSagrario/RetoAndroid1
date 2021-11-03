package com.example.retoandroid;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
}
