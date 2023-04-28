/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprograma40examenfinal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
public class Materia {

    private String nombre;
    private List<Materia> correlativas;

    public Materia() {
        nombre = "";
        correlativas = new ArrayList<Materia>();
    }

    public Materia(String nombre, List<Materia> correlativas) {
        this.nombre = nombre;
        this.correlativas = correlativas;
    }

    public boolean puedeCursar(Alumno alumnoCursa) {
        if (correlativas.isEmpty()) {
            return true;
        }
        boolean aprobado = false;
        if (correlativas.isEmpty()) {
            return true;
        }
        for (int i = 0; i < correlativas.size(); i++) {
            List<Materia> matAp = alumnoCursa.getMateriasAprobadas();
            aprobado = false;
            for (int j = 0; j < matAp.size(); j++) {
                if (matAp.get(j).getNombre().equals(correlativas.get(i).getNombre())) {
                    aprobado = true;
                    break;
                }
            }
            if (aprobado != true) {
                return false;
            }
        }
        return aprobado;
    }

    public String getNombre() {
        return nombre;
    }

    public void escribirMateria() {
        ObjectMapper mapper = new ObjectMapper();
        Connection con = null;
        if (existeMateria(nombre) == false) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argprograma40examenfinal", "root", "root");
                PreparedStatement pstmt = con.prepareStatement("Insert into materias (materias, correlativas) values (?,?)");
                pstmt.setString(1, nombre);
                pstmt.setString(2, mapper.writeValueAsString(correlativas));
                int result = pstmt.executeUpdate();
                pstmt.close();
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al ingresar materia");
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al ingresar materia con el driver mysql");
                Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JsonProcessingException ex) {
                System.out.println("Error al ingresar materia con la serializacion JSON");
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
            System.out.println("Esa materia ya existe");
        }

    }

    public boolean existeMateria(String nombre) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argPrograma40examenfinal", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("Select id From materias where materias =?");
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return true;
            }
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al ingresar materia");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
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

    public boolean traerMateria(String nombre) throws MateriaNoExiste {
        ObjectMapper mapper = new ObjectMapper();
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/argPrograma40examenfinal", "root", "root");
            PreparedStatement pstmt = con.prepareStatement("Select * From materias where lower(materias) = lower(?)");
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                this.nombre = rs.getString("materias");
                CollectionType javaType = mapper.getTypeFactory().constructCollectionType(List.class, Materia.class);
                correlativas = mapper.readValue(rs.getString("correlativas"), javaType);
            }
            pstmt.close();
            con.close();
            if (this.nombre.isEmpty()) {
                throw new MateriaNoExiste();
            }
        } catch (SQLException e) {
            System.out.println("Error al traer materia");
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
