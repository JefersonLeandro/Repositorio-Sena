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
public class Imagen {
    
   private int idImagen;
   private String nombreImagen;
   private int tipoImagen;
   private int idProducto;
    private int paginacion;

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public int getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(int tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    //ConstructorVacio

    public Imagen() {
    }
    
   //Contructor 

    public Imagen(int idImagen, String nombreImagen, int tipoImagen, int idProducto) {
        this.idImagen = idImagen;
        this.nombreImagen = nombreImagen;
        this.tipoImagen = tipoImagen;
        this.idProducto = idProducto;
    }
   
    //    CRUD{
    
//    Listar
        
    public ArrayList listar(int pagina) throws SQLException{
       

        
        ArrayList listaImagenes = new ArrayList();
        String listado = " SELECT * FROM "+this.getClass().getSimpleName()+" GROUP BY idImagen";
        
       
        
        if (pagina>0) {
            
            int paginacionMax = pagina*this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            
            try {
               
                listado = " SELECT * FROM "+this.getClass().getSimpleName()+" GROUP BY idImagen LIMIT ?,?";
                
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
            ResultSet rs = sql.executeQuery();// el execute query hace parte STETAMENT
            
            while (rs.next()) {

                Imagen unaImagen = new Imagen();
                unaImagen.setIdImagen(rs.getInt("idImagen"));
                unaImagen.setNombreImagen(rs.getString("nombreImagen"));
                unaImagen.setTipoImagen(rs.getInt("tipoImagen"));
                unaImagen.setIdProducto(rs.getInt("idProducto"));
                
                
                listaImagenes.add(unaImagen);
            }
            
        } catch (SQLException error) {
            
            System.err.println("Error al listar las Farmacias: "+error.getLocalizedMessage());
        }
    
        Conexion.desconectar();
        return listaImagenes;
    }
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
           // buscar
       
       public Iterator <Producto> buscar (String busqueda){
           
           ArrayList <Producto> losProductos = new ArrayList<>();
       
           try {
               PreparedStatement sql= Conexion.conectar().prepareStatement
               (" SELECT * FROM "+this.getClass().getSimpleName()
              +" WHERE nombreProducto LIKE ? OR descripcionUnidad LIKE ? OR descripcionProductoGeneral LIKE ?  OR StockProducto LIKE ?  OR precioProducto LIKE ?"
                      + "  OR idMarcaProducto LIKE ? ");
               
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
                 
                   
                   losProductos.add(unProducto);
                   
                 
               }
               
           } catch (SQLException error) {
               System.err.println("Error al buscar : "+this.getClass().getSimpleName()+" : "+error.getMessage());  
           }
           
           return losProductos.iterator();
       }
   
   
    
    
    
}
