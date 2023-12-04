/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajointegradorjavaintermedio;

import java.util.List;
import java.util.Scanner;
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
@Table(name = "soporte")
public class Soporte {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "soportes")
    private List<Cliente> cliente;

    public Soporte() {
    }

    public Soporte(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClientes() {
        return cliente;
    }

    public void setClientes(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public static void altaSoporte(Scanner entrada, EntityManager em) {
        Soporte soporte;
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        System.out.println();
        boolean validaEntrada = true;
        String nombre = " ";

        System.out.println("******INGRESE LOS SIGUIENTES DATOS DEL SOPORTE*****");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("Ingrese el NOMBRE del Soporte: ");
            nombre = entrada.nextLine();
            validaEntrada = nombre.isEmpty();
        }
        soporte = new Soporte(nombre);

        em.persist(soporte);
        tx.commit();
    }

    public static void modificarSoporte(Scanner entrada, EntityManager em) {
        Soporte soporte = null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        System.out.println();
        boolean validaEntrada = true;

        System.out.println("*********SELECCIONE EL SOPORTE A MODIFICAR*********");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("Ingrese el id del Soporte: ");
            System.out.println();

            List<Soporte> soportes = Soporte.getAll(em);
            for (Soporte soporteMostrar : soportes) {
                System.out.println(soporteMostrar.toString());
            }
            int idSoporte = Integer.parseInt(entrada.nextLine());
            for (Soporte soporteMostrar : soportes) {
                if (soporteMostrar.getId() == idSoporte) {
                    soporte = em.find(Soporte.class, idSoporte);
                    validaEntrada = false;
                    break;
                }
            }
        }

        System.out.println("******MODIFIQUE LOS SIGUIENTES DATOS DEL SOPORTE*****");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        System.out.println("Modifique el NOMBRE del Soporte: " + soporte.getNombre());
        String nombre = entrada.nextLine();
        if (!nombre.isEmpty()) {
            soporte.setNombre(nombre);
        }

        em.merge(soporte);
        tx.commit();
    }

    public static List<Soporte> getAll(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Soporte> cq = cb.createQuery(Soporte.class);
        Root<Soporte> rootEntry = cq.from(Soporte.class);
        CriteriaQuery<Soporte> all = cq.select(rootEntry);
        TypedQuery<Soporte> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public String toString() {
        return "Soporte{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
