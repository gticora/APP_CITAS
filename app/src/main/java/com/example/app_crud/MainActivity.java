package com.example.app_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_crud.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button btnCrearBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrearBase = findViewById(R.id.btnCrearBase);

        btnCrearBase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR LA BASE DE DATOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button btnCrearAgenda = (Button) findViewById(R.id.btnCrearAgenda);

        btnCrearAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_crear = new Intent(MainActivity.this, CrearActivity.class);
                startActivity(intent_crear);
            }
        });

        Button btnConsulta = (Button) findViewById(R.id.btnConsulta);

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_consulta = new Intent(MainActivity.this, ListarActivity.class);
                startActivity(intent_consulta);
            }
        });

    }

}