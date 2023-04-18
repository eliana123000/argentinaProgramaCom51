/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenparcialintegrador;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eliana
 */
public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia() {
        nombre = "";
        correlativas = new ArrayList <Materia>() ;
    }

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }
    public boolean puedeCursar (Alumno alumnoCursa){
        if (correlativas.isEmpty()){
            return true;
        }
        for (int i=0; i<correlativas.size(); i++){
            if (!alumnoCursa.getMateriasAprobadas().contains(correlativas.get(i))){
                return false;
            }
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }
    
}
