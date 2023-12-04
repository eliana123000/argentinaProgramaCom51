/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clasejavaintermediomyj10a12;

/**
 *
 * @author eliana
 */
public class ClaseJavaIntermedioMyJ10A12 {

    public static void main(String[] args) {
        
        System.out.println("Hello World!");
        
        //instanciaremos a un objeto persona desde clase persona
        
       Persona per1 = new Persona();
       Persona per2= new Persona ("Ana", 45789632, "ana.hola@gmail.com");
       
       System.out.println( "Persona 1:" + per1.getNombre()+ "-" + per1.getDni()+"-" + per1.getContacto());
       System.out.println( "Persona 2:" + per2.getNombre()+ "-" + per1.getDni()+ "-"+ per2.getContacto());
       
       Alumno alumn1 = new Alumno();
       Alumno alumn2 = new Alumno("Jose Lopez", 12323456, "joselopz@hotmail.com","ing", 2020, true);
       
       System.out.println("Alumno: " + alumn1.getNombre()+"-" +alumn1.getCarrera()+"-" + alumn1.isRegularidad());
       
       NoDocente nDoc1 = new NoDocente ("Maestranza", "Ramon Hernandez", 45123456, "ramon.face");
       System.out.println("No Docente: " + nDoc1.getNombre()+"-"+ nDoc1.getDni()+"-" + nDoc1.getContacto());
    }
}
