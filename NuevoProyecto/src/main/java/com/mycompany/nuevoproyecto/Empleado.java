/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nuevoproyecto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author eliana
 */
@Entity
@Table(name="empleado")
public class Empleado {
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=SEQUENCE, generator="ID_SEQ")
    private int id;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
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
    public Empleado (String nomb){
        nombre= nomb;
    }
    
}
