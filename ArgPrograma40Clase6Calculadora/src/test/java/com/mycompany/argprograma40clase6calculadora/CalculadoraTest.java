/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.argprograma40clase6calculadora;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author eliana
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of sumar method, of class Calculadora.
     */
    @org.junit.jupiter.api.Test
    public void testSumar() {
        System.out.println("sumar");
        double unNumero = 0.0;
        double otroNumero = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.sumar(unNumero, otroNumero);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of restar method, of class Calculadora.
     */
    @org.junit.jupiter.api.Test
    public void testRestar() {
        System.out.println("restar");
        double unNumero = 0.0;
        double otroNumero = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.restar(unNumero, otroNumero);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of dividir method, of class Calculadora.
     */
    @org.junit.jupiter.api.Test
    public void testDividir() {
        System.out.println("dividir");
        double unNumero = 1.0;
        double otroNumero = 1.0;
        Calculadora instance = new Calculadora();
        double expResult = 1.0;
        double result = instance.dividir(unNumero, otroNumero);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of multiplicar method, of class Calculadora.
     */
    @org.junit.jupiter.api.Test
    public void testMultiplicar() {
        System.out.println("multiplicar");
        double unNumero = 0.0;
        double otroNumero = 0.0;
        Calculadora instance = new Calculadora();
        double expResult = 0.0;
        double result = instance.multiplicar(unNumero, otroNumero);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @org.junit.jupiter.api.Test
    public void testOperacion1() {
        System.out.println("80*3=240");
        double unNumero = 80;
        double otroNumero = 3;
        Calculadora instance = new Calculadora();
        double expResult = 240;
        double result = instance.multiplicar(unNumero, otroNumero);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @org.junit.jupiter.api.Test
    public void testOperacion2() {
        System.out.println("(150 + 180)/3=110");
        double unNumero = 150;
        double otroNumero = 180;
        Calculadora instance = new Calculadora();
        double expResult = 110;
        double result = instance.sumar(unNumero, otroNumero);
        result = instance.dividir(result, 3);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @org.junit.jupiter.api.Test
    public void testOperacion3() {
        System.out.println("(90 - 50)*15 != 105");
        double unNumero = 90;
        double otroNumero = 50;
        Calculadora instance = new Calculadora();
        double expResult = 105;
        double result = instance.restar(unNumero, otroNumero);
        result = instance.multiplicar(result, 15);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @org.junit.jupiter.api.Test
    public void testOperacion4() {
        System.out.println("(70 + 40)* 25 != 2700");
        double unNumero = 70;
        double otroNumero = 40;
        Calculadora instance = new Calculadora();
        double expResult = 2700;
        double result = instance.sumar(unNumero, otroNumero);
        result = instance.multiplicar(result, 25);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
