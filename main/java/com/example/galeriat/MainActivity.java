package com.example.galeriat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    EditText usuario,password;
    Button btnEntrar;
    TextView btnRegistrar;
    daoUsuario dao;
    int REQUEST_CODE = 200;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=(EditText)findViewById(R.id.Usuario);
        password=(EditText)findViewById(R.id.Password);
        btnRegistrar= (TextView) findViewById(R.id.Registrar);
        btnEntrar=(Button)findViewById(R.id.Entrar);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);

        dao=new daoUsuario(this);

        verificarPermiso();


    }
 @RequiresApi(api = Build.VERSION_CODES.M)
 private void verificarPermiso(){
    int Permiso =  ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
     if (Permiso == PackageManager.PERMISSION_GRANTED){
         //metodo para mandar mensajes
         Toast.makeText(this, "Acceso al almacenamiento consedido", Toast.LENGTH_SHORT).show();
     }else {
         requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
     }
 }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Registrar:

                Intent i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);
                finish();
                break;
            case R.id.Entrar:

                String u = usuario.getText().toString();
                String p = password.getText().toString();
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this, "error, campos vacios",Toast.LENGTH_LONG).show();

                }else if (dao.login(u,p)==1){
                    Usuario ux =dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Inicio.class);
                    intent.putExtra("Id", ux.getId());
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "usuario y/o contrasena incorrectos",Toast.LENGTH_LONG).show();
                }


        }

    }
}