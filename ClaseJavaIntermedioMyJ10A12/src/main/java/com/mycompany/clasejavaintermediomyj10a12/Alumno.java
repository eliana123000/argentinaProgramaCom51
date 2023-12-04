/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clasejavaintermediomyj10a12;

/**
 *
 * @author eliana
 */
public class Alumno extends Persona {
    private String carrera;
    private int anio;
    private boolean regularidad;

    public Alumno() {
    }

    public Alumno(String nombre,  int dni, String contacto, String carrera, int anio, boolean regularidad) {
        super(nombre, dni , contacto);
        this.carrera = carrera;
        this.anio = anio;
        this.regularidad = regularidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isRegularidad() {
        return regularidad;
    }

    public void setRegularidad(boolean regularidad) {
        this.regularidad = regularidad;
    }
    
    
}
