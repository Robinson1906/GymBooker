package com.example.gymbooker.Class;

import java.io.Serializable;

public class Reserva implements Serializable {
    private String fecha, rutina;
    private int horaIngreso, horaSalida, duracion;

    public Reserva() {}
    public Reserva(String fecha, String rutina, int horaIngreso, int horaSalida) {
        this.fecha = fecha;
        this.rutina = rutina;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.duracion = horaSalida-horaIngreso;
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
}