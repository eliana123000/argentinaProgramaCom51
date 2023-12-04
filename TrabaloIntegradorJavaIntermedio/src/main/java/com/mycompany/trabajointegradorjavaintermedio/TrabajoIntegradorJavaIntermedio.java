/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabajointegradorjavaintermedio;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author eliana
 */
public class TrabajoIntegradorJavaIntermedio {

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaIntegrador");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        
        System.out.println();
        System.out.println();
        System.out.println("*****Buen dia, identifiquese*****");
        System.out.println();
        System.out.println();
        List<Empleado> empleados = Empleado.getAll(em);
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
        Scanner entrada = new Scanner(System.in);
        boolean validaEntrada = true;
        int idEmpleado = 0;
        while (validaEntrada) {
            System.out.println();
            System.out.println("Ingrese el id del Empleado: ");
            idEmpleado = Integer.parseInt(entrada.nextLine());
            for (Empleado empleado : empleados) {
                if (empleado.getId() == idEmpleado) {
                    validaEntrada = false;
                    break;
                }
            }
        }
        Empleado empleado = em.find(Empleado.class, idEmpleado);
        switch (empleado.getRoles().get(0).getId()) {
            case 3: //  Atencion telefonica
                menuAtencionTelefonica(entrada, em);
                break;
            case 4: //  Recursos Humanos
                menuRRHH(entrada, em);
                break;
            case 5: //  Tecnico

                break;
            default:
                throw new AssertionError();
        }
        em.close();
    }

    public static void menuAtencionTelefonica(Scanner entrada, EntityManager em) {
        boolean validaEntrada = true;
        while (validaEntrada) {
            int accion = menuAccion(entrada, "MENU DE ATENCION TELEFONICA", "INCIDENTE");
            switch (accion) {
                case 1: // ALTA
                    Incidente.altaIncidente(entrada, em);
                    break;
                case 2: // BAJA   (NO SE LLEGO A HACER CODIGO)

                    break;
                case 3: // MODIFICACION
                    Incidente.modificarIncidente(entrada, em);
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println();
            System.out.println("Desea seguir en ABM Incidentes? S/N");
            String continuar = entrada.nextLine();
            if (continuar.toLowerCase().trim().equals("n")) {
                validaEntrada = false;
            }
        }
    }

    public static void menuRRHH(Scanner entrada, EntityManager em) {
        boolean validaEntrada = true;
        while (validaEntrada) {
            int accion = menuRRHHEntidad(entrada, "MENU DE RECURSOS HUMANOS");
            switch (accion) {
                case 1: // CLIENTE
                    menuRRHHCliente(entrada, em);
                    break;
                case 2: // EMPLEADO
                    menuRRHHEmpleado(entrada, em);
                    break;
                case 3: // SOPORTE
                    menuRRHHSoporte(entrada, em);
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println();
            System.out.println("Desea terminar? S/N");
            String continuar = entrada.nextLine();
            if (continuar.toLowerCase().trim().equals("s")) {
                validaEntrada = false;
            }
        }
    }

    public static void menuRRHHCliente(Scanner entrada, EntityManager em) {
        boolean validaEntrada = true;
        while (validaEntrada) {
            int accion = menuAccion(entrada, "MENU DE RECURSOS HUMANOS", "CLIENTE");
            switch (accion) {
                case 1: // ALTA
                    Cliente.altaCliente(entrada, em);
                    break;
                case 2: // BAJA   (NO SE LLEGO A HACER CODIGO)

                    break;
                case 3: // MODIFICACION
                    Cliente.modificarCliente(entrada, em);
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println();
            System.out.println("Desea seguir en ABM Clientes? S/N");
            String continuar = entrada.nextLine();
            if (continuar.toLowerCase().trim().equals("n")) {
                validaEntrada = false;
            }
        }
    }

    public static void menuRRHHEmpleado(Scanner entrada, EntityManager em) {
        boolean validaEntrada = true;
        while (validaEntrada) {
            int accion = menuAccion(entrada, "MENU DE RECURSOS HUMANOS", "EMPLEADO");
            switch (accion) {
                case 1: // ALTA
                    Empleado.altaEmpleado(entrada, em);
                    break;
                case 2: // BAJA   (NO SE LLEGO A HACER CODIGO)

                    break;
                case 3: // MODIFICACION
                    Empleado.modificarEmpleado(entrada, em);
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println();
            System.out.println("Desea seguir en ABM Empleados? S/N");
            String continuar = entrada.nextLine();
            if (continuar.toLowerCase().trim().equals("n")) {
                validaEntrada = false;
            }
        }
    }

    public static void menuRRHHSoporte(Scanner entrada, EntityManager em) {
        boolean validaEntrada = true;
        while (validaEntrada) {
            int accion = menuAccion(entrada, "MENU DE RECURSOS HUMANOS", "Soporte");
            switch (accion) {
                case 1: // ALTA
                    Soporte.altaSoporte(entrada, em);
                    break;
                case 2: // BAJA   (NO SE LLEGO A HACER CODIGO)

                    break;
                case 3: // MODIFICACION
                    Soporte.modificarSoporte(entrada, em);
                    break;
                default:
                    throw new AssertionError();
            }

            System.out.println();
            System.out.println("Desea seguir en ABM Soportes? S/N");
            String continuar = entrada.nextLine();
            if (continuar.toLowerCase().trim().equals("n")) {
                validaEntrada = false;
            }
        }
    }

    public static int menuRRHHEntidad(Scanner entrada, String titulo) {
        System.out.println();
        System.out.println();
        System.out.println("*****" + titulo + "*****");
        int entidad;

        boolean validaEntrada = true;
        entidad = 0;
        while (validaEntrada) {
            System.out.println("Ingrese el numero de entidad deseada: ");
            System.out.println("1 - CLIENTE");
            System.out.println("2 - EMPLEADO");
            System.out.println("3 - SOPORTE");
            entidad = Integer.parseInt(entrada.nextLine());
            validaEntrada = (entidad <= 0 || entidad > 3);
        }
        return entidad;
    }

    public static int menuAccion(Scanner entrada, String titulo, String entidad) {
        System.out.println();
        System.out.println();
        System.out.println("*****" + titulo + "*****");
        int accion;
        boolean validaEntrada = true;
        accion = 0;
        while (validaEntrada) {
            System.out.println("Ingrese el numero de acción a realizar: ");
            System.out.println("-" + entidad + "-");
            System.out.println("1 - ALTA");
            System.out.println("2 - BAJA");     // NO SE LLEGO A HACER CODIGO
            System.out.println("3 - MODIFICACION");
            accion = Integer.parseInt(entrada.nextLine());
            validaEntrada = (accion <= 0 || accion > 3);
        }

        return accion;
    }
}
