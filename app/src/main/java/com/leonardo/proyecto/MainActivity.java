package com.leonardo.proyecto;

import static com.google.firebase.storage.FirebaseStorage.getInstance;
import static com.leonardo.proyecto.R.id.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.leonardo.proyecto.modelo.Clima;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    Button btnAgregar,btnMostrarDiagnostico,btnxd;
    EditText etFecha,etTemperatura,etHumedad;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnxd = (Button) findViewById(R.id.btnxd);
        /*etFecha = (EditText) findViewById(R.id.etFecha);
        etTemperatura = (EditText) findViewById(R.id.etTemperatura);
        etHumedad = (TextView) findViewById(R.id.etHumedad);*/


        /*btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Hola", Toast.LENGTH_SHORT).show();
                insertar();
            }
        });*/
        //llamadoActivityMostrarDiagnostico();
        btnxd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,calendar1.class);
                startActivity(i);
            }
        });
    }

    /*private void llamadoActivityMostrarDiagnostico() {
        btnMostrarDiagnostico = (Button) findViewById(R.id.btnMostrarDiagnostico);
        btnMostrarDiagnostico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ClimaReciente.class);
                startActivity(i);
            }
        });
    }*/

    /*public void insertar(){
        String fecha = etFecha.getText().toString();
        int temperatura = Integer.parseInt(etTemperatura.getText().toString());
        int humedad = Integer.parseInt(etHumedad.getText().toString());
        String key = UUID.randomUUID().toString();
       // Clima a = new Clima(fecha,temperatura,humedad);


        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Clima");
        myRef.child(key).setValue(a);
    }*/
}