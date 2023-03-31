/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase7;

import java.time.LocalDate;

/**
 *
 * @author eliana
 */
public abstract class Descuento {
    public LocalDate comienzo;
    public LocalDate fin;
    public abstract Double descuento (Double base);
    
    
}
