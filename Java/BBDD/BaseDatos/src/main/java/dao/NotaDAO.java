/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Configuration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Nota;

/**
 *
 * @author daw
 */
public class NotaDAO {
    public Alumno getNotaAlumnoJDBC(int idWhere) {

        Alumno nuevo = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("SELECT * FROM notas where id_alumno=? AND id_asignatura=?");

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
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return nuevo;

    }
    
    
    public List<Alumno> getAllAlumnosFromAsignatura(long idWhere){
        List<Alumno> lista = new ArrayList<>();
        Alumno nuevo = null;
        
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("SELECT * FROM alumnos WHERE id IN (SELECT id_alumno FROM notas where id_asignatura = ?)");

            stmt.setLong(1, idWhere);
            rs = stmt.executeQuery();

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
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return lista;
    }
    
    public void updateNotas(Nota a) {

        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean updateado = true;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("UPDATE notas SET NOTA = ?  WHERE id_alumno = ? AND id_asignatura = ?");

            stmt.setInt(1, a.getNota());
            stmt.setInt(2, a.getId_alumno());
            stmt.setInt(3, a.getId_asignatura());

            filas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (filas == -1) {
                updateado = false;
            }
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //return updateado;

    }
    
}
