/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenfinalargprograma40;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliana
 */
public class Alumnos {
    private int legajo;
    private String nombre;
    private String apellido;
    private List<Integer> materiasAprobadas;

    public Alumnos() {
    }

    public Alumnos(int legajo, String nombre, String apellido, List<Integer> materiasAprobadas) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = materiasAprobadas;
    }


    public int recuperarIdAlumno() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpexamenfinal", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("Select id From alumnos where legajo =?");
            pstmt.setInt(1, legajo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return rs.getInt("id");
            }
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al ingresar materia");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Materias.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void escribirAlumno() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpexamenfinal", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("Insert into alumnos (legajo, nombre, apellido) values (?, ?, ?)");
            pstmt.setInt(1, legajo);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellido);
            int result = pstmt.executeUpdate();
            int alumnoid = recuperarIdAlumno();
            pstmt.close();
            for (int i = 0; i < materiasAprobadas.size(); i++) {
                pstmt = con.prepareStatement("Insert into correlativas (idMAT , idcorrellativa) values (? , ?)");
                pstmt.setInt(2, materiasAprobadas.get(i));
                pstmt.setInt(1, alumnoid);
                result = pstmt.executeUpdate();
                pstmt.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al ingresar materia");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Materias.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
