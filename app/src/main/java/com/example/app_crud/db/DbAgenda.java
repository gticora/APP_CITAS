package com.example.app_crud.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.app_crud.entidades.Agenda;

import java.util.ArrayList;

public class DbAgenda extends DbHelper {

    Context context;

    public DbAgenda(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarAgenda(String nombre, String telefono, String correo_electronico, String motivo, String fecha){

        long id = 0;

        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            /*funcion que inserta registro*/
            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo_electronico);
            values.put("fecha", fecha);
            values.put("motivo", motivo);
            id = db.insert(TABLE_AGENDA, null, values);

        } catch (Exception ex){
            ex.toString();
        }

        return id;
    }

    public ArrayList<Agenda> mostrarAgenda (){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Agenda> listaAgenda = new ArrayList<>();
        Agenda angenda = null;
        Cursor cursoragenda = null;

        cursoragenda = db.rawQuery("SELECT * FROM " + TABLE_AGENDA, null);

        if(cursoragenda.moveToFirst()){
            do{
                angenda = new Agenda();
                angenda.setId(cursoragenda.getInt(0));
                angenda.setNombres(cursoragenda.getString(1));
                angenda.setTelefono(cursoragenda.getString(2));
                angenda.setCorreo_electronico(cursoragenda.getString(3));
                angenda.setMotivo(cursoragenda.getString(4));
                angenda.setFecha(cursoragenda.getString(5));
                listaAgenda.add(angenda);
            }while (cursoragenda.moveToNext());
        }

        cursoragenda.close();

        return listaAgenda;

    }
}
