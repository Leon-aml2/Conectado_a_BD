package com.leonardo.proyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.leonardo.proyecto.modelo.Clima;

import java.util.ArrayList;
import java.util.UUID;

public class calendar1 extends AppCompatActivity {
    EditText etFecha1,etTemperatura1,etHumedad1;
    Button btnMostrar1,btnAgregar;
    Clima a;
    FirebaseDatabase database;
    ListView lvClima;
    ArrayList<Clima> Climas;
    ArrayAdapter<Clima> adaptadorClima;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar1);
        etFecha1=(EditText) findViewById(R.id.etFecha1);
        etTemperatura1=(EditText) findViewById(R.id.etTemperatura1);
        etHumedad1=(EditText) findViewById(R.id.etHumedad1);
        btnMostrar1=(Button) findViewById(R.id.BtnMostrar1);
        btnAgregar=(Button) findViewById(R.id.btnAgregar1);
        lvClima=(ListView) findViewById(R.id.lvClima);
        Climas = new ArrayList<Clima>();

        CargarBD();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CargarDatos();
            }
        });
    }

    private void CargarBD() {
        database = FirebaseDatabase.getInstance();
        DatabaseReference alumnosRef = database.getReference("Clima");
        ValueEventListener listaListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot d: snapshot.getChildren()){
                    String Key = d.child("Key").getValue().toString();
                    String Temperatura = d.child("Temperatura").getValue().toString();
                    String Humedad = d.child("Humedad").getValue().toString();
                    String Fecha = d.child("Fecha").getValue().toString();
                    Clima a = new Clima(Temperatura,Humedad,Fecha,Key);
                    Climas.add(a);
                }
                adaptadorClima = new ArrayAdapter<Clima>(getApplicationContext(),android.R.layout.simple_list_item_1,Climas);
                lvClima.setAdapter(adaptadorClima);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };

        alumnosRef.addValueEventListener(listaListener);


    }

    private void CargarDatos() {
        String fecha = etFecha1.getText().toString();
        String temperatura =etTemperatura1.getText().toString();
        String humedad = etHumedad1.getText().toString();

        String key = UUID.randomUUID().toString();
        Clima a = new Clima(temperatura,humedad,fecha,key);

        database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Clima");
        myRef.child(key).setValue(a);


    }



}