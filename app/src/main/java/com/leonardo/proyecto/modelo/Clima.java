package com.leonardo.proyecto.modelo;

import androidx.annotation.NonNull;

public class Clima {
    public String Temperatura;
    public String Humedad;
    public String Fecha;
    public String Key;

    public Clima(){

    }

    public Clima(String temperatura, String humedad, String fecha, String key) {
        Temperatura = temperatura;
        Humedad = humedad;
        Fecha = fecha;
        Key = key;
    }


    @Override
    public String toString() {
        return "{" +
                "Temperatura='" + Temperatura + '\'' +
                ", Humedad='" + Humedad + '\'' +
                ", Fecha='" + Fecha + '\'' +
                '}';
    }
}


