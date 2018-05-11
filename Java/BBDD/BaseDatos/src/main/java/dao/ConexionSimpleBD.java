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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignatura;

/**
 *
 * @author oscar
 */
public class ConexionSimpleBD {

    // Select JDBC
    public boolean insertAsignaturaJDBC(Asignatura a) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean insertado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("INSERT INTO asignaturas "
                    + "(NOMBRE,CURSO,CICLO)  "
                    + "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, a.getNombre());

            stmt.setString(2, a.getCurso());

            stmt.setString(3, a.getCiclo());

            filas = stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                a.setId(rs.getInt(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (filas == 1) {
                insertado = true;
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
        return insertado;

    }

    public boolean updateAsignaturaJDBC(Asignatura a) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean updateado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("UPDATE asignaturas "
                    + "SET NOMBRE=?,CURSO=?,CICLO=? "
                    + "WHERE id=?");

            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getCurso());
            stmt.setString(3, a.getCiclo());
            stmt.setInt(4, new Long(a.getId()).intValue());

            filas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (filas == 1) {
                updateado = true;
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
        return updateado;

    }

    public boolean deleteAsignatura(long idWhere) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        int numFilas = -1;
        boolean borrado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("DELETE FROM asignaturas where id=? ");

            stmt.setLong(1, idWhere);

            numFilas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (numFilas == 1) {
                borrado = true;
            }

        }
        return borrado;
    }

    public int delUser2(Alumno a) {
        DBConnection db = new DBConnection();
        Connection con = null;
        int filas = 0;
        try {

            con = db.getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM NOTAS WHERE ID_ALUMNO = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, a.getId());

            filas += stmt.executeUpdate();

            sql = "DELETE FROM ALUMNOS WHERE ID = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, a.getId());

            filas += stmt.executeUpdate();
            con.commit();

        } catch (Exception ex) {
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            db.cerrarConexion(con);
        }
        return filas;
    }
}
