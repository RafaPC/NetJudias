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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Alumno;
import model.Asignatura;
import model.Nota;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author daw
 */
public class AsignaturaDAO {

    public List<Asignatura> getAllAsignaturasJDBC() {
        List<Asignatura> lista = new ArrayList<>();
        Asignatura nuevo = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return lista;

    }

    public List<Asignatura> getAllAlumnosJDBCTemplate() {

        JdbcTemplate jtm = new JdbcTemplate(
                DBConnectionPool.getInstance().getDataSource());
        List<Asignatura> asignaturas = jtm.query("Select * from ASIGNATURAS",
                new BeanPropertyRowMapper(Asignatura.class));

        return asignaturas;
    }

    public boolean insertAsignaturaJDBC(Asignatura a) {
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean insertado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return insertado;

    }

    public boolean addUserJDBCTemplate(Asignatura a) {
        boolean insertado = false;
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(
                DBConnectionPool.getInstance().getDataSource()).withTableName("ASIGNATURAS").usingGeneratedKeyColumns("ID");
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("NOMBRE", a.getNombre());
        parameters.put("CURSO", a.getCurso());
        parameters.put("CICLO", a.getCiclo());
        a.setId(jdbcInsert.executeAndReturnKey(parameters).intValue());
        insertado = true;
        return insertado;
    }

    public boolean updateAsignaturaJDBC(Asignatura a) {
        Connection con = null;
        PreparedStatement stmt = null;
        int filas = -1;
        boolean updateado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = DBConnectionPool.getInstance().getConnection();

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
            DBConnectionPool.getInstance().cerrarConexion(con);
        }
        return updateado;

    }

    public boolean updateJDBCTemplate(Asignatura a) {
        boolean updateado = false;
        JdbcTemplate jtm = new JdbcTemplate(
                DBConnectionPool.getInstance().getDataSource());
        String updateQuery = "UPDATE ASIGNATURAS set NOMBRE=?,CURSO=?,CICLO=? where ID=?";
        int filas = jtm.update(updateQuery, a.getNombre(), a.getCurso(), a.getCiclo(), a.getId());

        if (filas == 1) {
            updateado = true;
        }
        return updateado;

    }

    public boolean deleteAsignaturaJDBC(Asignatura a) {
        DBConnection db = new DBConnection();
        Connection con = null;
        PreparedStatement stmt = null;
        int numFilas = -1;
        boolean borrado = false;
        try {
            Class.forName(Configuration.getInstance().getDriverDB());

            con = db.getConnection();

            stmt = con.prepareStatement("DELETE FROM asignaturas WHERE ID=? ");

            stmt.setLong(1, a.getId());

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

    public boolean deleteJDBCTemplate(Asignatura a) {

        boolean deleteado = false;
        JdbcTemplate jtm = new JdbcTemplate(
                DBConnectionPool.getInstance().getDataSource());
        String updateQuery = "DELETE FROM asignaturas where ID=?";
        int filas = jtm.update(updateQuery, a.getId());

        if (filas == 1) {
            deleteado = true;
        }
        return deleteado;
    }

    public boolean delNotaAndAsig(long idWhere) {
        boolean deleteado = false;
        Connection con = null;
        int respuesta = 0;
        try {

            con = DBConnectionPool.getInstance().getConnection();
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
            deleteado = true;
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
        return deleteado;
    }

    public boolean delNotaAndAsigJDBCTemplate(Asignatura a) {

        boolean deleteado = false;
        TransactionDefinition txDef = new DefaultTransactionDefinition();
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(DBConnectionPool.getInstance().getDataSource());
        TransactionStatus txStatus = transactionManager.getTransaction(txDef);

        try {
            JdbcTemplate jtm = new JdbcTemplate(
                    DBConnectionPool.getInstance().getDataSource());
            String updateQuery = "DELETE FROM notas WHERE id_asignatura = ?";
            int filas = jtm.update(updateQuery, a.getId());

            updateQuery = "DELETE FROM asignaturas where ID=?";
            filas = jtm.update(updateQuery, a.getId());

            transactionManager.commit(txStatus);
            deleteado = true;
        } catch (Exception e) {

            transactionManager.rollback(txStatus);

            throw e;

        }

        return deleteado;
    }

    public boolean existNotaFromAsignatura(long idWhere) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existeNota = false;
        try {

            con = DBConnectionPool.getInstance().getConnection();

            stmt = con.prepareStatement("SELECT nota FROM notas where id_asignatura=?");

            stmt.setLong(1, idWhere);

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

    public boolean existNotaFromAsignaturaDBUtils(Asignatura a) {
        boolean existe = false;
        JdbcTemplate jtm = new JdbcTemplate(
                DBConnectionPool.getInstance().getDataSource());
        List<Nota> notas = jtm.query("Select * from NOTAS where ID_ASIGNATURA=?",
                new BeanPropertyRowMapper(Nota.class), a.getId());
        if (notas.size() > 0) {
            existe = true;
        }
        return existe;
    }
}
