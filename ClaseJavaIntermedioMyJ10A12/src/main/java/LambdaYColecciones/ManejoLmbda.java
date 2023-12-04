/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LambdaYColecciones;

/**
 *
 * @author eliana
 */
public class ManejoLmbda {
     public static void main(String[] args) {
         Suma lamb1;
         lamb1= (a,b)-> a+b;
         lamb1.sumar (45, 74);
         int resultado = lamb1.sumar (45,74);
         System.out.println("el resultado es:" + resultado);
         
         //Calcular lamb3 =()-> System.out.println("Mi priimer expresion lambda");
         //lamb3.mostrar();
         Calcular lamb4 =(msj)-> System.out.println("Mi priimer expresion lambda" + msj);
         lamb4.mostrar2("mensaje lambda de ARG.PROG4.0");
         
         //Lambda como parametro de un metodo
         int suma = calcular (80, 42, (unNumero, otroNumero)-> unNumero + otroNumero);
         System.out.println("el resultado es:" + suma);
     }

    public static int calcular(int unNumero, int otroNumero, Operacion operacion) {
        return operacion.aplicar(unNumero, otroNumero);
    }
}