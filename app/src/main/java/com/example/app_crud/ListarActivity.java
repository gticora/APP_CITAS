package com.example.app_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app_crud.adaptadores.ListaAgendaAdapter;
import com.example.app_crud.db.DbAgenda;
import com.example.app_crud.entidades.Agenda;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {

    RecyclerView listaAgenda;

    ArrayList<Agenda> listaArrayAgenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        listaAgenda = findViewById(R.id.listaAgenda);
        listaAgenda.setLayoutManager(new LinearLayoutManager(this));

        DbAgenda dbAgenda = new DbAgenda(ListarActivity.this);

        listaArrayAgenda = new ArrayList<>();

        ListaAgendaAdapter adapter = new ListaAgendaAdapter(dbAgenda.mostrarAgenda());

        listaAgenda.setAdapter(adapter);

        Button btnRegresar = (Button) findViewById(R.id.btnPrevious);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_crear = new Intent(ListarActivity.this, MainActivity.class);
                startActivity(intent_crear);
            }
        });

    }
}