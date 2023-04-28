/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.argprograma40examenfinal;

import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author eliana
 */

/* 
CREACION BASE DE DATOS :argPrograma40examenfinal
CREACION DE TABLAS DE MYSQL
CREATE TABLE `alumnos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `legajo` int DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `materiasAprobadas` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `materias` (
  `id` int NOT NULL AUTO_INCREMENT,
  `materias` varchar(100) DEFAULT NULL,
  `correlativas` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

 */
public class ArgPrograma40ExamenFinal {

    public static void main(String[] args) {
        // Inicializar materias: crear 3 o 4 materias, con y sin correlativas entre ellas
        Materia materia1 = new Materia("Programacion I", new ArrayList<Materia>());
        materia1.escribirMateria();
        Materia materia2 = new Materia("Programacion II", Arrays.asList(materia1));
        materia2.escribirMateria();
        Materia materia3 = new Materia("Bases de Datos I", new ArrayList<Materia>());
        materia3.escribirMateria();
        Materia materia4 = new Materia("Bases de Datos II", Arrays.asList(materia3));
        materia4.escribirMateria();
        Materia materia5 = new Materia("Estructura de Datos I", new ArrayList<Materia>());
        materia5.escribirMateria();
        Materia materia6 = new Materia("Estructura de Dato II", Arrays.asList(materia5, materia3));
        materia6.escribirMateria();
        Materia materia7 = new Materia("Matematicas I", new ArrayList<Materia>());
        materia7.escribirMateria();
        Materia materia8 = new Materia("Matematicas II", Arrays.asList(materia7, materia1));
        materia8.escribirMateria();

        //Inicializar alumnos: se crean en tabla 4 alumnos con sus materias aprobadas, para luego inscribirse
        Alumno alumno1 = new Alumno(12345, "Eliana", "Rabinovich", Arrays.asList(materia3, materia7));
        alumno1.escribirAlumno();
        Alumno alumno2 = new Alumno(12234, "Damian", "Fernandez", Arrays.asList(materia1, materia3, materia7));
        alumno2.escribirAlumno();
        Alumno alumno3 = new Alumno(12456, "Noelia", "Rabinovich", Arrays.asList(materia7));
        alumno3.escribirAlumno();
        Alumno alumno4 = new Alumno(12567, "Maria", "Lira", new ArrayList<Materia>());
        alumno4.escribirAlumno();

//Inscripcion
        Scanner sc = new Scanner(System.in);
        String regex = "[0-9]{5}";
        final Pattern pattern = Pattern.compile(regex);
        int seguirInscripcion = 1;
        while (seguirInscripcion == 1) {
            System.out.println(" Ingrese su numero de legajo  ");
            int legajo = sc.nextInt();
            if (pattern.matcher(String.valueOf(legajo)).matches() == false) {// -> True
                System.out.println("El legajo no cumple la condicion de 5 numeros del 0 al 9");
                while (pattern.matcher(String.valueOf(legajo)).matches() == false) {
                    System.out.println(" Ingrese su numero de legajo  ");
                    legajo = sc.nextInt();
                }
            }
            sc.nextLine();
            /*
        System.out.println(" Ingrese su nombre ");
        String nombre = sc.nextLine();
        System.out.println(" Ingrese su apellido ");
        String apellido = sc.nextLine();
             */
            System.out.println("Ingrese la materia a la cual desea inscribirse ");
            String materia = sc.nextLine();
            Alumno al = new Alumno();
            Materia mat = new Materia();
            try {
                mat.traerMateria(materia);
                al.traerAlumno(legajo);
                Inscripcion insc = new Inscripcion(al, mat, new Date());
                if (insc.aprobada()) {
                    System.out.println("El Alumno " + al.getNombre() + " " + mat.getNombre() + " aprobado");
                } else {
                    System.out.println("El Alumno " + al.getNombre() + " " + mat.getNombre() + " Rechazado");
                }
            } catch (MateriaNoExiste ex) {
                System.out.println("Solicitud Rechazada, materia no existe");
            } catch (AlumnoNoExiste ex) {
                System.out.println("Solicitud Rechazada, legajo no existe");
            }
            System.out.println("Desea seguir cargando inscripcion? 1: SI , 2: NO");
            seguirInscripcion = sc.nextInt();
            sc.nextLine();
        }
    }

}
