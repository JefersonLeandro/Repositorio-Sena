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
public class Farmacia {
    
    
    private int idFarmacia;
    private String nitFarmacia;
    private String nombreFarmacia;
    private String telefonoFarmacia;
    private String correoFarmacia;
    private String ubicacionFarmacia;
    
 

//    Getter y setter
    
    
    
    public int getIdFarmacia() {
        return idFarmacia;    
    }
    public void setIdFarmacia(int idFarmacia) {
        this.idFarmacia = idFarmacia;
    }

    public String getNitFarmacia() {
        return nitFarmacia;
    }

    public void setNitFarmacia(String nitFarmacia) {
        this.nitFarmacia = nitFarmacia;
    }

    public String getNombreFarmacia() {
        return nombreFarmacia;
    }

    public void setNombreFarmacia(String nombreFarmacia) {
        this.nombreFarmacia = nombreFarmacia;
    }

    public String getTelefonoFarmacia() {
        return telefonoFarmacia;
    }

    public void setTelefonoFarmacia(String telefonoFarmacia) {
        this.telefonoFarmacia = telefonoFarmacia;
    }

    public String getCorreoFarmacia() {
        return correoFarmacia;
    }

    public void setCorreoFarmacia(String correoFarmacia) {
        this.correoFarmacia = correoFarmacia;
    }

    public String getUbicacionFarmacia() {
        return ubicacionFarmacia;
    }

    public void setUbicacionFarmacia(String ubicacionFarmacia) {
        this.ubicacionFarmacia = ubicacionFarmacia;
    }
    
    
//    toString 

    @Override
    public String toString() {
        return "Farmacia{" + "nombreFarmacia=" + nombreFarmacia + '}';
    }
    
    // iquals para busqueda desde un jComboBox

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Farmacia other = (Farmacia) obj;
        return this.idFarmacia == other.idFarmacia;
    }
    
    
//    CRUD{
    
