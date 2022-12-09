package com.example.galeriat;

public class Usuario {


    int id;
    String nombre;
    String direccion;
    String usuario;
    String password;

    public Usuario(String nombre, String usuario, String correo, String password) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.usuario = usuario;
        this.password = password;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuario'" + usuario + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public boolean isNull(){
        if (nombre.equals("")&&direccion.equals("")&&usuario.equals("")&&password.equals("")){
            return false;
        }else{
            return  true;
        }

    }
    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String setNombre(String nombre) {this.nombre = nombre;
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String setDireccion(String direccion) {
        this.direccion = direccion;
        return direccion;
    }

    public String getUsuario() {return usuario;}

    public String setUsuario(String usuario) {
        this.usuario = usuario;
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

}
