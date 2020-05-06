/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Venta {
     private int local_id;
  private String producto_codigo;
  private Date fecha;
  private int unidades_vendidas;
    private static final DateFormat FMT = new SimpleDateFormat("yyyy/MM/dd hh:ss");

    public Venta(int local_id, String producto_codigo, Date fecha, int unidades_vendidas) {
        this.local_id = local_id;
        this.producto_codigo = producto_codigo;
        this.fecha = fecha;
        this.unidades_vendidas = unidades_vendidas;
    }

    public Venta() {
        this(0,null,null,0);
    }

    public int getLocal_id() {
        return local_id;
    }

    public void setLocal_id(int local_id) {
        this.local_id = local_id;
    }

    public String getProducto_codigo() {
        return producto_codigo;
    }

    public void setProducto_codigo(String producto_codigo) {
        this.producto_codigo = producto_codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getUnidades_vendidas() {
        return unidades_vendidas;
    }

    public void setUnidades_vendidas(int unidades_vendidas) {
        this.unidades_vendidas = unidades_vendidas;
    }

    @Override
    public String toString() {
        return "Venta{" + "local_id=" + local_id + ", producto_codigo=" + producto_codigo + ", fecha=" +  FMT.format(fecha) + ", unidades_vendidas=" + unidades_vendidas + '}';
    }
  
    
  
  
}
