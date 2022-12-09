package com.example.galeriat;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.galeriat.adaptador.GaleriaFotosAdapter;

public class ImagenCompleta extends AppCompatActivity {
    ImageView imageView;
    GaleriaFotosAdapter galeriaFotosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_completa);
        imageView = (ImageView) findViewById(R.id.fotos);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Foto completa");

        Intent intent = getIntent();
        int posicion = intent.getExtras().getInt("misImagenes");
        galeriaFotosAdapter = new GaleriaFotosAdapter(this);
        imageView.setImageResource(galeriaFotosAdapter.imageArray[posicion]);
    }
}