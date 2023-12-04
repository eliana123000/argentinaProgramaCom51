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
@Table(name = "rol")
public class Rol {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private int id;

    @Column(name = "departamento")
    private String departamento;

    @ManyToMany(mappedBy = "roles")
    private List<Empleado> empleado;

    public Rol() {
    }

    public Rol(String departamento) {
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<Empleado> getEmpleados() {
        return empleado;
    }

    public void setEmpleados(List<Empleado> empleado) {
        this.empleado = empleado;
    }

    public static void altaRol(Scanner entrada, EntityManager em) {
        Rol rol;
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        System.out.println();
        boolean validaEntrada = true;
        String depart = " ";
        
        System.out.println("********INGRESE LOS SIGUIENTES DATOS DEL ROL*******");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("Ingrese el NOMBRE del Departamento: ");
            depart = entrada.nextLine();
            validaEntrada = depart.isEmpty();
        }
        rol = new Rol(depart);

        em.persist(rol);
        tx.commit();
    }

    public static List<Rol> getAll(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Rol> cq = cb.createQuery(Rol.class);
        Root<Rol> rootEntry = cq.from(Rol.class);
        CriteriaQuery<Rol> all = cq.select(rootEntry);
        TypedQuery<Rol> allQuery = em.createQuery(all);
        List<Rol> roles = allQuery.getResultList();
        return roles;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", departamento=" + departamento + ", empleado=" + empleado + '}';
    }

}
