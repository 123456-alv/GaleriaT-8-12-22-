package com.example.galeriat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> list;
    SQLiteDatabase sql;
    String bd = "Usuarios";
    String table = "create table if not exists usuarioo(id integer primary key autoincrement,nombre text,direccion text,usuario text ,password text)";

    public daoUsuario(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(table);
        u = new Usuario();


    }

    public boolean insertUsuario(Usuario u) {
        if (buscar(u.getUsuario())==0) {
            ContentValues cv = new ContentValues();
            cv.put("nombre",u.getNombre());
            cv.put("direccion",u.getDireccion());
            cv.put("usuario",u.getUsuario());
            cv.put("password",u.getPassword());
            return (sql.insert("usuarioo",null,cv)>0);
        }else{
            return false;
        }
    }
    public int buscar (String u){
        int x=0;
        list = selectUsuarios();
        for (Usuario us:list)
            if (us.getUsuario().equals(u)){
                x++;
            }
        {

        }
        return x;
    }

    public ArrayList<Usuario> selectUsuarios(){
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        list.clear();

        Cursor cr =sql.rawQuery("select * from usuarioo", null);
        if (cr!= null&&cr.moveToFirst()){
            do{
                Usuario u = new Usuario();
                u.setId(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setDireccion(cr.getString(2));
                u.setUsuario(cr.getString(3));
                u.setPassword(cr.getString(4));
                list.add(u);
            }while(cr.moveToNext());

        }
        return list;
    }
    public int login(String u, String p){
        int a=0;
        Cursor cr =sql.rawQuery("select * from usuarioo", null);
        if (cr!= null&&cr.moveToFirst()){
            do{
                if (cr.getString(3).equals(u)&&cr.getString(4).equals(p)){
                    a++;
                }
            }while(cr.moveToNext());

        }
        return a;
    }
    public Usuario getUsuario(String u,String p){
        list =selectUsuarios();
        for (Usuario us :list) {
            if(us.getUsuario().equals(u)&&us.getPassword().equals(p)){
                return us;
            }

        }
        return null;

    }
    public Usuario getUsuarioById(int id){
        list =selectUsuarios();
        for (Usuario us :list) {
            if(us.getId()==id){
                return us;
            }

        }
        return null;

    }
}
