/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase7;

/**
 *
 * @author eliana
 */
public class DescuentoFijo extends Descuento {
    private int monto;
    @Override
    public int descuento(int base) {
        return monto;
    }

    public DescuentoFijo(int monto) {
        this.monto = monto;
    }

    public DescuentoFijo() {
    }
    
}
