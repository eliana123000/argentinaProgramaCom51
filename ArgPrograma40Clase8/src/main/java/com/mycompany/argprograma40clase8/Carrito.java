/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase8;

import java.util.List;

/**
 *
 * @author eliana
 */
public class Carrito {

    private int fecha;
    private List<ItemCarrito> items;

    public Double precio(Descuento desc) throws NoCeroException, NoNegativoExceptions {
        Double base = 0.0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i)==null){
                break;
            }
            base = base + items.get(i).precio();
        }
        Double fin=base - desc.descuento(base);
        if (base==0){
            throw new NoCeroException();
        }
        if (fin<0){
            throw new NoNegativoExceptions();
        }
        return fin ;
    }

    public Carrito(int fecha, List<ItemCarrito> items) {
        this.fecha = fecha;
        this.items = items;
    }
    
}
