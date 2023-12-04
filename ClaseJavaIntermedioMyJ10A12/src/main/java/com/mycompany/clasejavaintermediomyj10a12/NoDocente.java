/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clasejavaintermediomyj10a12;

/**
 *
 * @author eliana
 */
public class NoDocente extends Persona {
    private String categoria;
    
    
  public NoDocente(String categoria, String nombre, int dni, String contacto) {
        super(nombre, dni, contacto);
        this.categoria = categoria;
    }
    
    public NoDocente(String categoria) {
        this.categoria = categoria;
    }

  
}  