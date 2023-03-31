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
    public Double descuento(Double base) {
        return base * porcentaje;
    }

    public DescuentoPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public DescuentoPorcentaje() {
    }
    
}
