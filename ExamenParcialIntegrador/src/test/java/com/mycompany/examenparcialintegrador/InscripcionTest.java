/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.examenparcialintegrador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author eliana
 */
public class InscripcionTest {

    public InscripcionTest() {
    }

    /**
     * Test of aprobada method, of class Inscripcion.
     */
    @Test
    public void testAprobada() {
        System.out.println("aprobada");
        Materia materia = new Materia("Programacion I", new ArrayList<Materia>());
        Alumno alumno = new Alumno("jose rodriguez", "123123123", new ArrayList<Materia>());
        Inscripcion instance = new Inscripcion(alumno, materia, new Date());
        boolean expResult = true;
        boolean result = instance.aprobada();
        assertEquals(expResult, result);

    }
    /**
     * Test of aprobadaCorrelativas method, of class Inscripcion.
     */
    @Test
    public void testAprobadaCorrelativas() {
        System.out.println("aprobadaCorrelativas");
        Materia materia = new Materia("Programacion I", new ArrayList<Materia>());
        Materia materia2 = new Materia("Programacion II", Arrays.asList(materia));
        Alumno alumno = new Alumno("jose rodriguez", "123123123", Arrays.asList(materia));
        Inscripcion instance = new Inscripcion(alumno, materia2, new Date());
        boolean expResult = true;
        boolean result = instance.aprobada();
        assertEquals(expResult, result);

    }

}
