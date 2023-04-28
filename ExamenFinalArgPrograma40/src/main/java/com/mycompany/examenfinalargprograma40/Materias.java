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
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliana
 */
public class Materias {

    private String nombre;
    private List<Integer> correlativas;

    public Materias() {
    }

    public Materias(String nombre, List<Integer> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public void mostrarTodasMaterias() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpexamenfinal", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("Select * From materias ");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("codigo de materia" + rs.getInt("id")
                        + "nombre de materia:" + rs.getString("materia"));
            }
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar todas las materia");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Materias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int recuperarIdMateria() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpexamenfinal", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("Select id From materias where materias =?");
            pstmt.setString(1, nombre);
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

    public void escribirMateria() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpexamenfinal", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("Insert into materias (materias) values (?)");
            pstmt.setString(1, nombre);
            int result = pstmt.executeUpdate();
            int materiaid = recuperarIdMateria();
            pstmt.close();
            for (int i = 0; i < correlativas.size(); i++) {
                pstmt = con.prepareStatement("Insert into correlativas (idMAT , idcorrellativa) values (? , ?)");
                pstmt.setInt(2, correlativas.get(i));
                pstmt.setInt(1, materiaid);
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
