/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.ConexionBD;
import static modelo.ConexionBD.conexion;
import static vista.CrearCuenta.comprobar;
import static vista.Index.unRegistro;
import static vista.Registro.crearCuenta;
//import static vista.Index.unRegistro;
//import static vista.CrearCuenta.panelG;

//import vista.Registro;
//import vista.CrearCuenta;
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
    
    //to String 
    @Override
    public String toString() {
        return "Persona{" + "nombrePersona=" + nombrePersona + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return this.idPersona == other.idPersona;
    }
   
    
//    CRUD {
    
    //Listar    
    
         public Iterator<Persona>Listar(){
         ArrayList<Persona> lasPersonas = new ArrayList<>();
    
        try {
            
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Persona unaPersona;
            
            while (rs.next()) {

                unaPersona = new Persona();
                unaPersona.setIdPersona( rs.getInt("idPersona"));
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
            
            System.err.println("Error al listar las personas : "+error.getMessage());
        }
        if(lasPersonas.isEmpty()){
            
            Persona miPersona = new Persona();
            miPersona.setNombrePersona("No hay Personas");
            lasPersonas.add(miPersona);
        }
        return lasPersonas.iterator();
    
    }
    
    //Insertar
         
        public void insertar (){
            
            //llevar el usuario a la vista de ingresar los datos G.
            // esta parte hay que dajarla ejecutar solamente si proviene del archivo de crear cuenta , ya que va a hacer a ser a utilizada para otro archivo 
            // y se confunde con la logica para solucinar eso , poner una variable en true en archivo y aca poner si la variable es true poner eso y ya la variable es public  static 
            // y como el otro codigo que va a reutilizar el codigo va ignorar esta parte porque no se ha activado la variable
            System.out.println(comprobar);
            
//               

                try {
                    
                     System.out.println("Dentre al try del insertar ");
                     
                     PreparedStatement sql = null;
                     
                    if (comprobar) { // si esto es igual true
                        unRegistro.setVisible(true);
                        crearCuenta.setVisible(false);
                        System.out.println("aaaaaaaaaa - se activaron las vista Registro en true y crearCuenta en false");
                        
                        sql = ConexionBD.conexion.prepareStatement("INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,?,?,?,?,?,?,1)");//cambio
                        comprobar=false;// se deja en false para que no confunda al insertar otra cuenta de la otra vista o sino activaria la vista inecesariamente 
                    }else{
                        
                        sql = ConexionBD.conexion.prepareStatement("INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,?,?,?,?,?,?,?)");
                        sql.setInt(7, this.getIdTipoPersona());
                    }
 
                     
//                     System.out.println(sql+"--soy la consulta");

                     sql.setString(1, this.getNombrePersona());
                     sql.setString(2, this.getApellidoPersona());
                     sql.setString(3, this.getIdentificacionPersona());
                     sql.setString(4, this.getCorreoPersona());
                     sql.setString(5, this.getTelefonoPersona());
                     sql.setString(6, this.getContrasenaPersona());
//                     sql.setInt(7, this.getIdTipoPersona());

                     sql.executeUpdate();

                     System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");


                } catch (SQLException error) {

                    System.err.println("Error al insertar - "+this.getClass().getSimpleName()+":"+error.getMessage());
                }
                
                 
                Persona persona =new Persona();
                
                persona.getIdPersona();
                int id = persona.getIdPersona();
                
                System.out.println("mi id es : "+ id);

        }
        
       //MODIFICAR-----
    
       public void modificar(){
       
           try {
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(" UPDATE "+this.getClass().getSimpleName()+" SET nombrePersona = ?, apellidoPersona=?, identificacionPersona=?, correoPersona=?, telefonoPersona=?, contrasenaPersona=?, idTipoPersona=? WHERE idPersona=?");
              
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
               PreparedStatement sql= ConexionBD.conexion.prepareStatement
                (" DELETE FROM "+this.getClass().getSimpleName()+" WHERE idPersona=?");
               
               sql.setInt(1,this.getIdPersona());
               sql.executeUpdate();
               
               System.out.println(this.getClass().getSimpleName()+" Eliminado correctamente");
               
           } catch (SQLException error) {
               
               System.err.println("Error al Eliminar "
               +this.getClass().getSimpleName()+" : "+error.getMessage()); 
           }
       }
//}
       
       //buscar
       
       public Iterator <Persona> buscar (String busqueda){
           
           ArrayList <Persona> lasPersonas = new ArrayList<>();
       
           try {
               
               
               PreparedStatement sql= ConexionBD.conexion.prepareStatement
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
       
       
       
       //Buscar por id 
       
       public Persona buscarPorId ( int elId){
       
           Persona unaPersona = new Persona();
           unaPersona.setNombrePersona(" la persona no existe");
           
           try {
               
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(
                       " SELECT * FROM "+this.getClass().getSimpleName()+" WHERE idPersona = ?");
               
               sql.setInt(1, elId);
               
               ResultSet rs = sql.executeQuery();
               
               while(rs.next()){
                   
                   unaPersona.setIdPersona(rs.getInt("idPersona"));
                   unaPersona.setNombrePersona(rs.getString("nombrePersona"));
                   unaPersona.setApellidoPersona(rs.getString("apellidoPersona"));
                   unaPersona.setIdentificacionPersona(rs.getString ("identificacionPersona"));
                   unaPersona.setTelefonoPersona(rs.getString("telefonoPersona"));
                   unaPersona.setCorreoPersona(rs.getString("correoPersona"));
                   unaPersona.setContrasenaPersona(rs.getString("contrasenaPersona"));
                   unaPersona.setIdTipoPersona(rs.getInt("idTipoPersona"));
               }
               
           } catch (SQLException error) {
               
               System.err.println(" Error al buscar por id : "+error.getMessage());
           }
           return unaPersona;
        }
}
