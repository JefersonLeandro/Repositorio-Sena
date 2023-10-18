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
import modelo.TipoPersona;

/**
 *
 * @author ADMON
 */
@WebServlet(name = "controladorTipoPersona", urlPatterns = {"/controladorTipoPersona"})
public class controladorTipoPersona extends HttpServlet {

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
            out.println("<title>Servlet controladorTipoPersona</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controladorTipoPersona at " + request.getContextPath() + "</h1>");
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
        
        String idTipoP = request.getParameter("fIdTipoPersona");
        String nombreTipoP = request.getParameter("fNombreTipoPersona");
        String accion = request.getParameter("fOpcion");
        
        //Castim 

        TipoPersona unTipoPersona = null;
        
        try {
            
            int idTipoPersona = (int) Integer.parseInt(idTipoP); 
            
            unTipoPersona = new TipoPersona();
            unTipoPersona.setIdTipoPersona(idTipoPersona);
            unTipoPersona.setNombreTipoPersona(nombreTipoP);
            
        } catch (Exception error) {
            
            
            System.out.println(" Eror al hacer castim "+error.getLocalizedMessage());
            
        }
        
        
         String mensaje = "" ; 
              
            switch (accion) { //toLowerCase() transforma de todo el texto que venga a minuscula osea ABc   a  abc
                
            case "Ingresar":
                unTipoPersona.insertar();
                mensaje="Insertado ";
                
                System.out.println("dentrre al caso insertar");
                break;
            case "Modificar":
                unTipoPersona.modificar();
                mensaje="Modificado";
                break;
            case "Eliminar":
                unTipoPersona.eliminar();
                mensaje=" Eliminado";
                break;
        }
                
        

            request.getRequestDispatcher("controladorDireccionamiento?opcion=datosTipoPersona").forward(request, response);
            
            
            
            
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
