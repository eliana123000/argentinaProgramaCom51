/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40examenfinal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliana
 */
public class Alumno {

    private int legajo;
    private String nombre;
    private String apellido;
    private List<Materia> materiasAprobadas;

    public Alumno() {
        nombre = "";
        apellido = "";
        legajo = 0;
        materiasAprobadas = new ArrayList<Materia>();
    }

    public Alumno(int legajo, String nombre, String apellido, List<Materia> materiasAprobadas) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(List<Materia> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public void escribirAlumno() {
        ObjectMapper mapper = new ObjectMapper();
        Connection con = null;
        if (existeAlumno(legajo) == false) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argprograma40examenfinal", "root", "root");
                PreparedStatement pstmt = con.prepareStatement("Insert into alumnos"
                        + " (legajo, nombre, apellido, materiasAprobadas) values (?, ?, ? ,?)");
                pstmt.setInt(1, legajo);
                pstmt.setString(2, nombre);
                pstmt.setString(3, apellido);
                pstmt.setString(4, mapper.writeValueAsString(materiasAprobadas));
                int result = pstmt.executeUpdate();
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al ingresar Alumno");
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al ingresar alumno con el driver mysql");
                Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JsonProcessingException ex) {
                System.out.println("Error al ingresar alumno con la serializacion JSON");
                Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (con != null) {
                    try {
                        if (!con.isClosed()) {
                            con.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            System.out.println("Ese alumno ya existe");
        }

    }

    public boolean existeAlumno(int legajo) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argPrograma40examenfinal", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("Select legajo From alumnos where legajo =?");
            pstmt.setInt(1, legajo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return true;
            }
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al ingresar alumno");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    if (!con.isClosed()) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }

    public boolean traerAlumno(int legajo) throws AlumnoNoExiste {
        ObjectMapper mapper = new ObjectMapper();
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argPrograma40examenfinal", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("Select * From alumnos where legajo =?");
            pstmt.setInt(1, legajo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                this.legajo = rs.getInt("legajo");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, Materia.class);
                materiasAprobadas = mapper.readValue(rs.getString("materiasAprobadas"), javaType);
            }
            pstmt.close();
            con.close();
            if (this.legajo == 0) {
                throw new AlumnoNoExiste();
            }
        } catch (SQLException e) {
            System.out.println("Error al traer alumno");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    if (!con.isClosed()) {
                        con.close();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return false;
    }
}
