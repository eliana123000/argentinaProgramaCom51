/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arg_programa40clase3;

import java.util.Scanner;

/**
 *
 * @author eliana
 */
public class Arg_programa40clase2envivo {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner ( System.in);
        sc.useDelimiter("n");
        
        System.out.println("Ingresa un numeroo");
        
        double num1=sc.nextDouble ();
        
        System.out.println("ingrese una palabra o frase");
        
        String frase1= sc.next();
        
        System.out.println (frase1);
        System.out.println (num1);
        
        
    }
}
