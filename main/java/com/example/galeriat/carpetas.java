package com.example.galeriat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class carpetas extends BaseAdapter {

    /*variables globales
   layout inflater se utiliza para instanciar el archivo de diseño
   y que se muestre en MainActivity
    */
    LayoutInflater inflater=null;
    //generar los datos
    Context context;

    int [] ima1;
    int[] ima2;
    //generar constructor
    public carpetas(Context context,int[] ima1, int[] ima2) {
        this.context = context;

        this.ima1 = ima1;
        this.ima2 = ima2;

        //inicializar inflater
        inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    //generar vista y asignar mediante inflate los elementos del archivo xml
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = inflater.inflate(R.layout.activity_carpetas,null);
        View vista2 = inflater.inflate(R.layout.activity_carpetas,null);


        //referenciar

        ImageView Avatar = vista.findViewById(R.id.ima1);
        ImageView Avatar2 = vista2.findViewById(R.id.ima2);


        //asignar datos a cada una de las posiciones

        Avatar.setImageResource(ima1[position]);
        Avatar2.setImageResource(ima2[position]);



        return vista;
    }
    //generar gets
    @Override
    public int getCount() {return ima1.length;}

    @Override
    public Object getItem(int position) {return null;}

    @Override
    public long getItemId(int position) {return 0;}


}