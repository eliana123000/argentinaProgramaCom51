/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clasejavaintermediomyj10a12;

/**
 *
 * @author eliana
 */
public class Persona {

    private String nombre;
    private int dni;
    private String contacto;
    
      public Persona() {
        nombre = "Persona NN"; 
        dni = 10101101;
        contacto= "unContacto";
        
    }
    public Persona(String nombre, int dni, String contacto) {
        this.nombre = nombre; 
        this.dni = dni;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    

    
}
