/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arg.programa40clase3;

import java.util.Scanner;

/**
 *
 * @author eliana
 */
public class ArgPrograma40clase3 {

    public static void main(String[] args) {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        String frase = "Hola mundo, pone cualquier cosa";
        System.out.println(frase);
        char letra = 'e';
        int cantLetra = ejercicio1.cantidadDeLetraE(frase,  letra);
        System.out.println("Cantidad de letra " + letra + " = " + cantLetra);
        
        int numeros[]={10,1,80};
        System.out.println("Los numeros a ordenar son:");
        for (int i=0; i<numeros.length; i++ ){
            System.out.println (numeros[i]);
        }
        int [] numerosOrdenados= ejercicio1.ordenDeNumeros(numeros, false);
        System.out.println ("Los numeros ordenados son:");
        for (int i=0; i< numerosOrdenados.length; i++){
            System.out.println (numerosOrdenados [i]);
        }
        
        System.out.println("Ingrese un numero entero entre 1 y 80");
        Scanner sc= new Scanner (System.in);
        int x= sc.nextInt();
        System.out.println("Sumaremos todos los numeros del vector mayores al numero ingresado:" + x);
        int resultado= ejercicio1.resultadoSuma(numeros, x);
        System.out.println (" El resultado de la suma es:"+ resultado);
        
        //lo siguiente es un borrador para llegar al ejercicio 2
        sc.nextLine();
        System.out.println("Ingrese una letra del abecedario: ");
        String caracter=sc.nextLine();
        int c=caracter.charAt(0);
        System.out.println((char)(c+1));
        
        
        //ejercicio2
        Ejercicio2 ejercicio2 = new Ejercicio2();
        System.out.println("Vamos a encriptar una frase");
        System.out.println("Por favor, ingrese su frase favorta:");
        String fraseFavorita= sc.nextLine();
        String fraseEncriptada=ejercicio2.encriptar(fraseFavorita, 1);
        System.out.println(fraseEncriptada);
        
        System.out.println("Ahora volveremos a ver su frase favorita");
        String fraseDesencriptada=ejercicio2.desencriptar(fraseEncriptada, 1);
        System.out.println(fraseDesencriptada);
    }
}
