/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LambdaStreams;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author eliana
 */
public class TemarioDeClase3Y4 {
     public static void main(String[] args){
         
         List< Integer> numEnteros;
         numEnteros = new ArrayList<>();
         numEnteros.add(45);
         numEnteros.add(55);
         numEnteros.add(65);
         numEnteros.add(15);
         numEnteros.add(25);
         
         for (Integer n:numEnteros){
             System.out.println(n + "");
         }
         System.out.println("Ahora veremos con forEach");
         numEnteros.stream().forEach((num)-> System.out.println(num + "-"));
         
         
         Persona persona1= new Persona("Monica Lopez");
         Persona persona2= new Persona("Maria Mamani");
         Persona persona3= new Persona("Lucrecia Rossi");
         Persona persona4= new Persona("Marcelo Fuentes");
         
         List<Persona> lPersona= new ArrayList<Persona>();
         lPersona.add(persona1);
         lPersona.add(persona2);
         lPersona.add(persona3);
         lPersona.add(persona4);
         
          List< Integer> numEnt1= new ArrayList<>();
         numEnt1.add(45);
         numEnt1.add(55);
         numEnt1.add(65);
         numEnt1.add(15);
         numEnt1.add(25);
         
         boolean mayorEdad = numEnt1.stream().anyMatch((edad)-> edad > 18);
         System.out.println("Existen personas mayor de edad?"+ mayorEdad);
         
         boolean menorQue = numEnt1.stream().allMatch((a)-> a<18);
         System.out.println("Existen personas menor de 18?"+ menorQue);
         
        
         
         
     }
}
