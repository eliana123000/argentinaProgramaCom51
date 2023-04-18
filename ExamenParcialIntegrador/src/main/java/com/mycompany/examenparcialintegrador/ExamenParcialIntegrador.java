/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examenparcialintegrador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author eliana
 */
public class ExamenParcialIntegrador {

    public static void main(String[] args) throws IOException {
        // Inicializar materias: crear 3 o 4 materias, con y sin correlativas entre ellas
        List<Materia> materias = new ArrayList<Materia>();
        Materia materia1 = new Materia("Programacion I", new ArrayList<Materia>());
        materias.add(materia1);
        Materia materia2 = new Materia("Programacion II", Arrays.asList(materia1));
        materias.add(materia2);
        Materia materia3 = new Materia("Bases de Datos I", new ArrayList<Materia>());
        materias.add(materia3);
        Materia materia4 = new Materia("Bases de Datos II", Arrays.asList(materia3));
        materias.add(materia4);
// Inicializar los alumnos, crear 2 o 3 alumnos, con y sin materias aprobadas. 

// Usar para las materias los MISMOS objetos de la colección de más arriba 
        List<Alumno> alumnos = new ArrayList<Alumno>();
        List<Materia> materiasAprobadas = new ArrayList<Materia>();
        int id = 1;
        for (Materia mat : materias) {
            System.out.println(id + " " + mat.getNombre());
            id++;
        }
        Scanner sc = new Scanner(System.in);
        int seguir = 1;
        while (seguir == 1) {
            System.out.println(" Ingrese su nombre y apellido ");
            String nombre = sc.nextLine();
            System.out.println(" Ingrese su numero de legajo (DNI) ");
            String legajo = sc.nextLine();
            int seguirMaterias = 1;
            while (seguirMaterias == 1) {
                System.out.println("Ingrese el id la materia aprobada ");
                int materiaid = sc.nextInt();

                if (materiaid > 0 && materiaid < materias.size()) {
                    if (materiasAprobadas.contains(materias.get(materiaid - 1))) {
                        materiasAprobadas.add(materias.get(materiaid - 1));
                    }
                }
                System.out.println("Desea seguir cargando materias? 1: SI , 2: NO");
                seguirMaterias = sc.nextInt();
            }
            alumnos.add(new Alumno(nombre, legajo, materiasAprobadas));
            System.out.println("Desea seguir cargando alumnos? 1: SI , 2: NO");
            seguir = sc.nextInt();
            sc.nextLine();
        }
// Leer el archivo pasado por parámetros de args y por cada línea
        String archivoEntrada = args[0];
        String archivoSalida = args[1];
        Path ingreso = Paths.get(archivoEntrada);
        Path salida = Paths.get(archivoSalida);
// instanciar un objeto Inscripción, pero para llenar las materias y alumnos DEBE usar los objetos 
//que creo más arriba 
        for (String linea : Files.readAllLines(ingreso)) {
            String nombreYMateria[] = linea.split(";");
            Alumno al = new Alumno();
            Materia mat1 = new Materia();
            for (Alumno alumn : alumnos) {
                if (alumn.getNombre().toLowerCase().equals(nombreYMateria[0].toLowerCase())) {
                    al = alumn;
                }

            }
            for (Materia mat : materias) {
                if (mat.getNombre().toLowerCase().equals(nombreYMateria[1].toLowerCase())) {
                    mat1 = mat;
                }

            }

// Imprimir la línea, con el resultado si la inscripción está o no ok
            if (!al.getNombre().equals("") && !mat1.getNombre().equals("")) {
                Inscripcion inscripcion = new Inscripcion(al, mat1, new Date());
                if (inscripcion.aprobada()) {
                    Files.write(salida, ("El Alumno " + al.getNombre() + " " + mat1.getNombre() + " aprobado\n").getBytes(), StandardOpenOption.APPEND);
                    System.out.println("El Alumno " + al.getNombre() + " " + mat1.getNombre() + " aprobado");
                } else {
                    Files.write(salida, ("El Alumno " + al.getNombre() + " " + mat1.getNombre() + " Rechazado\n").getBytes(), StandardOpenOption.APPEND);
                    System.out.println("El Alumno " + al.getNombre() + " " + mat1.getNombre() + " Rechazado");
                }
            } else if (al.getNombre().equals("")) {
                Files.write(salida, ("El Alumno " + nombreYMateria[0] + " " + nombreYMateria[1] + " No existe el/la alumno/a\n").getBytes(), StandardOpenOption.APPEND);
                System.out.println("El Alumno " + nombreYMateria[0] + " " + nombreYMateria[1] + " No existe el/la alumno/a");
            } else if (mat1.getNombre().equals("")) {
                Files.write(salida, ("El Alumno " + nombreYMateria[0] + " " + nombreYMateria[1] + " No existe la materia\n").getBytes(), StandardOpenOption.APPEND);
                System.out.println("El Alumno " + nombreYMateria[0] + " " + nombreYMateria[1] + " No existe la materia");
            }
        }
    }

}
