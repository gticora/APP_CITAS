package com.example.app_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_crud.db.DbAgenda;
import com.example.app_crud.entidades.Agenda;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CrearActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreoElectronico, txtFecha, txtMotivo;
    Button btnGuarda;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        txtNombre= findViewById(R.id.txtNombre);
        txtTelefono= findViewById(R.id.txtTelefono);
        txtCorreoElectronico= findViewById(R.id.txtCorreoElectronico);
        txtMotivo = findViewById(R.id.txtMotivo);
        txtFecha= findViewById(R.id.txtFecha);
        btnGuarda = findViewById(R.id.btnGuardar);


        incializarfirebase();

        /* llamar evento setOnClickListener para identificar accion guardar*/

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* llamar la clase Dbagenda y se le envia los datos de la vista */

                String nombre = txtNombre.getText().toString();
                String telefono = txtTelefono.getText().toString();
                String correoelectronico = txtCorreoElectronico.getText().toString();
                String motivo = txtMotivo.getText().toString();
                String fecha = txtFecha.getText().toString();

                Agenda a = new Agenda();
                a.setUid(UUID.randomUUID().toString());
                a.setNombres(nombre);
                a.setTelefono(telefono);
                a.setCorreo_electronico(correoelectronico);
                a.setMotivo(motivo);
                a.setFecha(fecha);

                databaseReference.child("Agenda").child(a.getUid()).setValue(a);

                Toast.makeText(CrearActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                limpiar();
                /*DbAgenda dbAgenda = new DbAgenda(CrearActivity.this);
                long id = dbAgenda.insertarAgenda(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreoElectronico.getText().toString(), txtMotivo.getText().toString(), txtFecha.getText().toString());

                /*si el registro se inserto de forma correcta enviamos mensaje*/
                /*if(id>0){
                    Toast.makeText(CrearActivity.this, "REGISTRO GUARDADO CON EXITO!", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(CrearActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }*/

            }
        });

        Button btnRegresar = (Button) findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_crear = new Intent(CrearActivity.this, MainActivity.class);
                startActivity(intent_crear);
            }
        });


    }

    private void incializarfirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    private void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
        txtFecha.setText("");
        txtMotivo.setText("");
    }




}