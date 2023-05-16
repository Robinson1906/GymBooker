package com.example.gymbooker.Class;

import java.io.Serializable;

public class Reserva implements Serializable {
    private String fecha, nombre_area;
    private long cedula;
    private int id_reserva,id_area,horaIngreso, horaSalida, duracion;

    public Reserva() {
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }

    public Reserva(String fecha, long cedula, int id_area, int horaIngreso, int horaSalida, int duracion, String nombre_area) {
        this.fecha = fecha;
        this.cedula = cedula;
        this.id_area = id_area;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.duracion = duracion;
        this.nombre_area = nombre_area;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(int horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}