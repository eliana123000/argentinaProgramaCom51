/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase578;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author eliana
 */
public class Carrito {
    private Producto[] prod = new Producto[3];
    Carrito () throws IOException{
        String archivoPrecioFinal="C:\\Users\\eliana\\Documents\\NetBeansProjects\\ArgPrograma40clase578\\src\\main\\java\\com\\mycompany\\argprograma40clase578\\listadeproductos.txt";
        Path archivoProductos= Paths.get (archivoPrecioFinal);
        int i=0;
        for( String linea:Files.readAllLines(archivoProductos)){
            String[] datoDeLinea=linea.split(",");
            prod[i] = new Producto(Integer.parseInt(datoDeLinea[0]),Float.parseFloat(datoDeLinea[1]),datoDeLinea[2]);
            i++;
        }
    }
    public float precio(){
        float resultado=0;
        for (Producto prod1:prod ){
            resultado= resultado + prod1.precio();
        }
        return resultado;
    }
    
}
