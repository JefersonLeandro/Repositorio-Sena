/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author ADMON
 */
public class Persona {
    
    
    private  int idPersona;
    private  String nombrePersona;
    private  String apellidoPersona;
    private  String identificacionPersona;
    private  String correoPersona;
    private  String telefonoPersona;
    private  String contrasenaPersona;
    private  int idTipoPersona; //Relacion foranea 
    
    private int paginacion;

   
   
    
    // getter y setter
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getIdentificacionPersona() {
        return identificacionPersona;
    }

    public void setIdentificacionPersona(String identificacionPersona) {
        this.identificacionPersona = identificacionPersona;
    }

    public String getCorreoPersona() {
        return correoPersona;
    }

    public void setCorreoPersona(String correoPersona) {
        this.correoPersona = correoPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getContrasenaPersona() {
        return contrasenaPersona;
    }

    public void setContrasenaPersona(String contrasenaPersona) {
        this.contrasenaPersona = contrasenaPersona;
    }
    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int  idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }
    
    //CONSTRUCTOR Con datos

    public Persona(int idPersona, String nombrePersona, String apellidoPersona, String identificacionPersona, String correoPersona, String telefonoPersona, String contrasenaPersona, int idTipoPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.identificacionPersona = identificacionPersona;
        this.correoPersona = correoPersona;
        this.telefonoPersona = telefonoPersona;
        this.contrasenaPersona = contrasenaPersona;
        this.idTipoPersona = idTipoPersona;
    }
    
    
    // CONSTRUCTOR VACIO

    public Persona() {
        
        
    }
    
    
    
    //    CRUD 
//    
//    Listar
    public ArrayList listar() throws SQLException{
       
//    
        System.out.println("dentre al Listar - modeloPersona");
        
        ArrayList listaPersonas = new ArrayList();
        
        Persona laPersona;
        String listado = " SELECT * FROM "+this.getClass().getSimpleName()+" GROUP BY idPersona";
//      PreparedStatement sql = Conexion.conectar().prepareStatement(listado);
//        System.out.println("22222222222222222.555555555555555555555");
//      ResultSet rs = sql.executeQuery();//

        
        int pagina = 0;
        
        if (pagina>0) {
            int paginacionMax = pagina*this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            
            System.out.println("dentre al if del listar");
            try {
                System.out.println("dentre al try catch");
                listado = " SELECT * FROM "+this.getClass().getSimpleName()+" ORDEN BY idPersona LIMIT ?,?";
                
                PreparedStatement sql = Conexion.conectar().prepareStatement(listado);
                 
                sql.setInt(1, paginacionMin);
                sql.setInt(2, paginacionMax);
                
//                ResultSet resutadoL2 = sql.executeQuery(); creo que no es necesario
            } catch (Exception error) {
                
                System.err.println("Error al hacer la consulta select con limite en la funcion Listar"+error.getLocalizedMessage());   
            }
            
              System.out.println("llegue al final de la funcion de la listar");
        }
       

        try {
            
            
            System.out.println("esta es la consulta"+listado);
            
            
            PreparedStatement sql = Conexion.conectar().prepareStatement(listado);
            ResultSet rs = sql.executeQuery();// el execute query hace parte STETAMENT
            
            while(rs.next()){
                
              laPersona = new Persona(idPersona, nombrePersona, apellidoPersona, identificacionPersona, correoPersona, telefonoPersona, contrasenaPersona, idTipoPersona); // nose porque no dejar instaciar el objecto sin que se le pase normal
               
               laPersona.setIdPersona(rs.getInt("idPersona"));
               laPersona.setNombrePersona(rs.getString("nombrePersona"));
               laPersona.setApellidoPersona(rs.getString("apellidoPersona"));
               laPersona.setIdentificacionPersona(rs.getString("identificacionPersona"));
               laPersona.setCorreoPersona(rs.getString("correoPersona"));
               laPersona.setTelefonoPersona(rs.getString("telefonoPersona"));
               laPersona.setContrasenaPersona(rs.getString("contrasenaPersona"));
               laPersona.setIdTipoPersona(rs.getInt("idTipoPersona"));

               listaPersonas.add(laPersona);
            
            }
            
        } catch (SQLException error) {
            
            System.err.println("Error al listar las Personas: "+error.getLocalizedMessage());
            
        }
    
        Conexion.desconectar();
        return listaPersonas;

    
    }
    
    
    public void insertar (){
        
        try {
            
            System.out.println("####Datos en la funcion Insertar##");
            
            System.out.println(this.getNombrePersona());
            System.out.println(this.getApellidoPersona());
            System.out.println(this.getIdentificacionPersona());
            System.out.println(this.getCorreoPersona());
            System.out.println(this.getTelefonoPersona());
            System.out.println(this.getContrasenaPersona());
            
            
            // este insert es para la vista de crear cuenta , agregar la logica para las dos vistas
            String consulta = " INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,?,?,?,?,?,?,1)";
            PreparedStatement sql = Conexion.conectar().prepareStatement(consulta);
            
            //cambio
            
             sql.setString(1, this.getNombrePersona());
             sql.setString(2, this.getApellidoPersona());
             sql.setString(3, this.getIdentificacionPersona());
             sql.setString(4, this.getCorreoPersona());
             sql.setString(5, this.getTelefonoPersona());
             sql.setString(6, this.getContrasenaPersona());
//           sql.setInt(7, this.getIdTipoPersona());

             sql.executeUpdate();
             
             
             System.out.println(" ESTA ES LA CONSULTA ======= "+sql);

             System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");
            
        } catch (Exception error) {
            
            System.err.println(" Error al inserta la persona "+error.getMessage());
            System.err.println(" Error con la consulta"+error.getLocalizedMessage());
            
        }
    
    }
    
