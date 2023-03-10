/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arg.programa40clase3;

/**
 *
 * @author eliana
 */
public class Ejercicio2{
    public String encriptar(String palabra, int desplazamiento){
        String palabraClave="";
        for (int i=0; i<palabra.length(); i++){
            int c=palabra.charAt(i);
            palabraClave = palabraClave.concat(String.valueOf((char)(c+desplazamiento)));
        }
        return palabraClave;
    }
     public String desencriptar(String palabra, int desplazamiento){
        String palabraClave="";
        for (int i=0; i<palabra.length(); i++){
            int c=palabra.charAt(i);
            palabraClave = palabraClave.concat(String.valueOf((char)(c-desplazamiento)));
        }
        return palabraClave;
    }
}
