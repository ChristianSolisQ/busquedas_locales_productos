/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestorVentas;

import cr.ac.database.managers.DBManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import servicios.entidades.Venta;

/**
 *
 * @author Usuario
 */
public class GestorVentas {
    
    private GestorVentas()
            throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        try {
            db = DBManager.getDBManager(DBManager.DB_MGR.MYSQL_SERVER);
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException ex) {
            System.err.printf("Excepción: '%s'%n", ex);
            throw ex;
        }
    }

    public static GestorVentas obtenerInstancia()
            throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (instancia == null) {
            instancia = new GestorVentas();
        }
        return instancia;
    }

    public List<Venta> listarTodosLocal() {
        List<Venta> r = new ArrayList<>();
        try {
            Connection cnx = db.getConnection(BASE_DATOS, USUARIO_BD, CLAVE_BD);
            try (PreparedStatement stm = cnx.prepareStatement(CMD_BUSCAR_Local)) {
                stm.clearParameters();
                
                stm.setInt(1, numlocal);
           
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    int local_id = rs.getInt("local_id");
                    String producto_codigo = rs.getString("producto_codigo");
                    Date fecha = rs.getDate("fecha");
                    int unidades_vendidas = rs.getInt("unidades_vendidas");
                 
                    Venta e = new Venta(local_id, producto_codigo, fecha, unidades_vendidas);
                        r.add(e);                 
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        } finally {
            if (db != null) {
                db.closeConnection();
            }
        }
        return r;
    }
     public List<Venta> listarTodosProductos() {
        List<Venta> r = new ArrayList<>();
        try {
            Connection cnx = db.getConnection(BASE_DATOS, USUARIO_BD, CLAVE_BD);
            try (PreparedStatement stm = cnx.prepareStatement(CMD_BUSCAR_Producto)) {
                stm.clearParameters();
                
                stm.setString(1, codprod);
           
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    int local_id = rs.getInt("local_id");
                    String producto_codigo = rs.getString("producto_codigo");
                    Date fecha = rs.getDate("fecha");
                    int unidades_vendidas = rs.getInt("unidades_vendidas");
                 
                    Venta e = new Venta(local_id, producto_codigo, fecha, unidades_vendidas);
                        r.add(e);                 
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        } finally {
            if (db != null) {
                db.closeConnection();
            }
        }
        return r;
    }
     public static void main(String[] args) {
        try {
            List<Venta> l = GestorVentas.obtenerInstancia().listarTodosProductos();
            for (Venta p : l) {
                System.out.println(p.toString());
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }
    
    private static GestorVentas instancia = null;
    private DBManager db = null;
    private static final String BASE_DATOS = "eif209_prc2";
    private static final String USUARIO_BD = "root";
    private static final String CLAVE_BD = "root";
    public static int numlocal = 0;
    public static String codprod = "";

    private static final String CMD_BUSCAR_Local
            = "select local_id, producto_codigo, fecha, unidades_vendidas "
            + "from `eif209_prc2`.`venta` where local_id = ?;";
    private static final String CMD_BUSCAR_Producto
            = "select local_id, producto_codigo, fecha, unidades_vendidas "
            + "from `eif209_prc2`.`venta` where producto_codigo = ?;";
}
