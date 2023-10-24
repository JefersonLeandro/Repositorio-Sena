/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMON
 */
public class ProductoDeseado {
    
    
    private int idProductoD;
    private int idPersona;
    private int idProducto;
    private int paginacion;
    
    
    
    
    
    
    //getter and setter 

    public int getIdProductoD() {
        return idProductoD;
    }

    public void setIdProductoD(int idProductoD) {
        this.idProductoD = idProductoD;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
    
       public ArrayList listar(int pagina) throws SQLException{
       

        
        ArrayList listaDeseados = new ArrayList();
        String listado = " SELECT p.nombreProducto, p.descripcionUnidad, p.descripcionProductoGeneral, p.precioProducto, p.imagenProducto ,d.idProductoD FROM productodeseado d JOIN producto p ON d.idProducto = p.idProducto and idPersona=?";
        
        
        if (pagina>0) {
            
            int paginacionMax = pagina*this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            
            try {

                listado = " SELECT * FROM "+this.getClass().getSimpleName()+" GROUP BY idProductoD LIMIT ?,?";
                
                PreparedStatement sql = Conexion.conectar().prepareStatement(listado);
                 
                sql.setInt(1, paginacionMin);
                sql.setInt(2, paginacionMax);

            } catch (Exception error) {
                
                System.err.println("Error al hacer la consulta select con limite en la funcion Listar"+error.getLocalizedMessage());   
            }
            
              System.out.println("llegue al final de la funcion de la listar");
        }
       

        try {
            
            
            
            PreparedStatement sql = Conexion.conectar().prepareStatement(listado);
            sql.setInt(1, this.getIdPersona());

            
            
            
            
            
            ResultSet rs = sql.executeQuery();// el execute query hace parte STETAMENT
            
            while (rs.next()) {

                ProductoDeseado unProductoD = new ProductoDeseado();
                unProductoD.setIdProductoD(rs.getInt("idProductoD"));
                unProductoD.setIdPersona(rs.getInt("idPersona"));
                unProductoD.setIdProducto(rs.getInt("idProducto"));
                
                listaDeseados.add(unProductoD);
            }
            
        } catch (SQLException error) {
            
            System.err.println("Error al listar los productos deseados: "+error.getLocalizedMessage());
        }
    
        Conexion.desconectar();
        
        return listaDeseados;
    }
    
    
    // insertar
          public boolean  insertar (){
//                
             boolean bandera = false;

                try {
                    
                    
                     int idFavorito = this.getIdProducto();
                     
                     String consultaRepiticion = "SELECT idProducto from productodeseado WHERE idPersona=?";
                     PreparedStatement sql = Conexion.conectar().prepareStatement(consultaRepiticion);
                     
                     sql.setInt(1, this.getIdPersona());
                     
                     ResultSet rs = sql.executeQuery();// el execute query hace parte STETAMENT
                     
                     while (rs.next()) {//comprobacion       
                         
                         int verificacion = rs.getInt("idProducto");
                         
                         if (verificacion == idFavorito) {
                             
                             // nose se inserta nada ya que son iguales y se redirecciona a la misma pagina desde controlador
                                bandera = true;
                              
                         }
                    }
                     
                    if ( bandera == false) {
                        
                        String consulta = "INSERT INTO ProductoDeseado VALUES (null,?,?)";
                        PreparedStatement sqlInsert = Conexion.conectar().prepareStatement(consulta);
                     
                        sql.setInt(1, this.getIdPersona());
                        sql.setInt(2, idFavorito);
                        
                        sql.executeUpdate();
                        
                        
                        System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");

                        
                    }

                } catch (SQLException error) {

                    System.err.println("Error al insertar - "+this.getClass().getSimpleName()+":"+error.getMessage());
                }
                
                
                return bandera;

        }
          
    
    // Eliminar
        
        
         public void eliminar(boolean opcion){
           
           try {
               PreparedStatement sql;
               if (opcion) {
                   //se elimina un solo produto 
                  sql = Conexion.conectar().prepareStatement(" DELETE FROM "+this.getClass().getSimpleName()+" WHERE idProductoD=?");
               
                sql.setInt(1,this.getIdProductoD());

            

                System.out.println(this.getClass().getSimpleName()+" Eliminado correctamente un producto");
                   
                   
               }else{
                  // se elimina todos lo productos
                 sql= Conexion.conectar().prepareStatement(" DELETE FROM "+this.getClass().getSimpleName()+";");
                
                System.out.println(this.getClass().getSimpleName()+" Eliminado correctamente todos los productos");
                  
               
               
               }
               
                sql.executeUpdate();
               
               
               
               
           } catch (SQLException error) {
               
               System.err.println("Error al Eliminar "
               +this.getClass().getSimpleName()+" : "+error.getMessage()); 
           }
       }
         
         
      public int contarValores(){
      
          try {
              
              String consulta = "SELECT COUNT(*) FROM productodeseado WHERE idPersona=?";
            PreparedStatement sqlContar = Conexion.conectar().prepareStatement(consulta);
              
              
              
          } catch (Exception e) {
          }
          
          
          
     
          
          
          
          
      
      
      
      
      
      
      }
         
       
       
    
    
    
    
    
    
    
    
    
}
