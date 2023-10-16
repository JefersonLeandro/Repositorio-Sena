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
import modelo.Farmacia;

/**
 *
 * @author ADMON
 */
@WebServlet(name = "controladorDatosFarmacia", urlPatterns = {"/controladorDatosFarmacia"})
public class controladorDatosFarmacia extends HttpServlet {

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
            out.println("<title>Servlet controladorDatosFarmacia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorDatosFarmacia at " + request.getContextPath() + "</h1>");
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
        
          // obtener datos 
        
        String id = request.getParameter("fIdFarmacia");
        String nit = request.getParameter("fNitFarmacia");
        String nombre = request.getParameter("fNombreFarmacia");
        String telefono = request.getParameter("fTelefonoFarmacia");
        String correo = request.getParameter("fCorreoFarmacia");
        String ubicacion = request.getParameter("fUbicacionFarmacia");
        String opcion = request.getParameter("fOpcion");
          
        
        //Castim y asignamientos de los datos 
        
        Farmacia unaFarmacia = null;
        try {
            
           int idFarmacia = (int) Integer.parseInt(id);
           
           unaFarmacia = new Farmacia();
           unaFarmacia.setIdFarmacia(idFarmacia);
           unaFarmacia.setNitFarmacia(nit);
           unaFarmacia.setNombreFarmacia(nombre);
           unaFarmacia.setTelefonoFarmacia(telefono);
           unaFarmacia.setCorreoFarmacia(correo);
           unaFarmacia.setUbicacionFarmacia(ubicacion);
           
           
            
        } catch (Exception error) {
            
            System.out.println("Error al hacer el castim "+error);
        }
        
        
        switch (opcion) {
            case "Ingresar":
                unaFarmacia.insertar();
                break;
                
            case "Modificar":
                
                unaFarmacia.modificar();
                break;
                
            case "Eliminar":
                unaFarmacia.eliminar();
                break;
        }

//        request.getRequestDispatcher("WEB-INF/datosFarmacia.jsp).forward(request, response); al hacerlo asi permite la duplicacion de los datos

          response.sendRedirect("controladorDireccionamiento?opcion=datosFarmacia"); // se hace el direccionamiento con otra pagina para eliminar las duplicacines ya que el direcconamiento de arriba hace otra vez 




        
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
