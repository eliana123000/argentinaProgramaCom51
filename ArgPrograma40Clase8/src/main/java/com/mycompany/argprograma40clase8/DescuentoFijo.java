/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase8;

/**
 *
 * @author eliana
 */
public class DescuentoFijo extends Descuento {
    private Double monto;
    @Override
    public Double descuento(Double base) {
        return monto;
    }

    public DescuentoFijo(Double monto) {
        this.monto = monto;
    }

    public DescuentoFijo() {
    }
    
}
