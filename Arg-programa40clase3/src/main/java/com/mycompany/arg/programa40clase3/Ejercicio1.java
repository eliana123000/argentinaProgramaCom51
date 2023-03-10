/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arg.programa40clase3;

/**
 *
 * @author eliana
 */
public class Ejercicio1 {
    //Dado un String y una letra, que cuente la cantidad de apariciones de la letra en el String

    public int cantidadDeLetraE(String frase, char letraE) {

        int cantLetra = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letraE) {
                cantLetra++;
            }
        }
        return cantLetra;
    }

    //Dados 3 números y un orden (ascendente o decreciente) que ordene 
    //los mismos y los retorne en un vector de 3
    public int[] ordenDeNumeros(int[] numeros, boolean ascendente) {
        int aux, pos;

        for (int i = 0; i < numeros.length; i++) {
            pos = i;
            aux = numeros[pos];
            if (ascendente == true) {
                while (pos > 0 && aux < numeros[pos - 1]) {
                    numeros[pos] = numeros[pos - 1];
                    pos--;
                }
            } else {
                while (pos > 0 && aux > numeros[pos - 1]) {
                    numeros[pos] = numeros[pos - 1];
                    pos--;
                }
            }
            numeros[pos] = aux;
        }
        return numeros;
    }
//dado un vector de números, y un número X, que sume todos los números > X y
//retorne el resultado

    public int resultadoSuma(int[] numeros, int X) {
        int aux = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > X) {
                aux = aux + numeros[i];

            }
        }
        return aux;

    }
    
}
