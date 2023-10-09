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
import java.net.URLEncoder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import modelo.Conexion;
import modelo.Persona;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ADMON
 */
@WebServlet(name = "controladorCrearCuenta", urlPatterns = {"/controladorCrearCuenta"})
public class controladorCrearCuenta extends HttpServlet {
    
    private boolean bandera = false;
    private String contrasenaEncriptada;
    
    
    
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
//    Correo{
       
            try {
    
                    //Capturar los datos 
                    
                    String nombrePersona = request.getParameter("fNombrePersona");
                    String apellidoPersona = request.getParameter("fApellidoPersona");
                    String identificacionPersona = request.getParameter("fIdentificacionPersona");
                    String correoPersona = request.getParameter("fCorreoPersona");
                    String telefonoPersona = request.getParameter("fTelefonoPersona");
                    String contrasenaPersona = request.getParameter("fContrasenaPersona");
         
                    
                    
                    
                    System.out.println("datos en dopost");
                 
                    System.out.println(nombrePersona);
                    System.out.println(apellidoPersona);
                    System.out.println(correoPersona);
                    System.out.println(telefonoPersona);
                    System.out.println(contrasenaPersona);
                    
                    
                    // se envian los datos a otra vista teniendo en cuenta que se le pasa los objetos  request y reponse para trabajar al mismo nivel de aqui y alla 
                    insertarDatos(request,response, nombrePersona, apellidoPersona, identificacionPersona, correoPersona, telefonoPersona, contrasenaPersona);
//                    response.sendRedirect(request.getContextPath() + "/WEB-INF/Registro.jsp");
                    String mensaje = " Registro exitoso, ya puedes iniciar sesion ";
                    request.getRequestDispatcher("WEB-INF/Registro.jsp?mensaje="+mensaje).forward(request, response);
          
            
        } catch (Exception error) {
            
            System.err.println("error con la consulta "+error.getLocalizedMessage());
            
        }
        
        processRequest(request, response);

      
    }
    
    
    
    
    protected void insertarDatos(HttpServletRequest request, HttpServletResponse response, String nombreP , String apellidoP, String identificacionP, String correoP,  String telefonoP, String contrasenaP) throws ServletException, IOException{
               
        
        System.out.println("DATOS EN LA NUEVA FUNCION");
                System.out.println(nombreP);
                System.out.println(apellidoP);
                System.out.println(identificacionP);
                System.out.println(correoP);
                System.out.println(telefonoP);
                System.out.println(contrasenaP);
                
                
//                 ENCRIPTAR LA CONTRASENA 
            
                 // Genera un hash seguro de la contraseña utilizando BCrypt
                 
                System.out.println("1111");
                
                contrasenaEncriptada = BCrypt.hashpw(contrasenaP, BCrypt.gensalt());// se le pasa una variable la contrsena que la va a encriptar teniendo encuenta el metodo que le esta encriptando donde se le esta agregado sal o salting

                System.out.println("Contraseña en texto claro: " + contrasenaP);
                System.out.println("Contraseña encriptadaAAAAAAAA: " + contrasenaEncriptada);// esta es la forma mas recomendable para encriptar la contrasena con una libreria que utiliza salting 
                System.out.println("22222");
//            
//            
            
             // nose hace CASTIM YA QUE LA MAYORIA SON String y lo que son int se pasa directamente  ----
                
             
             Persona unaPersona = null;
                
                try {
                  
                    // asignar valores 

                    unaPersona = new Persona(0,nombreP, apellidoP, identificacionP, correoP,telefonoP, contrasenaP, 1); // se envia cero ya que no importa el id a la hora de insertar a lo que va en autoincremento como null
                    unaPersona.setNombrePersona(nombreP);
                    unaPersona.setApellidoPersona(apellidoP);
                    unaPersona.setIdentificacionPersona(identificacionP);
                    unaPersona.setCorreoPersona(correoP);
                    unaPersona.setTelefonoPersona(telefonoP);
                    unaPersona.setContrasenaPersona(contrasenaEncriptada);
                    unaPersona.setIdTipoPersona(1);

                    unaPersona.insertar();//se hace asi ya que solamente es una opcion que seria insertar 

                } catch (Exception error) {

                    System.err.println("Error al asignar los datos al objeto persona "+error.getMessage());
                }     
                
                
                processRequest(request, response);
    }
    
    
    
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
