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
import modelo.Persona;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ADMON
 */
@WebServlet(name = "controladorDatosPersona", urlPatterns = {"/controladorDatosPersona"})
public class controladorDatosPersona extends HttpServlet {

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

                String idP =  request.getParameter("fIdPersona");
                String nombrePersona = request.getParameter("fNombrePersona");
                String apellidoPersona = request.getParameter("fApellidoPersona");
                String identificacionPersona = request.getParameter("fIdentificacionPersona");
                String telefonoPersona = request.getParameter("fTelefonoPersona");
                String idTP = request.getParameter("fIdTipoPersona");
                String accion = request.getParameter("fOpcion");
                

                String correoPersona = null;
                String contrasenaEncriptada = null;
                    
                    
                    if (request.getParameter("fOpcion").equals("Ingresar")) {
                        
                        System.out.println("dentre al primer if");
                        
                         correoPersona = request.getParameter("fCorreoPersona");
                         String contrasenaPersona = request.getParameter("fContrasenaPersona");
                         contrasenaEncriptada = BCrypt.hashpw(contrasenaPersona, BCrypt.gensalt()); // se le pasa una variable la contrsena que la va a encriptar teniendo encuenta el metodo que le esta encriptando donde se le esta agregado sal o salting
                         
                         System.out.println("Contraseña en texto claro: " + contrasenaPersona);
                         System.out.println("Contraseña encriptadaAAAAAAAA: " + contrasenaEncriptada);// esta es la forma mas recomendable para encriptar la contrasena con una libreria que utiliza salting 
                    }           
            
                    System.out.println(idP);
                    System.out.println(nombrePersona);
                    System.out.println(apellidoPersona);
                    System.out.println(correoPersona);
                    System.out.println(telefonoPersona);
                    System.out.println(idTP);
                    
                    
                    
                    
                    
            //castim
            Persona unaPersona = null;
             
              try {
                  
                   int idPersona = (int) Integer.parseInt(idP);
                   int idTipoPersona = (int) Integer.parseInt(idTP);
                        
                    // asignar valores 
                    unaPersona = new Persona(); // se envia cero ya que no importa el id a la hora de insertar a lo que va en autoincremento como null

                    unaPersona.setIdPersona(idPersona);
                    unaPersona.setNombrePersona(nombrePersona);
                    unaPersona.setApellidoPersona(apellidoPersona);
                    unaPersona.setIdentificacionPersona(identificacionPersona);
                    unaPersona.setTelefonoPersona(telefonoPersona);
                    unaPersona.setIdTipoPersona(idTipoPersona);
                    
                    if (request.getParameter("fOpcion").equals("Ingresar")) {
                        
                        System.out.println("dentre al segundo if");

                        unaPersona.setCorreoPersona(correoPersona);
                        unaPersona.setContrasenaPersona(contrasenaEncriptada);
                    }
                      
                      
              } catch (Exception error) {
              
                  System.out.println(" Error al hacer castim "+error.getLocalizedMessage());
              
              
              }
              
              String mensaje = "" ; 
              
            switch (accion) { //toLowerCase() transforma de todo el texto que venga a minuscula osea ABc   a  abc
                
            case "Ingresar":
                unaPersona.insertar();
                mensaje="Insertado ";
                
                System.out.println("dentrre al caso insertar");
                break;
            case "Modificar":
                unaPersona.modificar();
                mensaje="Modificado";
                break;
            case "Eliminar":
                unaPersona.eliminar();
                mensaje=" Eliminado";
                break;
        }
                
        

            request.getRequestDispatcher("controladorDireccionamiento?opcion=datosPersona").forward(request, response);
        
        
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
