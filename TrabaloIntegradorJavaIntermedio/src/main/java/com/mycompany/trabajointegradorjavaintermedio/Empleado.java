/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajointegradorjavaintermedio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author eliana
 */
@Entity
@Table(name = "empleado")
public class Empleado {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private int id;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Rol> roles;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, List<Rol> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.roles = roles;
    }

    public static void altaEmpleado(Scanner entrada, EntityManager em) {
        Empleado empl;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println();
        boolean validaEntrada = true;
        String nom = " ", ape = "";
        int idRol = 0;

        System.out.println("*****INGRESE LOS SIGUIENTES DATOS DEL EMPLEADO*****");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("Ingrese el NOMBRE del Empleado: ");
            nom = entrada.nextLine();
            validaEntrada = nom.isEmpty();
        }
        validaEntrada = true;
        while (validaEntrada) {
            System.out.println("Ingrese el APELLIDO del Empleado: ");
            ape = entrada.nextLine();
            validaEntrada = ape.isEmpty();
        }
        validaEntrada = true;
        while (validaEntrada) {
            System.out.println("Ingrese el id departamento del Empleado: ");
            List<Rol> roles = Rol.getAll(em);
            for (Rol rol : roles) {
                System.out.println(rol.toString());
            }
            idRol = Integer.parseInt(entrada.nextLine());
            for (Rol role : roles) {
                if (role.getId() == idRol) {
                    validaEntrada = false;
                    break;
                }
            }
        }
        Rol rolEmpleado = em.find(Rol.class, idRol);
        List<Rol> rolesEmpleado = new ArrayList<Rol>();
        rolesEmpleado.add(rolEmpleado);
        empl = new Empleado(nom, ape, rolesEmpleado);

        em.persist(empl);
        tx.commit();
    }

    public static void modificarEmpleado(Scanner entrada, EntityManager em) {
        Empleado empl = null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println();
        boolean validaEntrada = true;
        int idRol = 0;

        System.out.println("********SELECCIONE EL EMPLEADO A MODIFICAR*********");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println();
            System.out.println("Ingrese el id del Empleado: ");

            List<Empleado> empleados = Empleado.getAll(em);
            for (Empleado empleado : empleados) {
                System.out.println(empleado.toString());
            }
            int idEmpleado = Integer.parseInt(entrada.nextLine());
            for (Empleado empleadoMuestra : empleados) {
                if (empleadoMuestra.getId() == idEmpleado) {
                    empl = em.find(Empleado.class, idEmpleado);
                    validaEntrada = false;
                    break;
                }
            }
        }

        System.out.println("****MODIFIQUE LOS SIGUIENTES DATOS DEL EMPLEADO****");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");

        System.out.println("Modifique el NOMBRE del Empleado: " + empl.getNombre());
        String nom = entrada.nextLine();
        if (!nom.isEmpty()) {
            empl.setNombre(nom);
        }

        System.out.println("Modifique el APELLIDO del Empleado: " + empl.getApellido());
        String ape = entrada.nextLine();
        if (!ape.isEmpty()) {
            empl.setApellido(ape);
        }

        for (Rol rol : empl.getRoles()) {
            System.out.println(rol.toString());
        }

        System.out.println("Desea modificar el departamento al que corresponde el empleado? S/N");
        String modificar = entrada.nextLine();
        if (modificar.toLowerCase().trim().equals("s")) {
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el id departamento del Empleado: ");
                List<Rol> roles = Rol.getAll(em);
                for (Rol rol : roles) {
                    System.out.println(rol.toString());
                }
                idRol = Integer.parseInt(entrada.nextLine());
                for (Rol role : roles) {
                    if (role.getId() == idRol) {
                        validaEntrada = false;
                        break;
                    }
                }
            }
        }
        if (idRol != 0) {
            Rol rolEmpleado = em.find(Rol.class, idRol);
            List<Rol> rolesEmpleado = new ArrayList<Rol>();
            rolesEmpleado.add(rolEmpleado);
            empl.setRoles(rolesEmpleado);
        }
        em.merge(empl);
        tx.commit();
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(String nomb) {
        nombre = nomb;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public static List<Empleado> getAll(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> cq = cb.createQuery(Empleado.class);
        Root<Empleado> rootEntry = cq.from(Empleado.class);
        CriteriaQuery<Empleado> all = cq.select(rootEntry);
        TypedQuery<Empleado> allQuery = em.createQuery(all);
        List<Empleado> empleados = allQuery.getResultList();
        return empleados;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", roles=" + roles.get(0).getDepartamento() + '}';
    }

}
