/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.argprograma40clase578;

import java.io.IOException;

/**
 *
 * @author eliana
 */
public class ArgPrograma40clase578 {

    public static void main(String[] args) throws IOException {
        Carrito carrito = new Carrito();
        float valorTotal = carrito.precio();
        System.out.println("El valor total de la compra es: " + valorTotal);
    }
}
