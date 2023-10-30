/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import jakarta.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMON
 */
public class ProductoDeseado {
    
    
  
    private int idPersona;
    private int idProducto;
    private int paginacion;
    
    
    private String nombreProducto;
    private String descripcionUnidad;
    private String descripcionProductoGeneral;
    private double precioProducto;
    private int idProductoD;
    private String nombreImagen;

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionUnidad() {
        return descripcionUnidad;
    }

    public void setDescripcionUnidad(String descripcionUnidad) {
        this.descripcionUnidad = descripcionUnidad;
    }

    public String getDescripcionProductoGeneral() {
        return descripcionProductoGeneral;
    }

    public void setDescripcionProductoGeneral(String descripcionProductoGeneral) {
        this.descripcionProductoGeneral = descripcionProductoGeneral;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }
    
    
    
    
    
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

   
    
    public ProductoDeseado() {
    }


    
    
    
    
    
    
    
    
       public ArrayList listar(int pagina, int idPersona) throws SQLException{
       
//         Object idPersona = session.getAttribute("idPersona");
        
        ArrayList listaDeseados = new ArrayList();
        String listado = "SELECT p.idProducto, p.nombreProducto, p.descripcionUnidad, p.descripcionProductoGeneral, p.precioProducto, d.idProductoD, i.nombreImagen , i.tipoImagen FROM productodeseado d JOIN producto p ON d.idProducto = p.idProducto JOIN imagen i ON p.idProducto = i.idProducto WHERE d.idPersona = ? AND i.tipoimagen = 0 ORDER BY idProductoD ASC;";
        
        
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
            
            sql.setInt(1, (int) idPersona);
            
            
            
            ResultSet rs = sql.executeQuery();// el execute query hace parte STETAMENT
            
            while (rs.next()) {

                ProductoDeseado unProductoD = new ProductoDeseado();
                unProductoD.setIdProducto(rs.getInt("idProducto"));
                unProductoD.setNombreProducto(rs.getString("nombreProducto"));
                unProductoD.setDescripcionUnidad(rs.getString("descripcionUnidad"));
                unProductoD.setDescripcionProductoGeneral(rs.getString("descripcionProductoGeneral"));
                unProductoD.setPrecioProducto(rs.getDouble("precioProducto"));
                unProductoD.setIdProductoD(rs.getInt("idProductoD"));
                unProductoD.setNombreImagen(rs.getString("nombreImagen"));
                
                
                System.out.println("datos en producto deseado: ");
                System.out.println(rs.getInt("idProducto"));
                System.out.println(rs.getInt("idProductoD"));
                
                
                
                
                
                
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
                     
                     String consultaRepiticion = "SELECT idProducto FROM productodeseado WHERE idPersona=?";
                     PreparedStatement sql = Conexion.conectar().prepareStatement(consultaRepiticion);
                     
                     sql.setInt(1, this.getIdPersona());
                     
                     ResultSet rs = sql.executeQuery();// el execute query hace parte STETAMENT
                     
                     while (rs.next()) {//comprobacion       
                         
                         int verificacion = rs.getInt("idProducto");
                         
                         if (verificacion == idFavorito) {
                             
                             // nose se inserta nada ya que son iguales y se redirecciona a la misma pagina desde controlador
                                bandera = true;
                              System.out.println("son iguales");
                         }else{
                             System.out.println("no son iguales");
                         }
                    }
                     
                    if (bandera == false) {
                        
                        String consulta = "INSERT INTO ProductoDeseado VALUES (null,?,?)";
                        PreparedStatement sqlInsert = Conexion.conectar().prepareStatement(consulta);
                     
                        sqlInsert.setInt(1, this.getIdPersona());
                        sqlInsert.setInt(2, idFavorito);
                        
                        sqlInsert.executeUpdate();
                        
                        
                        System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");

                        
                    }

                } catch (SQLException error) {

                    System.err.println("Error al insertar - "+this.getClass().getSimpleName()+":"+error.getMessage());
                }
                
                
                return bandera;

        }
          
    
    // Eliminar
        
        
         public void eliminar(String opcion){
           
           try {
               PreparedStatement sql;
               if (opcion.equals("Eliminar")) {
                   //se elimina un solo produto 
                  sql = Conexion.conectar().prepareStatement("DELETE FROM "+this.getClass().getSimpleName()+" WHERE idProducto = ?");
               
                  
                    System.out.println(this.getIdProducto()+" el id en funcion ");
                    
                    sql.setInt(1, this.getIdProducto());
                    
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
         
         
      public int contarValores(int idPersona){
          
          int valorBD = 0;
          
          try {
              
              
              String consulta = "SELECT COUNT(*) AS contar FROM productodeseado WHERE idPersona=?";
              PreparedStatement sqlContar = Conexion.conectar().prepareStatement(consulta);
              
              sqlContar.setInt(1, idPersona);
                     
              
              
              
              ResultSet rs = sqlContar.executeQuery();// el execute query hace parte STETAMENT
              
              if (rs.next()) {
                  valorBD = rs.getInt("contar");
              }
              
          } catch (Exception error) {
              
              
              System.out.println("Error en la consulta "+error.getMessage());
              
              
          }
          
          
          return valorBD;
      
      }
         
       
       
    
    
    
    
    
    
    
    
    
}