     //MODIFICAR-----
    
       public void modificar(){
       
           try {
               PreparedStatement sql = Conexion.conexion.prepareStatement(" UPDATE "+this.getClass().getSimpleName()+" SET nombrePersona = ?, apellidoPersona=?, identificacionPersona=?, correoPersona=?, telefonoPersona=?, contrasenaPersona=?, idTipoPersona=? WHERE idPersona=?");
              
                sql.setString(1, this.getNombrePersona());
                sql.setString(2, this.getApellidoPersona());
                sql.setString(3, this.getIdentificacionPersona());
                sql.setString(4, this.getCorreoPersona());
                sql.setString(5, this.getTelefonoPersona());
                sql.setString(6, this.getContrasenaPersona());
                sql.setInt(7, this.getIdTipoPersona());
                
                sql.setInt(8, this.getIdPersona());
                 System.out.println(sql);
                sql.executeUpdate();
                
                System.out.println(this.getClass().getSimpleName()+" Modificado correctamente ");
                
               
               
           } catch (SQLException error) {
               
               System.out.println(" Error al modificar :  "+this.getClass().getSimpleName());
               System.out.println(" Error :  "+error.getMessage());
               
           }
       }
    
        //Eliminar----
       
       public void eliminar(){
           
           try {
               PreparedStatement sql= Conexion.conexion.prepareStatement
                (" DELETE FROM "+this.getClass().getSimpleName()+" WHERE idPersona=?");
               
               sql.setInt(1,this.getIdPersona());
               sql.executeUpdate();
               
               System.out.println(this.getClass().getSimpleName()+" Eliminado correctamente");
               
           } catch (SQLException error) {
               
               System.err.println("Error al Eliminar "
               +this.getClass().getSimpleName()+" : "+error.getMessage()); 
           }
       }
       
       
       public Iterator <Persona> buscar (String busqueda){
           
           ArrayList <Persona> lasPersonas = new ArrayList<>();
       
           try {
               
               
               PreparedStatement sql= Conexion.conexion.prepareStatement
               (" SELECT * FROM "+this.getClass().getSimpleName()
              +" WHERE nombrePersona LIKE ? OR apellidoPersona LIKE ? OR identificacionPersona LIKE ?  OR correoPersona LIKE ?  OR telefonoPersona LIKE ?"
                      + " OR contrasenaPersona LIKE ? OR idTipoPersona LIKE ? ");
               
               sql.setString(1,"%"+busqueda+"%");
               sql.setString(2,"%"+busqueda+"%");
               sql.setString(3,"%"+busqueda+"%");
               sql.setString(4,"%"+busqueda+"%");
               sql.setString(5,"%"+busqueda+"%");
               sql.setString(6,"%"+busqueda+"%");
               sql.setString(7,"%"+busqueda+"%");
             
               
               ResultSet rs = sql.executeQuery();
               
               Persona unaPersona;
               
               while (rs.next()) {
                   
                   unaPersona = new Persona();
                   unaPersona.setIdPersona(rs.getInt ("idPersona"));
                   unaPersona.setNombrePersona(rs.getString("nombrePersona"));
                   unaPersona.setApellidoPersona(rs.getString("apellidoPersona"));
                   unaPersona.setIdentificacionPersona(rs.getString("identificacionPersona"));
                   unaPersona.setCorreoPersona(rs.getString("correoPersona"));
                   unaPersona.setTelefonoPersona(rs.getString("telefonoPersona"));
                   unaPersona.setContrasenaPersona(rs.getString("contrasenaPersona"));
                   unaPersona.setIdTipoPersona(rs.getInt("idTipoPersona"));
                   
                   lasPersonas.add(unaPersona);
               }
               
           } catch (SQLException error) {
               System.err.println("Error al buscar : "+this.getClass().getSimpleName()+" : "+error.getMessage());  
           }
           
           return lasPersonas.iterator();
       }
    
    
    
}
