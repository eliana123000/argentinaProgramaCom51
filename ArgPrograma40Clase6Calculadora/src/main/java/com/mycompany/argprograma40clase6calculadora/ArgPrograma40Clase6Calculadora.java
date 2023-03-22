/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.argprograma40clase6calculadora;

/**
 *
 * @author eliana
 */
public class ArgPrograma40Clase6Calculadora {

    public static void main(String[] args) {
        System.out.println("Hola, vamos a hacer operaciones matematicas");
        Calculadora calcu= new Calculadora();
        double resultado= calcu.multiplicar(80, 3);
        System.out.println ("El resultado de 80 * 3 es:" + resultado );
        double resultado1= calcu.sumar(150, 180);
        double resultado2=calcu.dividir(resultado1, 3);
        System.out.println ("El resultado de (150+ 180)/3 es:" + resultado2 );
        double resultado3= calcu.restar(90, 50);
        double resultado4= calcu.multiplicar(resultado3, 15);
        System.out.println ("El resultado de (90 - 50) * 15 es:" + resultado4 );
        double resultado5= calcu.restar(70, 40);
        double resultado6= calcu.multiplicar(resultado5, 25);
        System.out.println ("El resultado de (70 - 40) * 25 es:" + resultado6 );
        
    }
}
