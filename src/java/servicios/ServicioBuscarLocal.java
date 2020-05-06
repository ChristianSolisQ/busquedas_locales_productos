/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import GestorVentas.GestorVentas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import servicios.entidades.Venta;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "ServicioBuscarLocal", urlPatterns = {"/ServicioBuscarLocal"})
public class ServicioBuscarLocal extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(listarVentasLocaltoJSON());
        }
    }

    public String listarVentasLocaltoJSON() {
        JSONObject r = new JSONObject();
        JSONArray a = new JSONArray();
        try {
            List<Venta> l = GestorVentas.obtenerInstancia().listarTodosLocal();
            for (Venta v : l) {
                JSONObject j = new JSONObject();
                j.put("local_id", v.getLocal_id());
                j.put("producto_codigo", v.getProducto_codigo());
                j.put("fecha", v.getFecha());
                j.put("unidades_vendidas", v.getUnidades_vendidas());
                a.put(j);
            }
        } catch (Exception e) {
            System.err.println("ERROR" + e.getMessage());
        }
        r.put("Ventas", a);
        return r.toString();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    
}
