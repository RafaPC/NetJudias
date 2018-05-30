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
import model.Nota;

/**
 *
 * @author daw
 */
public class NotaDAO {

    public List<Alumno> getAllAlumnosFromAsignatura(long idWhere) {
        List<Alumno> lista = new ArrayList<>();
        Alumno nuevo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }

        return lista;
    }

    public List<Asignatura> getAllAsignaturasJDBC() {
        List<Asignatura> lista = new ArrayList<>();
        Asignatura nuevo = null;

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            con = DBConnectionPool.getInstance().getConnection();

            stmt = con.createStatement();
            String sql;

            sql = "SELECT * FROM asignaturas WHERE id IN (SELECT DISTINCT(id_asignatura) FROM notas)";
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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return lista;

    }

    public boolean updateNotas(Nota a) {
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean updateado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

            stmt = con.prepareStatement("UPDATE notas SET NOTA = ?  WHERE id_alumno = ? AND id_asignatura = ?");

            stmt.setInt(1, a.getNota());
            stmt.setInt(2, a.getId_alumno());
            stmt.setInt(3, a.getId_asignatura());

            filas = stmt.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ConexionSimpleBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (filas == 1) {
                updateado = true;
            }
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return updateado;

    }

    public int getNotaFromAlumno(int idAlum, int idAsig) {
        int nota = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

            stmt = con.prepareStatement("SELECT nota FROM notas where id_alumno=? AND id_asignatura=?");

            stmt.setInt(1, idAlum);
            stmt.setInt(2, idAsig);

            rs = stmt.executeQuery();

            //STEP 5: Extract data from result set
            rs.next();
            //Retrieve by column name
            nota = rs.getInt("nota");

        } catch (Exception ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return nota;

    }

    public boolean insertNota(int idAlum, int idAsig) {
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean insertado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

            stmt = con.prepareStatement("INSERT INTO notas "
                    + "(id_alumno,id_asignatura)  "
                    + "VALUES (?,?)");

            stmt.setInt(1, idAlum);
            stmt.setInt(2, idAsig);

            filas = stmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(NotaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (filas == 1) {
                insertado = true;
            }        
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return insertado;

    }

}
