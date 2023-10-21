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
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author ADMON
 */
@WebServlet(name = "controladorDatosImagen", urlPatterns = {"/controladorDatosImagen"})
public class controladorDatosImagen extends HttpServlet {

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
            out.println("<title>Servlet controladorDatosImagen</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorDatosImagen at " + request.getContextPath() + "</h1>");
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
      
            
            String valorBusqueda = request.getParameter("fValorBusqueda");
            String accion = request.getParameter("fEnviar");

            List<Producto> resultadosBusqueda = new ArrayList<>(); // Crear una lista para almacenar los resultados

            switch (accion) {
                case "Ingresar":
                    // Insertar lógica aquí
                    break;

                case "Modificar":
                    // Modificar lógica aquí
                    break;

                case "Buscar":
                    Producto unProducto = new Producto();
                    resultadosBusqueda = (List<Producto>) unProducto.buscar(valorBusqueda); // Almacenar los resultados en la lista
               
                    
                    for (Producto producto : resultadosBusqueda) {
                        System.out.println("Datos en controlador:");
                        System.out.println("ID del Producto: " + producto.getIdProducto());
                        System.out.println("Nombre del Producto: " + producto.getNombreProducto());
                        System.out.println("Descripción de la Unidad: " + producto.getDescripcionUnidad());
                        // Agrega más campos si es necesario
                  }
                    
                    break;
            }

            request.setAttribute("resultadosBusqueda", resultadosBusqueda); // Configurar los resultados de la búsqueda en el alcance de solicitud

            // Redirigir a la vista
            request.getRequestDispatcher("controladorDireccionamiento?opcion=datosImagen").forward(request, response);
        
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
