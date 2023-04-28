/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40examenfinal;

import java.util.Date;

/**
 *
 * @author eliana
 */
public class Inscripcion {
    private Alumno alumno;
    private Materia materia;
    private Date fecha;
    
     public boolean aprobada (){
         if(materia.puedeCursar(alumno)){
             return true;
         }else {
             return false;
         }
     }

    public Inscripcion(Alumno alumno, Materia materia, Date fecha) {
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = fecha;
    }
     
}
