/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.argprograma40clase4ejerc2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


/**
 *
 * @author eliana
 */
public class ArgPrograma40Clase4Ejerc2 {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        String archivoSuma="C:\\Users\\eliana\\Documents\\NetBeansProjects\\ArgPrograma40Clase4Ejerc2\\src\\main\\java\\com\\mycompany\\argprograma40clase4ejerc2\\NUMEROS.txt";
        System.out.println ("Elija la operacion  que quiere hacer con los numeros: m=multiplicacion, s=suma");
        Scanner sc= new Scanner (System.in);
        char cuenta =sc.nextLine().toLowerCase().charAt(0);
        int numeroFinal= Operacion (archivoSuma, cuenta);
        System.out.println("El resultado de su operacion es: "+ numeroFinal);
    }
    public static int Operacion (String archivoSuma, char cuenta) throws IOException{
        Path archivonumeros= Paths.get (archivoSuma);
        int resultado=0;
        for( String linea:Files.readAllLines(archivonumeros)){
            int linea2=Integer.parseInt(linea);
            if (cuenta=='m'){
                resultado=resultado * linea2;
            }
            else if (cuenta=='s'){
                resultado= resultado + linea2;
            }
        }
       return resultado; 
    }
    
}
