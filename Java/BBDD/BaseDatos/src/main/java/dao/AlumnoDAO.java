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
import model.Nota;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }

        return lista;

    }

    public List<Alumno> getAllAlumnosDBUtils() {
        List<Alumno> lista = null;

        Connection con = null;
        try {
            con = DBConnectionPool.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Alumno>> handler
                    = new BeanListHandler<Alumno>(Alumno.class);
            lista = qr.query(con, "select * FROM ALUMNOS", handler);

        } catch (Exception ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return lista;
    }

    public boolean updateAlumnoJDBC(Alumno a) {
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean updateado = true;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return updateado;

    }

    public boolean updateUserDBUtils(Alumno alumno) {

        Connection con = null;
        boolean updateado = false;
        int filas = -1;
        try {
            con = DBConnectionPool.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();

            filas = qr.update(con,
                    "UPDATE ALUMNOS SET NOMBRE = ?,FECHA_NACIMIENTO = ?, MAYOR_EDAD = ? WHERE ID = ?",
                    alumno.getNombre(), alumno.getFecha_nacimiento(), alumno.getMayor_edad(), alumno.getId());

        } catch (Exception ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (filas == 1) {
                updateado = true;
            }
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return updateado;

    }

    public boolean insertAlumnoJDBC(Alumno a) {
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean insertado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return insertado;

    }

    public boolean insertAlumnoDBUtils(Alumno alumno) {
        int id = 0;
        Connection con = null;
        boolean insertado = false;
        try {
            con = DBConnectionPool.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            ResultSetHandler<Integer> handler = new BeanHandler<Integer>(Integer.class);
            id = qr.insert(con,
                    "INSERT INTO ALUMNOS (NOMBRE,FECHA_NACIMIENTO,MAYOR_EDAD) VALUES(?,?,?)", handler, alumno.getNombre(), alumno.getFecha_nacimiento(), alumno.getMayor_edad());
            alumno.setId(id);

        } catch (Exception ex) {

        } finally {
            if (id != 0) {
                insertado = true;
            }
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return insertado;

    }

    public boolean deleteAlumno(long idWhere) {
        Connection con = null;
        PreparedStatement stmt = null;
        int numFilas = -1;
        boolean borrado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

            stmt = con.prepareStatement("DELETE FROM alumnos where id=? ");

            stmt.setLong(1, idWhere);

            numFilas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (numFilas == 1) {
                borrado = true;
            }
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return borrado;

    }

    public boolean deleteAlumnoDBUtils(Alumno alumno) {

        Connection con = null;
        boolean borrado = false;
        int filas = -1;
        try {
            con = DBConnectionPool.getInstance().getConnection();
            QueryRunner qr = new QueryRunner();
            filas = qr.update(con, "DELETE FROM ALUMNOS WHERE ID = ?", alumno.getId());
        } catch (Exception ex) {

        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
            if (filas == 1) {
                borrado = true;
            }
        }

        return borrado;

    }

    public boolean deleteNotaAndAlumnoDBUtils(Alumno alumno) throws SQLException {

        Connection con = null;
        boolean borrado = false;
        int filas = -1;
        try {
            con = DBConnectionPool.getInstance().getConnection();
            con.setAutoCommit(false);
            QueryRunner qr = new QueryRunner();
            qr.update(con, "DELETE FROM NOTAS WHERE ID_ALUMNO = ?", alumno.getId());

            filas = qr.update(con, "DELETE FROM ALUMNOS WHERE ID = ?", alumno.getId());

        } catch (Exception ex) {
            con.rollback();
        } finally {
            if (filas == 1) {
                borrado = true;
                con.commit();
            }
            DBConnectionPool.getInstance().cerrarConexion(con);
        }

        return borrado;

    }

    public int delNotaAndUser(int idWhere) {
        Connection con = null;
        int respuesta = 0;
        try {

            con = DBConnectionPool.getInstance().getConnection();
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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return respuesta;
    }

    public boolean existNotaFromAlumno(int idWhere) throws SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existeNota = false;
        try {

            con = DBConnectionPool.getInstance().getConnection();

            stmt = con.prepareStatement("SELECT nota FROM notas where id_alumno=?");

            stmt.setInt(1, idWhere);

            rs = stmt.executeQuery();

            if (rs.next()) {
                existeNota = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return existeNota;
    }

    public boolean existNotaFromAlumnoDBUtils(Alumno a) {
        boolean existe = false;
        List<Nota> lista = null;

        Connection con = null;
        try {
            con = DBConnectionPool.getInstance().getConnection();

            QueryRunner qr = new QueryRunner();
            ResultSetHandler<List<Nota>> handler
                    = new BeanListHandler<Nota>(Nota.class);
            lista = qr.query(con, "select * FROM NOTAS where ID_ALUMNO=?", handler, a.getId());

            if (lista.size() > 0) {
                existe = true;
            }
        } catch (Exception ex) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return existe;
    }
}
