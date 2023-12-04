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
@Table(name = "cliente")
public class Cliente {

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private int id;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Soporte> soportes;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, List<Soporte> soportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.soportes = soportes;
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

    public Cliente(String nomb) {
        nombre = nomb;
    }

    public List<Soporte> getSoportes() {
        return soportes;
    }

    public void setSoportes(List<Soporte> soportes) {
        this.soportes = soportes;
    }

    public static void altaCliente(Scanner entrada, EntityManager em) {
        Cliente cliente;
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        System.out.println();
        boolean validaEntrada = true;
        String nom = " ", ape = "";
        List<Integer> idsSoportes = new ArrayList<Integer>();

        System.out.println("*****INGRESE LOS SIGUIENTES DATOS DEL CLIENTE******");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("Ingrese el NOMBRE del Cliente: ");
            nom = entrada.nextLine();
            validaEntrada = nom.isEmpty();
        }
        validaEntrada = true;
        while (validaEntrada) {
            System.out.println("Ingrese el APELLIDO del Cliente: ");
            ape = entrada.nextLine();
            validaEntrada = ape.isEmpty();
        }
        validaEntrada = true;
        while (validaEntrada) {
            System.out.println("Ingrese el id soporte del Cliente: ");
            List<Soporte> soportes = Soporte.getAll(em);
            for (Soporte soporte : soportes) {
                System.out.println(soporte.toString());
            }
            Integer idSoporte = Integer.parseInt(entrada.nextLine());
            for (Soporte soporte : soportes) {
                if (soporte.getId() == idSoporte) {
                    validaEntrada = false;
                    break;
                }
            }
            if (!validaEntrada) {
                idsSoportes.add(idSoporte);
                System.out.println("Desea seguir agregando soportes al Cliente? S/N");

                String continuar = entrada.nextLine();
                if (continuar.toLowerCase().trim().equals("s")) {
                    validaEntrada = true;
                }
            }
        }
        List<Soporte> soportesCliente = new ArrayList<Soporte>();
        for (Integer idSoporte : idsSoportes) {
            Soporte soporteCliente = em.find(Soporte.class, idSoporte);
            soportesCliente.add(soporteCliente);
        }
        cliente = new Cliente(nom, ape, soportesCliente);

        em.persist(cliente);
        tx.commit();
    }

    public static void modificarCliente(Scanner entrada, EntityManager em) {
        Cliente cliente = null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        System.out.println();
        boolean validaEntrada = true;
        List<Integer> idsSoportes = new ArrayList<Integer>();

        System.out.println("*********SELECCIONE EL CLIENTE A MODIFICAR*********");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("Ingrese el id del Cliente: ");
            System.out.println();

            List<Cliente> clientes = Cliente.getAll(em);
            for (Cliente clienteMostrar : clientes) {
                System.out.println(clienteMostrar.toString());
            }
            int idCliente = Integer.parseInt(entrada.nextLine());
            for (Cliente clienteMuestra : clientes) {
                if (clienteMuestra.getId() == idCliente) {
                    cliente = em.find(Cliente.class, idCliente);
                    validaEntrada = false;
                    break;
                }
            }
        }

        System.out.println("*****MODIFIQUE LOS SIGUIENTES DATOS DEL CLIENTE******");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        System.out.println("Modifique el NOMBRE del Cliente: " + cliente.getNombre());

        String nom = entrada.nextLine();
        if (!nom.isEmpty()) {
            cliente.setNombre(nom);
        }

        System.out.println("Modifique el APELLIDO del Cliente: " + cliente.getApellido());
        String ape = entrada.nextLine();
        if (!ape.isEmpty()) {
            cliente.setApellido(ape);
        }

        for (Soporte soporteCli : cliente.getSoportes()) {
            System.out.println(soporteCli.toString());
        }

        System.out.println("Desea modificar los soportes? S/N");
        String modificar = entrada.nextLine();
        if (modificar.toLowerCase().trim().equals("s")) {
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingresar el id soporte del Cliente: ");
                List<Soporte> soportes = Soporte.getAll(em);
                for (Soporte soporte : soportes) {
                    System.out.println(soporte.toString());
                }
                Integer idSoporte = Integer.parseInt(entrada.nextLine());
                for (Soporte soporte : soportes) {
                    if (soporte.getId() == idSoporte) {
                        validaEntrada = false;
                        break;
                    }
                }
                if (!validaEntrada) {
                    idsSoportes.add(idSoporte);
                    System.out.println("Desea seguir agregando soportes al Cliente? S/N");

                    String continuar = entrada.nextLine();
                    if (continuar.toLowerCase().trim().equals("s")) {
                        validaEntrada = true;
                    }
                }
            }
        }
        List<Soporte> soportesCliente = new ArrayList<Soporte>();
        for (Integer idSoporte : idsSoportes) {
            Soporte soporteCliente = em.find(Soporte.class, idSoporte);
            soportesCliente.add(soporteCliente);
        }
        if (!soportesCliente.isEmpty()) {
            cliente.setSoportes(soportesCliente);
        }

        em.merge(cliente);
        tx.commit();
    }

    public static List<Cliente> getAll(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> rootEntry = cq.from(Cliente.class);
        CriteriaQuery<Cliente> all = cq.select(rootEntry);
        TypedQuery<Cliente> allQuery = em.createQuery(all);
        List<Cliente> empleados = allQuery.getResultList();
        return empleados;
    }

    @Override
    public String toString() {
        String ret = "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", soportes=";
        for (Soporte soporte : soportes) {
            ret += soporte.getNombre() + ", ";
        }
        ret += "}";
        return ret;
    }

}
