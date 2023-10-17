/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Conexion;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ADMON
 */
@WebServlet(name = "controladorSesion", urlPatterns = {"/controladorSesion"})
public class controladorSesion extends HttpServlet {

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
        
        
// 
//#para la siguiente pagina cierta parte de la logica en el modelo y aca el control de erorres 
        
     // tener en cuenta que los names de los inputs deben ser iguales a lo nombre de variables que esta en ajax o si no sirve en los dos lados 
        
      String mensaje = "";
        
       if ( (request.getParameter("emailDocumento") != null) && (request.getParameter("contrasena") != null)) {// si no son nulos prosiga
           
   
            String elCorreoIdentificacion = request.getParameter("emailDocumento");
            String laContrasena = request.getParameter("contrasena");
            System.out.println("el correo "+elCorreoIdentificacion);
            System.out.println("la Contrasena "+laContrasena);
            
            
              try {
                // en todo correo la @ es obligatoria se trabajara con ella 

                String cara = "";
                String sello = "";
                boolean bandera = false;
                
                for (int i = 0; i < elCorreoIdentificacion.length(); i++) {
                    
                    char caracter = elCorreoIdentificacion.charAt(i);
                        System.out.print(caracter + " ");
                     //parseo 
                     String cadenaDeCaracteres = Character.toString(caracter);
                     System.out.println(cadenaDeCaracteres); // Imprime "Letra = a "

                    if ("@".equals(cadenaDeCaracteres)) {//se comprueba toda la cadena si tiene una arroba entonces obviamente es un correo si no tiene arroba es un documento
                        System.out.println(" es igual a la arroba"+cadenaDeCaracteres);
                        cara = "correoPersona";
                        bandera =true;
                        
                    }else{
                        System.out.println("no igual a la arroba "+cadenaDeCaracteres);
                        sello = "identificacionPersona";
                    }
                }
                
                String consulta="";  

                if (bandera) {
                      consulta = "SELECT * FROM persona WHERE "+cara+"= ?"; // se hace dinamico para el correo y el documento llegando ahorrar una consulta osea no es necesesario que no bote resultados ya que en esta si 
                       System.out.println("se hace con el "+cara);
                }else{

                     consulta = "SELECT * FROM persona WHERE "+sello+"= ?"; 
                      System.out.println("se hace con la  "+sello);

                }

                PreparedStatement sql = Conexion.conectar().prepareStatement(consulta);
                sql.setString(1, elCorreoIdentificacion);
                
                ResultSet resultado = sql.executeQuery();
                
                if (resultado.next()) {
                  
                    // se extre la contrasena para hacer la comprobacion por medio del hashed 
                    String hashedBd = resultado.getString("contrasenaPersona");
                    
                    
                    //Verificacion de encriptamiento en la contrasena
                    if (BCrypt.checkpw(laContrasena, hashedBd)) { // en este caso se le pasa la contrasena en texto claro para que el metodo haga la respectiva encriptacion y compare el hashed de la base de datos con el hash generado por parte del usuario en la otra vista

                        System.out.println("la comprobacion con el hashed fue exitosa ");

                        // la contrasena si coincide con el hashed que esta en la base de datos 
                        // puede inciar session 

                        HttpSession session = request.getSession(true); // Esto creará una nueva sesión o recuperará una existente
    //                    
                        int idPersona = resultado.getInt("idPersona");
                        String nombrePersona = resultado.getString("nombrePersona");
                        String apellidoPersona = resultado.getString("apellidoPersona");
                        int idTipoPersona = resultado.getInt("idTipoPersona");
                        mensaje = " Datos validos";
                        
//                    

                      // Guardar información del usuario en la sesión
                        session.setAttribute("idPersona", idPersona );
                        session.setAttribute("nombrePersona",  nombrePersona);
                        session.setAttribute("apellidoPersona", apellidoPersona);
                        session.setAttribute("idTipoPersona", idTipoPersona);
                        
                        request.getRequestDispatcher("index.jsp?msj=" + mensaje).forward(request, response);
                        
                        
                    }else{
                        
                        System.out.println("la contrasena no coincide con el hashed de la base de datos");
                        mensaje = "Datos invalidos";
                        request.getRequestDispatcher("WEB-INF/Registro.jsp?msj="+mensaje).forward(request, response);
                    }
                    
                }else {
                
                    System.out.println("no hay resultado en la base de datos por medio del correo y el documento ");
                    mensaje = "Datos invalidos";
                    request.getRequestDispatcher("WEB-INF/Registro.jsp?msj="+mensaje).forward(request, response);
                    
                }

            } catch (Exception error) {
                
                System.out.println("Error con la consulta : "+error.getMessage());
                
            }
              
              
       }else{
       
       
           System.out.println(" los datos estan nulos "); 
           mensaje = "los datos estan nulos ";
           request.getRequestDispatcher("WEB-INF/Registro.jsp?msj="+mensaje).forward(request, response);
       }
        
        
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
