/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMON
 */
public class Producto {
    
    private int idProducto;
    private String nombreProducto;
    private String descripcionUnidad;
    private String descripcionProductoGeneral;
    private int StockProducto;
    private float precioProducto;
    private String imagenProducto;
    private int idMarcaProducto;
    
//    getter and setter

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

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

    public int getStockProducto() {
        return StockProducto;
    }

    public void setStockProducto(int StockProducto) {
        this.StockProducto = StockProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public int getIdMarcaProducto() {
        return idMarcaProducto;
    }

    public void setIdMarcaProducto(int idMarcaProducto) {
        this.idMarcaProducto = idMarcaProducto;
    }
    
    // to string 
    @Override
    public String toString() {
        return "Producto{" + "nombreProducto=" + nombreProducto + '}';
    }
    
//    el hast y equals no los pongo para comprobar si estan haciendo algo aunque no creo porque es por medio del id 
       
    
     public Iterator<Producto>Listar(){
         ArrayList<Producto> losProductos = new ArrayList<>();
    
        try {
            
            PreparedStatement sql = ConexionBD.conexion.prepareStatement(" SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Producto unProducto;
            
            while (rs.next()) {

                unProducto = new Producto();
                unProducto.setIdProducto(rs.getInt("idProducto"));
                unProducto.setNombreProducto(rs.getString("nombreProducto"));
                unProducto.setDescripcionUnidad(rs.getString("descripcionUnidad"));
                unProducto.setDescripcionProductoGeneral(rs.getString("descripcionProductoGeneral"));
                unProducto.setStockProducto(rs.getInt("StockProducto"));
                unProducto.setPrecioProducto(rs.getFloat("precioProducto"));
                unProducto.setImagenProducto(rs.getString("nombreImagen"));
                unProducto.setIdMarcaProducto(rs.getInt("idMarcaProducto"));
                
                losProductos.add(unProducto);
            }
            
        } catch (SQLException error) {
            
            System.err.println("Error al listar las personas : "+error.getMessage());
        }
        
        if(losProductos.isEmpty()){
            
            Producto miProducto = new Producto();
            miProducto.setNombreProducto("No hay Productos");
            losProductos.add(miProducto);
        }
        return losProductos.iterator();
    
    }
     
    // Insertar
     
        public void insertar (){
//                

                try {
                     System.out.println("Dentre al try del insertar ");
                      
                     PreparedStatement sql = ConexionBD.conexion.prepareStatement(" INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,?,?,?,?,?,?,?)");
                 

                     sql.setString(1, this.getNombreProducto());
                     sql.setString(2, this.getDescripcionUnidad());
                     sql.setString(3, this.getDescripcionProductoGeneral());
                     sql.setInt(4, this.getStockProducto());
                     sql.setFloat(5, this.getPrecioProducto());
                     sql.setString(6, this.getImagenProducto());
                     sql.setInt(7, this.getIdMarcaProducto());


                     sql.executeUpdate();

                     System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");


                } catch (SQLException error) {

                    System.err.println("Error al insertar - "+this.getClass().getSimpleName()+": "+error.getMessage());
                }

        }
        
         public void modificar(){
       
           try {
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(" UPDATE "+this.getClass().getSimpleName()+" SET nombreProducto = ?,"
                       + " descripcionUnidad=?, descripcionProductoGeneral=?, stockProducto=?, precioProducto=?, nombreImagen=?,"
                       + " idMarcaProducto=? WHERE idProducto=?");
              
               
                sql.setString(1, this.getNombreProducto());
                sql.setString(2, this.getDescripcionUnidad());
                sql.setString(3, this.getDescripcionProductoGeneral());
                sql.setInt(4, this.getStockProducto());
                sql.setFloat(5, this.getPrecioProducto());
                sql.setString(6, this.getImagenProducto());
                sql.setInt(7, this.getIdMarcaProducto());
                
                sql.setInt(8, this.getIdProducto());
               
                sql.executeUpdate();
                
                System.out.println(this.getClass().getSimpleName()+" Modificado correctamente ");
                
               
               
           } catch (SQLException error) {
               
               System.out.println(" Error al modificar :  "+this.getClass().getSimpleName());
               System.out.println(" Error :  "+error.getMessage());
               
           }
       }
         
        public void eliminar(){
           
           try {
               PreparedStatement sql= ConexionBD.conexion.prepareStatement
                (" DELETE FROM "+this.getClass().getSimpleName()+" WHERE idProducto=?");
               
               sql.setInt(1,this.getIdProducto());
               sql.executeUpdate();
               
               System.out.println(this.getClass().getSimpleName()+" Eliminado correctamente");
               
           } catch (SQLException error) {
               
               System.err.println("Error al Eliminar "
               +this.getClass().getSimpleName()+" : "+error.getMessage()); 
           }
       }
        
       
        //buscar
       
       public Iterator <Producto> buscar (String busqueda){
           
           ArrayList <Producto> losProductos = new ArrayList<>();
       
           try {
               
               
               PreparedStatement sql= ConexionBD.conexion.prepareStatement
               (" SELECT * FROM "+this.getClass().getSimpleName()
              +" WHERE nombreProducto LIKE ? OR descripcionUnidad LIKE ? OR descripcionProductoGeneral LIKE ?  OR StockProducto LIKE ?  OR precioProducto LIKE ?"
                      + " OR nombreImagen LIKE ? OR idMarcaProducto LIKE ? ");
               
               sql.setString(1,"%"+busqueda+"%");
               sql.setString(2,"%"+busqueda+"%");
               sql.setString(3,"%"+busqueda+"%");
               sql.setString(4,"%"+busqueda+"%");
               sql.setString(5,"%"+busqueda+"%");
               sql.setString(6,"%"+busqueda+"%");
               sql.setString(7,"%"+busqueda+"%");
             
               
               ResultSet rs = sql.executeQuery();
               
               Producto unProducto;
               
               while (rs.next()) {
                   
                    unProducto = new Producto();
                    unProducto.setIdProducto(rs.getInt("idProducto"));
                    unProducto.setNombreProducto(rs.getString("nombreProducto"));
                    unProducto.setDescripcionUnidad(rs.getString("descripcionUnidad"));
                    unProducto.setDescripcionProductoGeneral(rs.getString("descripcionProductoGeneral"));
                    unProducto.setStockProducto(rs.getInt("StockProducto"));
                    unProducto.setPrecioProducto(rs.getFloat("precioProducto"));
                    unProducto.setImagenProducto(rs.getString("nombreImagen"));
                    unProducto.setIdMarcaProducto(rs.getInt("idMarcaProducto"));
                   
                   losProductos.add(unProducto);
                   
                 
               }
               
           } catch (SQLException error) {
               System.err.println("Error al buscar : "+this.getClass().getSimpleName()+" : "+error.getMessage());  
           }
           
           return losProductos.iterator();
       }
//}         
       
        // buscar por id 
       
       public Producto buscarPorId ( int elId){
       
           Producto unProducto = new Producto();
           unProducto.setNombreProducto(" la persona no existe");
           
           try {
               
               PreparedStatement sql = ConexionBD.conexion.prepareStatement(
                     " SELECT * FROM "+this.getClass().getSimpleName()+" WHERE idProducto = ?");
               
               sql.setInt(1, elId);
               
               ResultSet rs = sql.executeQuery();
               
               while(rs.next()){
                   
                  
                    unProducto = new Producto();
                    unProducto.setIdProducto(rs.getInt("idProducto"));
                    unProducto.setNombreProducto(rs.getString("nombreProducto"));
                    unProducto.setDescripcionUnidad(rs.getString("descripcionUnidad"));
                    unProducto.setDescripcionProductoGeneral(rs.getString("descripcionProductoGeneral"));
                    unProducto.setStockProducto( rs.getInt("StockProducto"));
                    unProducto.setPrecioProducto(rs.getFloat("precioProducto"));
                    unProducto.setImagenProducto(rs.getString("nombreImagen"));
                    unProducto.setIdMarcaProducto(rs.getInt("idMarcaProducto"));
                   
               }
               
           } catch (SQLException error) {
               
               System.err.println(" Error al buscar por id : "+error.getMessage());
           }
           return unProducto;
        }
       
    
    
    
    
}
