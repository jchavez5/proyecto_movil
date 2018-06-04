package com.example.josechavez.proyectoseguros;

import java.util.ArrayList;

/**
 * Created by Josechavez on 25/05/2018.
 */

public class Persona {
    private String id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String sexo;
    private int telefono;
    private String direccion;
    private int foto;

    public Persona(String id, String cedula, String nombre, String apellido, String sexo, int telefono, String direccion, int foto) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.foto = foto;
    }

    public Persona() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.guardar(this);
    }
    public void eliminar(){
        Datos.eliminarPersona(this);
    }
}
