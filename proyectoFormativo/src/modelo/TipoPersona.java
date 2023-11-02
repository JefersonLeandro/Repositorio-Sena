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
public class TipoPersona {
    
    private int idTipoPersona;
    private String nombreTipoPersona;
    
    
//    getter y setter

    public int getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(int idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getNombreTipoPersona() {
        return nombreTipoPersona;
    }

    public void setNombreTipoPersona(String nombreTipoPersona) {
        this.nombreTipoPersona = nombreTipoPersona;
    }

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
        final TipoPersona other = (TipoPersona) obj;
        return this.idTipoPersona == other.idTipoPersona;
    }
    
    
    
      //    CRUD{
    
//    Listar
    
       public Iterator<TipoPersona>Listar(){
         ArrayList<TipoPersona> losTiposP = new ArrayList<>();
    
        try {
            
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            TipoPersona unTipoPersona;
            
            while (rs.next()) {

                unTipoPersona = new TipoPersona();
                unTipoPersona.setIdTipoPersona(rs.getInt("idTipoPersona"));
                unTipoPersona.setNombreTipoPersona(rs.getString("nombreTipoPersona"));
             
           
                
                losTiposP.add(unTipoPersona);
            }
            
        } catch (SQLException error) {
            
            System.err.println("Error al listar las farmacias : "+error.getMessage());
        }
        
        if(losTiposP.isEmpty()){
            
            TipoPersona miTipoP = new TipoPersona();
            miTipoP.setNombreTipoPersona("No hay Tipo de personas");
            losTiposP.add(miTipoP);
        }
        return losTiposP.iterator();
    
    }
    
    
        // insertar
       
       
          public void insertar (){
//                

                try {
                     System.out.println("Dentre al try del insertar ");
                      
                     PreparedStatement sql = ConexionBD.conexion.prepareStatement(" INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,?)");
                 

                     sql.setString(1, this.getNombreTipoPersona());
                     

                     sql.executeUpdate();

                     System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");


                } catch (SQLException error) {

                    System.err.println("Error al insertar tipo persona - "+this.getClass().getSimpleName()+":"+error.getMessage());
                }

        }
          
          
           // Modificar
        public void modificar(){
       
           try {
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(" UPDATE "+this.getClass().getSimpleName()+" SET nombreTipoPersona =?  WHERE idTipoPersona=?");
               
                sql.setString(1, this.getNombreTipoPersona());
                
                sql.setInt(2, this.getIdTipoPersona());
                
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
                (" DELETE FROM "+this.getClass().getSimpleName()+" WHERE idTipoPersona=? ");
               
               sql.setInt(1,this.getIdTipoPersona());
               
               sql.executeUpdate();
               
               System.out.println(this.getClass().getSimpleName()+" Eliminado correctamente");
               
           } catch (SQLException error) {
               
               System.err.println("Error al Eliminar "
               +this.getClass().getSimpleName()+" : "+error.getMessage()); 
           }
       }
         
         
          //Buscar 
         
        public Iterator <TipoPersona> buscar (String busqueda){

         ArrayList <TipoPersona> losTiposP = new ArrayList<>();

         try {


             PreparedStatement sql= ConexionBD.conexion.prepareStatement
             (" SELECT * FROM "+this.getClass().getSimpleName()+" WHERE nombreTipoPersona LIKE ?  ");

             sql.setString(1,"%"+busqueda+"%");

             ResultSet rs = sql.executeQuery();

             TipoPersona unTipoPersona;

             while (rs.next()) {

                 unTipoPersona = new TipoPersona();
                 unTipoPersona.setIdTipoPersona(rs.getInt ("idTipoPersona"));
                 unTipoPersona.setNombreTipoPersona(rs.getString("nombreTipoPersona"));
                 
                 losTiposP.add(unTipoPersona);
             }

         } catch (SQLException error) {
             System.err.println("Error al buscar : "+this.getClass().getSimpleName()+" : "+error.getMessage());  
         }

         return losTiposP.iterator();
        }
    
        
      // poner el buscar por id 
          
        public TipoPersona buscarPorId (int elId){
       
           TipoPersona unTipoPersona = new TipoPersona();
           unTipoPersona.setNombreTipoPersona(" el tipo persona no existe");
           
           try {
               
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(
                       " SELECT * FROM "+this.getClass().getSimpleName()+" WHERE idTipoPersona = ?");
               
               sql.setInt(1, elId);
               
               ResultSet rs = sql.executeQuery();
               
               
               while(rs.next()){
                   
                   unTipoPersona = new TipoPersona();
                   unTipoPersona.setIdTipoPersona(rs.getInt ("idTipoPersona"));
                   unTipoPersona.setNombreTipoPersona(rs.getString("nombreTipoPersona"));
               }
               
           } catch (SQLException error) {
               
               System.err.println(" Error al buscar por id : "+error.getMessage());
           }
           return unTipoPersona;
        }
}
