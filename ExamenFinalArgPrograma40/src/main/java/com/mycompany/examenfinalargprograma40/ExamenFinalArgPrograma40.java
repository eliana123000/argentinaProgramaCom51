/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examenfinalargprograma40;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author eliana
 */
public class ExamenFinalArgPrograma40 {

    public static void main(String[] args) {
        
        System.out.println("Elija la accion que desea hacer: 1-ingresar materia,"
                + " 2- ingresar alumno, 3-inscribir alumno");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        if(opcion==1){
            Materias mat = new Materias();
            mat.mostrarTodasMaterias();
            System.out.println("Ingrese nombre de materia");
            sc.nextLine();
            String materia=sc.nextLine();
            mat = new Materias(materia,new ArrayList<Integer>());
            mat.escribirMateria();
        }
    }
/*POR FAVOR DESESTIMAR ESTE PROYECTO EXAMN FINAL...SE RESOLVIO EXAMEN FINAL EN :
    ArgPrograma40ExamenFinal.java
    */
}
