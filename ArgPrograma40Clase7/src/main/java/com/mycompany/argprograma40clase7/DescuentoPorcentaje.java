/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase7;

/**
 *
 * @author eliana
 */
public class DescuentoPorcentaje extends Descuento {
    private Double porcentaje;
    @Override
    public int descuento(int base) {
        return base * porcentaje.intValue();
    }

    public DescuentoPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public DescuentoPorcentaje() {
    }
    
}
