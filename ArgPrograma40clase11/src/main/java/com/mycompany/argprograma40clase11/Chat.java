/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40clase11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


/**
 *
 * @author eliana
 */
public class Chat {

    private String archivo = "C:\\Users\\eliana\\Documents\\NetBeansProjects\\ArgPrograma40clase11\\src\\main\\java\\com\\mycompany\\argprograma40clase11\\Mensajes.txt";
    private Path archivoPath;

    public Chat() {
        archivoPath=Paths.get (archivo);
    }
    public void leer() throws IOException{
        for( String linea:Files.readAllLines(archivoPath)){
            System.out.println(linea);
        }
        
    }
    public void escribir(String nombre) throws IOException{
       System.out.println("Escriba su mensaje");
       Scanner sc= new Scanner (System.in);
       String mensaje= nombre + ": " + sc.nextLine()+ "\n";
       Files.write(archivoPath, mensaje.getBytes(), StandardOpenOption.APPEND);
    }
    
}
