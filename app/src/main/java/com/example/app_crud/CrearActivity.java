package com.example.app_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_crud.db.DbAgenda;

public class CrearActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtCorreoElectronico, txtFecha, txtMotivo;
    Button btnGuarda;


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

        /* llamar evento setOnClickListener para identificar accion guardar*/

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* llamar la clase Dbagenda y se le envia los datos de la vista */

                DbAgenda dbAgenda = new DbAgenda(CrearActivity.this);
                long id = dbAgenda.insertarAgenda(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreoElectronico.getText().toString(), txtMotivo.getText().toString(), txtFecha.getText().toString());

                /*si el registro se inserto de forma correcta enviamos mensaje*/
                if(id>0){
                    Toast.makeText(CrearActivity.this, "REGISTRO GUARDADO CON EXITO!", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(CrearActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }

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
    private void limpiar(){
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
        txtFecha.setText("");
        txtMotivo.setText("");
    }




}