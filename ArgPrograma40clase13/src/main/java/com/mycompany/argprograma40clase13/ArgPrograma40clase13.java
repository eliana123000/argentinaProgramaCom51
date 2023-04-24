/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.argprograma40clase13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author eliana
 */
public class ArgPrograma40clase13 {

    public static void main(String args[]) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejguia12_qatar2022", "root", "root");
        Statement stmt = con.createStatement();

        int result = stmt.executeUpdate("Insert into empleados (nombre, apellido, dni, nacionalidad, departamentoid) values (\"Lucia\" ,\"Soria\", 30444987,\"argentina\", 2 )");
        System.out.println(result + " records affected");
        result = stmt.executeUpdate("UPDATE ejguia12_qatar2022.empleados SET nacionalidad = \"argentino\" WHERE id = 5");
        System.out.println(result + " records affected");
        result = stmt.executeUpdate("delete from ejguia12_qatar2022.departamentos where id=5");
        System.out.println(result + " records affected");

        ResultSet rs = stmt.executeQuery("SELECT * FROM ejguia12_qatar2022.empleados where departamentoid=4");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
        con.close();
    }
}
