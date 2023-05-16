package com.example.gymbooker.Class;

import java.io.Serializable;

public class User implements Serializable {

    private int cedula;
    private String nombre;
    private boolean isAdmin;
    private String correo;
    private String telefono;
    private String fechaNacimiento;
    private String token;
    private String id;

    public User(int cedula, String nombre, boolean isAdmin, String correo, String telefono, String fechaNacimiento, String token) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.isAdmin = isAdmin;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.token = token;
    }

    public int getCedula() {
        return cedula;
    }    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAdmin() {
        return isAdmin;
    }    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getCorreo() {
        return correo;
    }    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getToken() {
        return token;
    }    public void setToken(String token) {
        this.token = token;
    }
}
