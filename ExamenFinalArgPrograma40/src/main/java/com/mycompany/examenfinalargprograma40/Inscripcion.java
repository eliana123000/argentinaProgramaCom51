/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinalargprograma40;

import java.util.Date;

/**
 *
 * @author eliana
 */
public class Inscripcion {
     private Alumnos alumno;
    private Materias materia;
    private Date fecha;
    /*
     public boolean aprobada (){
         if(materia.puedeCursar(alumno)){
             return true;
         }else {
             return false;
         }
     }
*/
    public Inscripcion(Alumnos alumno, Materias materia, Date fecha) {
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = fecha;
    }
}
