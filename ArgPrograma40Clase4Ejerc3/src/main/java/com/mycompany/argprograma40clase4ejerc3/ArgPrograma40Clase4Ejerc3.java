/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.argprograma40clase4ejerc3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author eliana
 */
public class ArgPrograma40Clase4Ejerc3 {

    public static void main(String[] args) throws IOException {
        char tipoDeCodificacion= args[0].toLowerCase().charAt(0);
        int desplazamientos=Integer.parseInt(args[1]);
        String archivoEntrada= args[2];
        String archivoSalida= args [3];
        Path ingreso= Paths.get (archivoEntrada);
        Path salida= Paths.get (archivoSalida);
        Encriptado encriptado= new Encriptado();
        for(String linea:Files.readAllLines(ingreso)){
             if (tipoDeCodificacion=='c'){
                String resultado=encriptado.encriptar(linea, desplazamientos);
                Files.write(salida, resultado.getBytes(), StandardOpenOption.APPEND);
            }
            else if (tipoDeCodificacion=='d'){
                String resultado=encriptado.desencriptar(linea, desplazamientos);
                Files.write(salida, resultado.getBytes(), StandardOpenOption.APPEND);
            }
        }
        System.out.println ("Proceso exitoso");
        
    }
}
