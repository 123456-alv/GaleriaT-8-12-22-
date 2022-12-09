package com.example.galeriat;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity{
    EditText us,pas;
    Button reg, can;
    daoUsuario dao;
    boolean retorno = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
       // nom=(EditText)findViewById(R.id.nombre);
       // ape=(EditText)findViewById(R.id.apellidos);
        us=(EditText)findViewById(R.id.usuario);
        pas=(EditText)findViewById(R.id.pass);
        reg=(Button)findViewById(R.id.reg);
        can=(Button)findViewById(R.id.can);
        //reg.setOnClickListener(this);
        //can.setOnClickListener(this);j
        dao=new daoUsuario(this);
    }
/*
    public boolean validar (){

        boolean retorno = true;
         String nombre=nom.getText().toString();
         String apellidos=ape.getText().toString();
         String usuario=us.getText().toString();
         String contraseña=pas.getText().toString();
         if(nombre.isEmpty()){
             nom.setError("Campo vacío");
             retorno=false;
         }
         if(apellidos.isEmpty()){
             ape.setError("Campo vacío");
             retorno=false;
         }
        if(usuario.isEmpty()){
            us.setError("Campo vacío");
            retorno=false;
        }
        if(contraseña.isEmpty()){
            pas.setError("Campo vacío");
            retorno=false;
        }

        return retorno;
    }
    public void agregar(View a){
        if(validar()){
            Toast.makeText(this,"ingresar datos",Toast.LENGTH_SHORT).show();
        }
    }
*/
    public void onClick(View v) {

                Usuario u = new Usuario();

                //String nombre = u.setNombre(nom.getText().toString());
                //String apellidos = u.setDireccion(ape.getText().toString());
                String usuario = u.setUsuario(us.getText().toString());
                String contraseña = u.setPassword(pas.getText().toString());
                /*
                if(nombre.isEmpty()){
                    nom.setError("Campo vacío");
                    retorno=false;
                }
                if(apellidos.isEmpty()){
                    ape.setError("Campo vacío");
                    retorno=false;
                }
                */
                if(usuario.isEmpty()){
                    us.setError("Campo vacío");
                    retorno=false;
                }
                if(contraseña.isEmpty()){
                    pas.setError("Campo vacío");
                    retorno=false;
                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this, "Datos registrados correctamente",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Registro.this, MainActivity.class);
                    startActivity(i);
                    finish();

                }else{
                    Toast.makeText(this, "usuario ya registrado",Toast.LENGTH_LONG).show();
                }

    }

    public void cancelar(View c){
        Intent i = new Intent(Registro.this, MainActivity.class);
        startActivity(i);
        finish();
    }

}