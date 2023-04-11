/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.argprograma40clase9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eliana
 */
public class ArgPrograma40clase9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Persona> listaPersonas = new ArrayList<Persona>();
        int si = 1;
        while (si == 1) {
            System.out.println("Hola, ingrese por favor su Nombre");
            String nombre = sc.nextLine();
            System.out.println("Por favor,ingrese su apellido");
            String apellido = sc.nextLine();
            System.out.println("Por favor,ingrese fecha de nacimiento ddmmaaaa");
            int nacimiento = sc.nextInt();
            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            persona.setNacimiento(nacimiento);
            listaPersonas.add(persona);
            System.out.println("Desea ingresar mas datos? 1.SI 2.NO");
            si= sc.nextInt();
            sc.nextLine();
        }
        int id = 1;
        for (Persona pers: listaPersonas) {
            System.out.println(id + " " + pers.getNombre() +" " + pers.getApellido()+ " " + pers.getNacimiento());
            id++;
        }
    }
}
