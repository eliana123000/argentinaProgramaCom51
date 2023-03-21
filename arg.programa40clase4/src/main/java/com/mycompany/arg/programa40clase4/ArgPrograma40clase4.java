/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arg.programa40clase4;

import java.util.Scanner;

/**
 *
 * @author eliana
 */
public class ArgPrograma40clase4 {

    public static void main(String[] args) {
        int numeros[]={10,1,80};
        System.out.println("Los numeros a ordenar son:");
        for (int i=0; i<numeros.length; i++ ){
            System.out.println (numeros[i]);
        }
        int [] numerosOrdenados= ordenDeNumeros(numeros,'d');
        System.out.println ("Los numeros ordenados son:");
        for (int i=0; i< numerosOrdenados.length; i++){
            System.out.println (numerosOrdenados [i]);
        }
        //haga lo mismo, pero solicitando los parámetros de a uno por consola
        Scanner sc= new Scanner (System.in);
        for (int i=0; i<numeros.length; i++){
            System.out.println ("Ingrese un valor entero ");
            numeros[i]=sc.nextInt();
        }
        char tipoDeOrdenamiento;
        sc.nextLine();
        System.out.println ("Elija el ordenamiento en que quiere ver los numeros: a=ascendente, d=descendente");
        tipoDeOrdenamiento=sc.nextLine().toLowerCase().charAt(0);
        
        numerosOrdenados= ordenDeNumeros(numeros,tipoDeOrdenamiento);
        System.out.println ("Los numeros ordenados son:");
        for (int i=0; i< numerosOrdenados.length; i++){
            System.out.println (numerosOrdenados [i]);
        }
        
        
    }
    //haga un main, donde por parámetro ponga 3 números y una letra que
    //represente ascendente o descendente y los muestre ordenados por tal criterio
    public static int[] ordenDeNumeros(int[] numeros, char tipoDeOrdenamiento) {
        int aux, pos;

        for (int i = 0; i < numeros.length; i++) {
            pos = i;
            aux = numeros[pos];
            if (tipoDeOrdenamiento =='a') {
                while (pos > 0 && aux < numeros[pos - 1]) {
                    numeros[pos] = numeros[pos - 1];
                    pos--;
                }
            } else if (tipoDeOrdenamiento =='d'){
                while (pos > 0 && aux > numeros[pos - 1]) {
                    numeros[pos] = numeros[pos - 1];
                    pos--;
                }
            }
            numeros[pos] = aux;
        }
        return numeros;
    }
}
