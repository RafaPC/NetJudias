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

/**
 *
 * @author daw
 */
public class AlumnoDAO {

    public List<Alumno> getAllAlumnosJDBC() {
        List<Alumno> lista = new ArrayList<>();
        Alumno nuevo = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            con = DBConnectionPool.getInstance().getConnection();

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
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBConnectionPool.getInstance().cerrarConexion(con);
        }

        return lista;

    }

    public Alumno getAlumnoJDBC(int idWhere) {

        Alumno nuevo = null;
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

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

    public boolean updateAlumnoJDBC(Alumno a) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean updateado = true;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("UPDATE alumnos "
                    + "SET NOMBRE=?,FECHA_NACIMIENTO=?,MAYOR_EDAD=? "
                    + "WHERE id=?");

            stmt.setString(1, a.getNombre());

            stmt.setDate(2,
                    new java.sql.Date(a.getFecha_nacimiento().getTime()));

            stmt.setBoolean(3, a.getMayor_edad());

            stmt.setInt(4, a.getId());

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
        return updateado;

    }

    public boolean insertAlumnoJDBC(Alumno a) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean insertado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("INSERT INTO alumnos "
                    + "(NOMBRE,FECHA_NACIMIENTO,MAYOR_EDAD)  "
                    + "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, a.getNombre());

            stmt.setDate(2,
                    new java.sql.Date(a.getFecha_nacimiento().getTime()));

            stmt.setBoolean(3, a.getMayor_edad());

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

    public boolean deleteAlumno(long idWhere) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        int numFilas = -1;
        boolean borrado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("DELETE FROM alumnos where id=? ");

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

    public int delNotaAndUser(int idWhere) {
        DBConnection db = new DBConnection();
        Connection con = null;
        int respuesta = 0;
        try {

            con = db.getConnection();
            con.setAutoCommit(false);
            String sql = "DELETE FROM notas WHERE id_alumno = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, idWhere);

            stmt.executeUpdate();

            sql = "DELETE FROM alumnos WHERE id = ?";
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

    public boolean existNotaFromAlumno(int idWhere) throws SQLException {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existeNota = false;
        try {

            con = db.getConnection();

            stmt = con.prepareStatement("SELECT nota FROM notas where id_alumno=?");

            stmt.setInt(1, idWhere);

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
