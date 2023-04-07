/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.argprograma40clase8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliana
 */
public class ArgPrograma40Clase8 {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto(40.0, "jabon en polvo"));
        productos.add(new Producto(10.0, "esponjas"));
        productos.add(new Producto(100.0, "chocolate"));
        int id = 1;
        for (Producto prod : productos) {
            System.out.println(id + " " + prod.getNombre() + " $" + prod.getPrecio());
            id++;
        }
        List<ItemCarrito> items = new ArrayList<ItemCarrito>();
        Scanner sc = new Scanner(System.in);
        int seguir = 1;
        while (seguir == 1) {
            System.out.println("Elija que producto quiere,ingresando el id para la opcion deseada ");
            int opcion = sc.nextInt();
            System.out.println("Ingrese la cantidad deseada ");
            int cantidad = sc.nextInt();
            if (opcion>0 && opcion<productos.size()){
                items.add(new ItemCarrito(cantidad, productos.get(opcion - 1)));
            }
            System.out.println("Desea seguir cargando productos? 1: SI , 2: NO");
            seguir = sc.nextInt();
        }
        Descuento desc = new DescuentoPorcentajeConTope(0.15, 3000.0);
        Carrito carritoCompras = new Carrito(30032023, items);
        Double total;
        try {
            total = carritoCompras.precio(desc);
            System.out.println("Su precio total a pagar es:$" + total);
        } catch (NoCeroException ex) {
            System.out.println("No se puede aplicar un descuento a un carrito de precio 0");
        } catch (NoNegativoExceptions ex) {
            System.out.println(" El resultado del descuento no puede dar un monto negativo");
        }

    }
}
