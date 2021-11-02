package com.example.retoandroid;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    final String CREAR_TABLA_TAREAS = "create table tareas (nombre text primary key, descripcion text, fecha text, coste double, prioridad text, estado text )";


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREAR_TABLA_TAREAS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionActual, int versionNueva) {

    }
}
