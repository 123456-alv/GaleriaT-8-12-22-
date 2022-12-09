package com.example.galeriat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.galeriat.adaptador.GaleriaFotosAdapter;

public class listaImagenes extends AppCompatActivity {
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imagenes);

        //codigo para la lista de imagenes en la clase sub carpeta
        gridView = (GridView)findViewById(R.id.imagenes1);
        gridView.setAdapter(new GaleriaFotosAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ImagenCompleta.class);
                //envia la imagen a otro actividad
                intent.putExtra("misImagenes", position);
                startActivity(intent);
            }
        });
    }
}