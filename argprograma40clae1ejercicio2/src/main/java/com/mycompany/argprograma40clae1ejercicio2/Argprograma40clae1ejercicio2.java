/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.argprograma40clae1ejercicio2;

/**
 *
 * @author eliana
 */
public class Argprograma40clae1ejercicio2 {

    public static void main(String args[]) {
		boolean activos;
		int ingresos;
		boolean inmuebles;
		boolean vehiculos;
		ingresos = 400000;
		inmuebles = true;
		activos = false;
		vehiculos = false;
		if (ingresos>489083) {
			System.out.println("Ud pertenece al grupo de ingresos altos, no posee subsidio");
		} else {
			if (vehiculos) {
				System.out.println("Ud pertenece al grupo de ingresos altos, no posee subsidio");
			} else {
				if (inmuebles) {
					System.out.println("Ud pertenece a grupo de ingresos altos, no posee subsidio");
				} else {
					if (activos) {
						System.out.println("Ud pertenece a grupo de ingresos altos, no posee subsidio");
					} else {
						System.out.println("Ud pertenece a ingresos medios o bajos, le corresponde subsidio");
					}
				}
			}
		}
	}
}
