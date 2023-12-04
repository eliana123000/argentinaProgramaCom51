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
import javax.persistence.OneToOne;
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
@Table(name = "incidente")
public class Incidente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "ID_SEQ")
    private int id;

    @OneToOne
    private Cliente cliente;

    @OneToOne
    private Empleado empleado;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Soporte> soportes;

    public Incidente() {
    }

    public Incidente(Cliente cliente, Empleado empleado, List<Soporte> soportes) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.soportes = soportes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Soporte> getSoportes() {
        return soportes;
    }

    public void setSoportes(List<Soporte> soportes) {
        this.soportes = soportes;
    }

    public static void altaIncidente(Scanner entrada, EntityManager em) {
        Incidente incidente;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println();
        boolean validaEntrada = true;
        int idCliente = 0;
        int idEmpleado = 0;
        List<Integer> idsSoportes = new ArrayList<Integer>();

        System.out.println("*****INGRESE LOS SIGUIENTES DATOS DEL INCIDENTE****");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("Ingrese el id del Cliente: ");
            List<Cliente> clientes = Cliente.getAll(em);
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toString());
            }
            idCliente = Integer.parseInt(entrada.nextLine());
            for (Cliente cliente : clientes) {
                if (cliente.getId() == idCliente) {
                    validaEntrada = false;
                    break;
                }
            }
        }
        validaEntrada = true;
        while (validaEntrada) {
            System.out.println("Ingrese el id del Tecnico: ");
            List<Empleado> empleados = Empleado.getAll(em);
            for (Empleado empleado : empleados) {
                if (empleado.getRoles().get(0).getId() == 5) {
                    System.out.println(empleado.toString());
                }
            }
            idEmpleado = Integer.parseInt(entrada.nextLine());
            for (Empleado empleado : empleados) {
                if (empleado.getId() == idEmpleado) {
                    validaEntrada = false;
                    break;
                }
            }
        }
        validaEntrada = true;
        while (validaEntrada) {
            System.out.println("Ingrese el id del Soporte: ");
            Cliente cliente = em.find(Cliente.class, idCliente);
            for (Soporte soporteCli : cliente.getSoportes()) {
                System.out.println(soporteCli.toString());
            }
            Integer idSoporte = Integer.parseInt(entrada.nextLine());
            for (Soporte soporteCli : cliente.getSoportes()) {
                if (soporteCli.getId() == idSoporte) {
                    validaEntrada = false;
                    break;
                }
            }
            if (!validaEntrada) {
                idsSoportes.add(idSoporte);
                System.out.println("Desea seguir agregando soportes al Incidente? S/N");
                String continuar = entrada.nextLine();
                if (continuar.toLowerCase().trim().equals("s")) {
                    validaEntrada = true;
                }
            }
        }

        Cliente cliente = em.find(Cliente.class, idCliente);
        Empleado empleado = em.find(Empleado.class, idEmpleado);
        List<Soporte> soportesCliente = new ArrayList<Soporte>();
        for (Integer idSoporte : idsSoportes) {
            Soporte soporteCliente = em.find(Soporte.class, idSoporte);
            soportesCliente.add(soporteCliente);
        }
        incidente = new Incidente(cliente, empleado, soportesCliente);

        em.persist(incidente);
        tx.commit();
    }

    public static void modificarIncidente(Scanner entrada, EntityManager em) {
        Incidente incidente = null;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        System.out.println();
        boolean validaEntrada = true;
        List<Integer> idsSoportes = new ArrayList<Integer>();

        System.out.println("********SELECCIONE EL INCIDENTE A MODIFICAR********");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");
        while (validaEntrada) {
            System.out.println("Ingrese el id del Incidente: ");
            System.out.println();

            List<Incidente> incidentes = Incidente.getAll(em);
            for (Incidente incidenteMostrar : incidentes) {
                System.out.println(incidenteMostrar.toString());
            }
            int idIncidente = Integer.parseInt(entrada.nextLine());
            for (Incidente incidenteMostrar : incidentes) {
                if (incidenteMostrar.getId() == idIncidente) {
                    incidente = em.find(Incidente.class, idIncidente);
                    validaEntrada = false;
                    break;
                }
            }
        }

        System.out.println("*****MODIFIQUE LOS SIGUIENTES DATOS DEL INCIDENTE****");
        System.out.println("***********RESPETANDO LAS INDICACIONES*************");

        System.out.println(incidente.getCliente().toString());
        System.out.println("Desea modificar el Cliente? S/N");
        String modificar = entrada.nextLine();
        if (modificar.toLowerCase().trim().equals("s")) {
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el id del Cliente: ");
                List<Cliente> clientes = Cliente.getAll(em);
                for (Cliente cliente : clientes) {
                    System.out.println(cliente.toString());
                }
                int idCliente = Integer.parseInt(entrada.nextLine());
                for (Cliente cliente : clientes) {
                    if (cliente.getId() == idCliente) {
                        if (incidente != null) {
                            incidente.setCliente(cliente);
                        }
                        validaEntrada = false;
                        break;
                    }
                }
            }
        }

        System.out.println(incidente.getEmpleado().toString());
        System.out.println("Desea modificar el Tecnico? S/N");

        modificar = entrada.nextLine();
        if (modificar.toLowerCase().trim().equals("s")) {
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el id del Tecnico: ");
                List<Empleado> empleados = Empleado.getAll(em);
                for (Empleado empleado : empleados) {
                    if (empleado.getRoles().get(0).getId() == 5) {
                        System.out.println(empleado.toString());
                    }
                }
                int idEmpleado = Integer.parseInt(entrada.nextLine());
                for (Empleado empleado : empleados) {
                    if (empleado.getId() == idEmpleado) {
                        if (incidente != null) {
                            incidente.setEmpleado(empleado);
                        }
                        validaEntrada = false;
                        break;
                    }
                }
            }
        }

        for (Soporte soporteCli : incidente.getSoportes()) {
            System.out.println(soporteCli.toString());
        }
        System.out.println("Desea modificar los Soportes del incidente? S/N");
        modificar = entrada.nextLine();
        if (modificar.toLowerCase().trim().equals("s")) {
            validaEntrada = true;
            while (validaEntrada) {
                System.out.println("Ingrese el id del Soporte: ");
                for (Soporte soporteCli : incidente.getCliente().getSoportes()) {
                    System.out.println(soporteCli.toString());
                }
                Integer idSoporte = Integer.parseInt(entrada.nextLine());
                for (Soporte soporteCli : incidente.getCliente().getSoportes()) {
                    if (soporteCli.getId() == idSoporte) {
                        validaEntrada = false;
                        break;
                    }
                }
                if (!validaEntrada) {
                    idsSoportes.add(idSoporte);
                    System.out.println("Desea seguir agregando soportes al Incidente? S/N");
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
            incidente.setSoportes(soportesCliente);
        }

        em.merge(incidente);
        tx.commit();
    }

    public static List<Incidente> getAll(EntityManager em) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Incidente> cq = cb.createQuery(Incidente.class);
        Root<Incidente> rootEntry = cq.from(Incidente.class);
        CriteriaQuery<Incidente> all = cq.select(rootEntry);
        TypedQuery<Incidente> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public String toString() {
        String ret = "Incidente{" + "id=" + id + ", cliente=" + cliente + ", empleado=" + empleado + ", soportes=";
        for (Soporte soporte : soportes) {
            ret += soporte.getNombre() + ", ";
        }
        ret += "}";
        return ret;
    }

}