//    Listar
    
       public Iterator<Farmacia>Listar(){
         ArrayList<Farmacia> lasFarmacias = new ArrayList<>();
    
        try {
            
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Farmacia unaFarmacia;
            
            while (rs.next()) {

                unaFarmacia = new Farmacia();
                unaFarmacia.setIdFarmacia( rs.getInt("idFarmacia"));
                unaFarmacia.setNitFarmacia(rs.getString("nitFarmacia"));
                unaFarmacia.setNombreFarmacia(rs.getString("nombreFarmacia"));
                unaFarmacia.setTelefonoFarmacia(rs.getString("telefonoFarmacia"));
                unaFarmacia.setCorreoFarmacia(rs.getString("correoFarmacia"));
                unaFarmacia.setUbicacionFarmacia(rs.getString("ubicacionFarmacia"));
                
                
                lasFarmacias.add(unaFarmacia);
            }
            
        } catch (SQLException error) {
            
            System.err.println("Error al listar las farmacias : "+error.getMessage());
        }
        if(lasFarmacias.isEmpty()){
            
            Farmacia miFarmacia = new Farmacia();
            miFarmacia.setNombreFarmacia("No hay Personas");
            lasFarmacias.add(miFarmacia);
        }
        return lasFarmacias.iterator();
    
    }
    
    
    // insertar
       
       
          public void insertar (){
//                

                try {
                     System.out.println("Dentre al try del insertar ");
                      
                     PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,?,?,?,?,?)");
                 

                     sql.setString(1, this.getNitFarmacia());
                     sql.setString(2, this.getNombreFarmacia());
                     sql.setString(3, this.getTelefonoFarmacia());
                     sql.setString(4, this.getCorreoFarmacia());
                     sql.setString(5, this.getUbicacionFarmacia());


                     sql.executeUpdate();

                     System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");


                } catch (SQLException error) {

                    System.err.println("Error al insertar - "+this.getClass().getSimpleName()+":"+error.getMessage());
                }

        }
          
          
        // Modificar
        public void modificar(){
       
           try {
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(" UPDATE "+this.getClass().getSimpleName()+" SET nitFarmacia =?, nombreFarmacia=?, telefonoFarmacia=?, correoFarmacia=?, ubicacionFarmacia=?  WHERE idFarmacia=?");
               
                sql.setString(1, this.getNitFarmacia());
                sql.setString(2, this.getNombreFarmacia());
                sql.setString(3, this.getTelefonoFarmacia());
                sql.setString(4, this.getCorreoFarmacia());
                sql.setString(5, this.getUbicacionFarmacia());
                
                sql.setInt(6, this.getIdFarmacia());
                
                sql.executeUpdate();
                
                System.out.println(this.getClass().getSimpleName()+" Modificado correctamente ");
                
               
               
           } catch (SQLException error) {
               
               System.out.println(" Error al modificar :  "+this.getClass().getSimpleName());
               System.out.println(" Error :  "+error.getMessage()); 
           }
       }
    

    // Eliminar
        
        
         public void eliminar(){
           
           try {
               PreparedStatement sql= ConexionBD.conexion.prepareStatement
                (" DELETE FROM "+this.getClass().getSimpleName()+" WHERE idFarmacia=? ");
               
               sql.setInt(1,this.getIdFarmacia());
               
               System.out.println(this.getIdFarmacia()+" soy el id de la fila ");
               
               sql.executeUpdate();
               
               System.out.println(this.getClass().getSimpleName()+" Eliminado correctamente");
               
           } catch (SQLException error) {
               
               System.err.println("Error al Eliminar "
               +this.getClass().getSimpleName()+" : "+error.getMessage()); 
           }
       }
         
         
         //Buscar 
         
          public Iterator <Farmacia> buscar (String busqueda){
           
           ArrayList <Farmacia> lasFarmacias = new ArrayList<>();
       
           try {
               
               
               PreparedStatement sql= ConexionBD.conexion.prepareStatement
               (" SELECT * FROM "+this.getClass().getSimpleName()
              +" WHERE nitFarmacia LIKE ? OR nombreFarmacia LIKE ? OR telefonoFarmacia LIKE ? OR correoFarmacia LIKE ?  OR ubicacionFarmacia LIKE ? ");
               
               sql.setString(1,"%"+busqueda+"%");
               sql.setString(2,"%"+busqueda+"%");
               sql.setString(3,"%"+busqueda+"%");
               sql.setString(4,"%"+busqueda+"%");
               sql.setString(5,"%"+busqueda+"%");
               
               ResultSet rs = sql.executeQuery();
               
               Farmacia unaFarmacia;
               
               while (rs.next()) {
                   
                   unaFarmacia = new Farmacia();
                   unaFarmacia.setIdFarmacia(rs.getInt ("idFarmacia"));
                   unaFarmacia.setNitFarmacia(rs.getString("nitFarmacia"));
                   unaFarmacia.setNombreFarmacia(rs.getString("nombreFarmacia"));
                   unaFarmacia.setTelefonoFarmacia(rs.getString("telefonoFarmacia"));
                   unaFarmacia.setCorreoFarmacia(rs.getString("correoFarmacia"));
                   unaFarmacia.setUbicacionFarmacia(rs.getString("ubicacionFarmacia"));
               
                   
                   lasFarmacias.add(unaFarmacia);
               }
               
           } catch (SQLException error) {
               System.err.println("Error al buscar : "+this.getClass().getSimpleName()+" : "+error.getMessage());  
           }
           
           return lasFarmacias.iterator();
       }
    
          
          
     // buscar por Id 
          
          
       public Farmacia buscarPorId ( int elId){
       
           Farmacia unaFarmacia = new Farmacia();
           unaFarmacia.setNombreFarmacia(" la persona no existe");
           
           try {
               
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(
                       " SELECT * FROM "+this.getClass().getSimpleName()+" WHERE idFarmacia = ?");
               
               sql.setInt(1, elId);
               
               ResultSet rs = sql.executeQuery();
               
               
               while(rs.next()){
                   
                   unaFarmacia.setIdFarmacia(rs.getInt("idFarmacia"));
                   unaFarmacia.setNitFarmacia(rs.getString("nitFarmacia"));
                   unaFarmacia.setNombreFarmacia(rs.getString("nombreFarmacia"));
                   unaFarmacia.setTelefonoFarmacia(rs.getString ("TelefonoFarmacia"));
                   unaFarmacia.setCorreoFarmacia(rs.getString("correoFarmacia"));
                   unaFarmacia.setUbicacionFarmacia(rs.getString("ubicacionFarmacia"));
               }
               
           } catch (SQLException error) {
               
               System.err.println(" Error al buscar por id : "+error.getMessage());
           }
           return unaFarmacia;
        }
 //}
    
}
