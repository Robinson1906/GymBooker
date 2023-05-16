package com.example.gymbooker.Helpers;

import java.util.Calendar;
import java.util.Date;

public class HelperFecha {


        public static boolean verificarExpiracion(Date fecha) {
            Calendar fechaActual = Calendar.getInstance();
            Calendar fechaComparacion = Calendar.getInstance();
            fechaComparacion.setTime(fecha);

            // Comparar las fechas
            if (fechaActual.after(fechaComparacion)) {
                // La fecha ya ha pasado
                return true;
            }

            // La fecha aún no ha pasado
            return false;
        }

        public static void main(String[] args) {
            // Obtener la fecha actual
            Date fechaActual = new Date();

            // Crear una fecha de ejemplo (2 días atrás)
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -2);
            Date fechaEjemplo = cal.getTime();

            // Verificar si la fecha de ejemplo ha expirado
            boolean expirada = verificarExpiracion(fechaEjemplo);

            if (expirada) {
                System.out.println("La fecha ha expirado");
            } else {
                System.out.println("La fecha aún no ha expirado");
            }
        }
}
