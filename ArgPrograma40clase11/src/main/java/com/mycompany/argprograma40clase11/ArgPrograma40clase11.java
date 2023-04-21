/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.argprograma40clase11;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author eliana
 */
public class ArgPrograma40clase11 {

    //Escribir un programa de consola que permite chatear de la siguiente forma:
//1. Se tienen que ejecutar varios procesos del mismo programa
//2. Todos al inicializar, tienen que indicar el nombre de la persona
//3. Por la consola tiene que poder ingresar 2 opciones, escribir un mensaje o leer todos los mensajes
//4. cuando elige escribir mensaje, se ingresa el mismo y se escribe en el archivo
//5. otro proceso debe leer todos los mensajes y ver lo que escribio el anterior
//6. El proceso anterior se debe repetir todas las veces que uno quiera
//7. Vale aclarar, que no se leen automáticamente los mensajes, uno debe elegir dicha opción.
    public static void main(String[] args) throws IOException {
        System.out.println("Hola, soy tu asistente. ");
        System.out.println("Dime tu nombre por favor?. ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Dime, Quieres leer? digita 1");
        System.out.println("");
        System.out.println("Quieres escribir un mensaje? digita 2");
        System.out.println("");
        System.out.println("Quieres terminar? digita 3 ");
        int opc = sc.nextInt();
        Chat chat = new Chat();
        while (opc != 3) {
            switch (opc) {
                case 1:
                     System.out.println("");
                    chat.leer();
                     System.out.println("");
                    break;
                case 2:
                    chat.escribir(nombre);
                    break;

            }
            System.out.println("Dime, Quieres leer? digita 1");
            System.out.println("");
            System.out.println("Quieres escribir un mensaje? digita 2");
            System.out.println("");
            System.out.println("Quieres terminar? digita 3 ");
            opc = sc.nextInt();
        }

    }
}
