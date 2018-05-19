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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Asignatura;

/**
 *
 * @author daw
 */
public class AsignaturaDAO {

    public List<Asignatura> getAllAsignaturasJDBC() {
        DBConnection db = new DBConnection();
        List<Asignatura> lista = new ArrayList<>();
        Asignatura nuevo = null;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.createStatement();
            String sql;

            sql = "SELECT * FROM asignaturas";
            rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String curso = rs.getString("curso");
                String ciclo = rs.getString("ciclo");

                nuevo = new Asignatura();
                nuevo.setId(id);
                nuevo.setNombre(nombre);
                nuevo.setCurso(curso);
                nuevo.setCiclo(ciclo);
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

    public boolean deleteAsignaturaJDBC(long idWhere) {
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

    public int delNotaAndAsig(long idWhere) {
        DBConnection db = new DBConnection();
        Connection con = null;
        int respuesta = 0;
        try {

            con = db.getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM notas WHERE id_asignatura = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, idWhere);

            stmt.executeUpdate();

            sql = "DELETE FROM asignaturas WHERE id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setLong(1, idWhere);

            stmt.executeUpdate();

            con.commit();
            respuesta = 1;
        } catch (Exception ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex1) {
                Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            db.cerrarConexion(con);
        }
        return respuesta;
    }
    
    public boolean existNotaFromAsignatura(long idWhere){
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existeNota = false;
        try {

            con = db.getConnection();

            stmt = con.prepareStatement("SELECT nota FROM notas where id_asignatura=?");

            stmt.setLong(1, idWhere);

            rs = stmt.executeQuery();

            if (rs.next()) {
                existeNota = true;
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
        return existeNota;
    }
}
