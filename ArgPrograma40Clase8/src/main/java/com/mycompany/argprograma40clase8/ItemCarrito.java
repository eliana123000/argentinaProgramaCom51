/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase8;

/**
 *
 * @author eliana
 */
public class ItemCarrito {
    private int cantidad;
    private Producto producto;

    public ItemCarrito() {
    }

    public ItemCarrito(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    public Double precio(){
        return cantidad * producto.getPrecio();
    }
}
