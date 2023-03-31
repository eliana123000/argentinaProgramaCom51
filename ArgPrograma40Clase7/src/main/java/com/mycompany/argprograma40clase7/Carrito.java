/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase7;

/**
 *
 * @author eliana
 */
public class Carrito {

    private int fecha;
    private ItemCarrito[] items;

    public Double precio(Descuento desc) {
        Double base = 0.0;
        for (int i = 0; i < items.length; i++) {
            if (items [i]==null){
                break;
            }
            base = base + items[i].precio();
        }
        return base - desc.descuento(base);
    }

    public Carrito(int fecha, ItemCarrito[] items) {
        this.fecha = fecha;
        this.items = items;
    }
    
}
