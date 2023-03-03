/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.argprograma40clae1ejercicio2;

import java.util.Scanner;

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
		
		
                Scanner sc = new Scanner(System.in) ;
                
                System.out.println("Por favor, ingrese el monto de los ingresos familiares");
                
                ingresos=sc.nextInt();
                sc.nextLine();
                
                System.out.println("Por favor, ingrese si posee mas de 3 vehiculos menores a 5 años en la familia");
                
                if (sc.nextLine().toLowerCase().equals("si")){
                    vehiculos=true;
                }
                else {
                    vehiculos = false;
                }
                
                System.out.println("Por favor, ingrese si posee mas de 3 inmuebles  familiares");
                    
                if (sc.nextLine().toLowerCase().equals("si")){
                    inmuebles=true;
                }
                else {
                    inmuebles = false;
                }
                
                System.out.println("Por favor, ingrese si posee activos y/0 embarcaciones familiares");
                
                if (sc.nextLine().toLowerCase().equals("si")){
                    activos=true;
                }
                else {
                    activos = false;
                }
                
	    //MODIFICADO GITHUB
            
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
