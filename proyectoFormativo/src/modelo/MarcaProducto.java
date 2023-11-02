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
public class MarcaProducto {
    
    private int idMarcaProducto;
    private String nombreMarca;

    public int getIdMarcaProducto() {
        return idMarcaProducto;
    }

    public void setIdMarcaProducto(int idMarcaProducto) {
        this.idMarcaProducto = idMarcaProducto;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
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
        final MarcaProducto other = (MarcaProducto) obj;
        return this.idMarcaProducto == other.idMarcaProducto;
    }
    
    
    //    CRUD{
    
//    Listar
    
       public Iterator<MarcaProducto>Listar(){
         ArrayList<MarcaProducto> lasMarcas = new ArrayList<>();
    
        try {
            
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            MarcaProducto unaMarca;
            
            while (rs.next()) {

                unaMarca = new MarcaProducto();
                unaMarca.setIdMarcaProducto(rs.getInt("idMarcaProducto"));
                unaMarca.setNombreMarca(rs.getString("nombreMarca"));
             
           
                
                lasMarcas.add(unaMarca);
            }
            
        } catch (SQLException error) {
            
            System.err.println("Error al listar las farmacias : "+error.getMessage());
        }
        if(lasMarcas.isEmpty()){
            
            MarcaProducto miMarca = new MarcaProducto();
            miMarca.setNombreMarca("No hay Personas");
            lasMarcas.add(miMarca);
        }
        return lasMarcas.iterator();
    
    }
       
       
       
        // insertar
       
       
          public void insertar (){
//                

                try {
                     System.out.println("Dentre al try del insertar ");
                      
                     PreparedStatement sql = ConexionBD.conexion.prepareStatement(" INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,?)");
                 

                     sql.setString(1, this.getNombreMarca());
                     

                     sql.executeUpdate();

                     System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");


                } catch (SQLException error) {

                    System.err.println("Error al insertar - "+this.getClass().getSimpleName()+":"+error.getMessage());
                }

        }
    
         // Modificar
        public void modificar(){
       
           try {
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(" UPDATE "+this.getClass().getSimpleName()+" SET nombreMarca =?  WHERE idMarcaProducto=?");
               
                sql.setString(1, this.getNombreMarca());
                
                sql.setInt(2, this.getIdMarcaProducto());
                
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
                (" DELETE FROM "+this.getClass().getSimpleName()+" WHERE idMarcaProducto=? ");
               
               sql.setInt(1,this.getIdMarcaProducto());
               
               sql.executeUpdate();
               
               System.out.println(this.getClass().getSimpleName()+" Eliminado correctamente");
               
           } catch (SQLException error) {
               
               System.err.println("Error al Eliminar "
               +this.getClass().getSimpleName()+" : "+error.getMessage()); 
           }
       }
         
    
       //Buscar 
         
          public Iterator <MarcaProducto> buscar (String busqueda){
           
           ArrayList <MarcaProducto> lasMarcas = new ArrayList<>();
       
           try {
               
               
               PreparedStatement sql= ConexionBD.conexion.prepareStatement
               (" SELECT * FROM "+this.getClass().getSimpleName()
              +" WHERE nombreMarca LIKE ?  ");
               
               sql.setString(1,"%"+busqueda+"%");
               
               ResultSet rs = sql.executeQuery();
               
                MarcaProducto unaMarca;
               
               while (rs.next()) {
                   
                   unaMarca = new MarcaProducto();
                   unaMarca.setIdMarcaProducto(rs.getInt ("idMarcaProducto"));
                   unaMarca.setNombreMarca(rs.getString("nombreMarca"));
              
               
                   
                   lasMarcas.add(unaMarca);
               }
               
           } catch (SQLException error) {
               System.err.println("Error al buscar : "+this.getClass().getSimpleName()+" : "+error.getMessage());  
           }
           
           return lasMarcas.iterator();
       }
          
          // poner el buscar por id 
          
           public MarcaProducto buscarPorId (int elId){
       
           MarcaProducto unaMarca = new MarcaProducto();
           unaMarca.setNombreMarca(" la Marca no existe");
           
           try {
               
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(
                       " SELECT * FROM "+this.getClass().getSimpleName()+" WHERE idMarcaProducto = ?");
               
               sql.setInt(1, elId);
               
               ResultSet rs = sql.executeQuery();
               
               
               while(rs.next()){
                   
                   unaMarca = new MarcaProducto();
                   unaMarca.setIdMarcaProducto(rs.getInt ("idMarcaProducto"));
                   unaMarca.setNombreMarca(rs.getString("nombreMarca"));
               }
               
           } catch (SQLException error) {
               
               System.err.println(" Error al buscar por id : "+error.getMessage());
           }
           return unaMarca;
        }
          
          
          
}
