/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;

/**
 *
 * @author oscar
 */
public class ConexionSimpleBD {

    // Select JDBC
    public List<Alumno> getAllAlumnosJDBC() {
        List<Alumno> lista = new ArrayList<>();
        Alumno nuevo = null;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DriverManager.getConnection(
              Configuration.getInstance().getUrlDB(),
              Configuration.getInstance().getUserDB(),
              Configuration.getInstance().getPassDB());

            stmt = con.createStatement();
            String sql;

            sql = "SELECT * FROM alumnos";
            rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                Date fn = rs.getDate("fecha_nacimiento");
                Boolean mayor = rs.getBoolean("mayor_edad");
                nuevo = new Alumno();
                nuevo.setFecha_nacimiento(fn);
                nuevo.setId(id);
                nuevo.setMayor_edad(mayor);
                nuevo.setNombre(nombre);
                lista.add(nuevo);
            }

        } catch (Exception ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;

    }

    public Alumno getAlumnoJDBC(int idWhere) {

        Alumno nuevo = null;

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DriverManager.getConnection(
              Configuration.getInstance().getUrlDB(),
              Configuration.getInstance().getUserDB(),
              Configuration.getInstance().getPassDB());

            stmt = con.prepareStatement("SELECT * FROM alumnos where id=? AND nombre LIKE ?");

            stmt.setInt(1, idWhere);
            stmt.setString(2, "%a%");

            rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            rs.next();
            //Retrieve by column name
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            Date fn = rs.getDate("fecha_nacimiento");
            Boolean mayor = rs.getBoolean("mayor_edad");
            nuevo = new Alumno();
            nuevo.setFecha_nacimiento(fn);
            nuevo.setId(id);
            nuevo.setMayor_edad(mayor);
            nuevo.setNombre(nombre);

        } catch (Exception ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return nuevo;

    }
    
    public int updateAlumnoJDBC(Alumno a) {
        Connection con = null;
        PreparedStatement stmt = null;
       int filas = -1;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DriverManager.getConnection(
              Configuration.getInstance().getUrlDB(),
              Configuration.getInstance().getUserDB(),
              Configuration.getInstance().getPassDB());

            stmt = con.prepareStatement("UPDATE alumnos "
              + "SET NOMBRE=?,FECHA_NACIMIENTO=?,MAYOR_EDAD=? "
              + "WHERE id=?");

            stmt.setString(1, a.getNombre());
          
            stmt.setDate(2, 
              new java.sql.Date(a.getFecha_nacimiento().getTime()));
            
            stmt.setBoolean(3, a.getMayor_edad());
            
            stmt.setInt(4,a.getId());
            
            filas = stmt.executeUpdate();
            

            

        } catch (Exception ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return filas;

    }
    


}
