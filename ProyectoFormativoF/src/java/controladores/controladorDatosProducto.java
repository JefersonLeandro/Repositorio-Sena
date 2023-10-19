/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Producto;

/**
 *
 * @author ADMON
 */
@WebServlet(name = "controladorDatosProducto", urlPatterns = {"/controladorDatosProducto"})
public class controladorDatosProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controladorDatosProductos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorDatosProductos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        
        
//           // obtener datos 
        
            String idP = request.getParameter("fIdProducto");
            String nombreProducto= request.getParameter("fNombreProducto");
            String descripcionUnidad = request.getParameter("fDescripcionUnidad");
            String descripcionProductoG = request.getParameter("fDescripcionProductoGeneral");
            String stockP = request.getParameter("fStockProducto");
            String precioP = request.getParameter("fPrecioProducto");
            String idMarcaP = request.getParameter("fIdMarcaProducto");
            String opcion = request.getParameter("fOpcion");
            
//        
        //Castim y asignamientos de los datos 
//        
        Producto unProducto = null;
        try {
            
           int idProducto = (int) Integer.parseInt(idP);
           int stockProducto = (int) Integer.parseInt(stockP);
           double precioProducto = (double) Double.parseDouble(precioP);
           int idMarcaProducto = (int) Integer.parseInt(idMarcaP);
           
           unProducto = new Producto();
           unProducto.setIdProducto(idProducto);
           unProducto.setNombreProducto(nombreProducto);
           unProducto.setDescripcionUnidad(descripcionUnidad);
           unProducto.setDescripcionProductoGeneral(descripcionProductoG);
           unProducto.setStockProducto(stockProducto);
           unProducto.setPrecioProducto(precioProducto);
           unProducto.setIdMarcaProducto(idMarcaProducto);
            
        } catch (Exception error) {
            
            System.err.println("Error al hacer el castim "+error.getMessage());
        }
        
        
        switch (opcion) {
            case "Ingresar":
                unProducto.insertar();
                break;
                
            case "Modificar":
                
                unProducto.modificar();
                break;
                
            case "Eliminar":
                unProducto.eliminar();
                break;
        }

//       request.getRequestDispatcher("WEB-INF/datosFarmacia.jsp").forward(request, response); al hacerlo asi permite la duplicacion de los datos
         response.sendRedirect("controladorDireccionamiento?opcion=datosProducto"); // se hace el direccionamiento con otra pagina para eliminar las duplicacines ya que el direcconamiento de arriba hace otra vez 

          
          
          
        
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
