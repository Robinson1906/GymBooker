package com.example.gymbooker.Class;

import java.io.Serializable;

public class Reserva implements Serializable {
    private String fecha, rutina, cedula;

    private int horaIngreso, horaSalida, duracion, estado;

    //Estados=
    //0. Pendiente
    //1 Asistido
    //2 Cancelado



    public Reserva() {
        this.estado=0;
    }
    public Reserva(String fecha,String cedula, String rutina, int horaIngreso, int horaSalida) {
        this.fecha = fecha;
        this.cedula=cedula;
        this.rutina = rutina;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.duracion = horaSalida-horaIngreso;
        this.estado=0;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRutina() {
        return rutina;
    }

    public void setRutina(String rutina) {
        this.rutina = rutina;
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

    public String getCedula() {
        return cedula;
    }    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEstado() {
        return estado;
    }    public void setEstado(int estado) {
        this.estado = estado;
    }
}