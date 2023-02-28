/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arg.programa4.clase1;

/**
 *
 * @author eliana
 */
public class ArgPrograma40clase1 {

    public static void main(String args[]) {
		int numerofin;
		int numeroinicio;
		int otronum;
		int unnum;
		// Vamos a practicar operaciones básicas con números
		// a. Utilizando la sentencia while, imprima todos los números entre 2 variables "a" y  "b". 
		// Su código puede arrancar (por ejemplo): int numeroInicio = 5;int numeroFin = 14
		// Se deberían mostrar los números:5,6,7,8,9,10,11,12,13,14
		// b. A lo anterior, solo muestre los números pares
		// c. A lo anterior, con una variable extra, elija si se deben mostrar los números pares o impares
		// d. Utilizando la sentencia for, hacer lo mismo que en (b) pero invirtiendo el orden
		numeroinicio = 5;
		numerofin = 14;
		unnum = numeroinicio;
		System.out.println("punto A");
		while (unnum>0 && unnum<=14) {
			System.out.println(unnum);
			unnum = unnum+1;
		}
		unnum = numeroinicio;
		System.out.println("Punto B");
		while (unnum>0 && unnum<=14) {
			if (unnum%2==0) {
				System.out.println(unnum);
			}
			unnum = unnum+1;
		}
		System.out.println("Punto C: SE MOSTRARAN SOLO LOS IMPARES");
		unnum = numeroinicio;
		otronum = 1;
		while (unnum>0 && unnum<=14) {
			if (unnum%2==otronum) {
				System.out.println(unnum);
			}
			unnum = unnum+1;
		}
		System.out.println("Punto D");
		for (unnum=14;unnum>4;unnum--) {
			if (unnum%2==0) {
				System.out.println(unnum);
			}
		}
	}

}
