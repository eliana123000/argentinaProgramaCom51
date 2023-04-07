/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase8;

/**
 *
 * @author eliana
 */
public class DescuentoPorcentajeConTope extends Descuento {

    private Double porcentajecontope;
    private Double tope;

    @Override
    public Double descuento(Double base) {
        if (base < tope) {
            return base * porcentajecontope;
        } else {
            return 0.0;
        }
    }

    public DescuentoPorcentajeConTope(Double porcentaje, Double tope) {
        this.porcentajecontope = porcentaje;
        this.tope = tope;
    }

    public DescuentoPorcentajeConTope() {
    }

}
