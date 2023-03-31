/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.argprograma40clase7;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author eliana
 */
public class ArgPrograma40Clase7 {

    public static void main(String[] args) {
        Producto producto[] = new Producto[3];
        producto[0] = new Producto(40.0, "jabon en polvo");
        producto[1] = new Producto(10.0, "esponjas");
        producto[2] = new Producto(100.0, "chocolate");
        for (int i = 0; i < producto.length; i++) {
            System.out.println(producto[i].getNombre() + " $" + producto[i].getPrecio());
        }
        ItemCarrito items[] = new ItemCarrito[3];
        Scanner sc = new Scanner(System.in);
        for (int j = 0; j < items.length; j++) {
            System.out.println("Elija que producto quiere,ingresando 1,2 o 3 para la opcion deseada ");
            int opcion = sc.nextInt();
            System.out.println("Ingrese la cantidad deseada ");
            int cantidad = sc.nextInt();
            items[j] = new ItemCarrito(cantidad, producto[opcion - 1]);
            if (j < items.length-1) {
                System.out.println("Desea seguir cargando productos? 1: SI , 2: NO");
                int seguir = sc.nextInt();
                if (seguir == 2) {
                    break;
                }
            }

        }
        Descuento desc = new DescuentoPorcentajeConTope(0.15, 3000.0);
        Carrito carritoCompras = new Carrito(30032023, items);
        Double total = carritoCompras.precio(desc);
        System.out.println("Su precio total a pagar es:$" + total);
    }
}
