/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase578;

/**
 *
 * @author eliana
 */
public class Producto {
    private int cantidad;
    private float precio;
    private String nombre;
    private int codigoProducto;
    
    Producto (int cantidad, float precio, String nombre){
        this.cantidad=cantidad;
        this.nombre=nombre;
        this.precio=precio;
    }
    public float precio(){
        float resultado;
        resultado= cantidad * precio;
        return resultado;
    }
    
}
