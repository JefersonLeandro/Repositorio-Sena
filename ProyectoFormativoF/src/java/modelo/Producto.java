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
import java.util.List;

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
    private double precioProducto;
    private int idMarcaProducto;
    private int paginacion;
    
    // imagen
    
    //se crea un objeto para recibir los atributos de la imagen como objeto y por medio de los seter y getter
    private Imagen unaImagen;
    
    
    public Imagen getUnaImagen() {
        return unaImagen;
    }

    public void setUnaImagen(Imagen unaImagen) {
        this.unaImagen = unaImagen;
    }
 
    
    
    
    
    
    
    
    
    
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

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getIdMarcaProducto() {
        return idMarcaProducto;
    }

    public void setIdMarcaProducto(int idMarcaProducto) {
        this.idMarcaProducto = idMarcaProducto;
    }

    public Producto() {
        
    }

    public Producto(int idProducto, String nombreProducto, String descripcionUnidad, String descripcionProductoGeneral, int StockProducto, double precioProducto, int idMarcaProducto) {
        
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionUnidad = descripcionUnidad;
        this.descripcionProductoGeneral = descripcionProductoGeneral;
        this.StockProducto = StockProducto;
        this.precioProducto = precioProducto;
        this.idMarcaProducto = idMarcaProducto;
        
    }

    

    
    
    
    
    
    
     public ArrayList listar(int pagina , boolean opcion) throws SQLException{
         
        ArrayList listaProductos = new ArrayList();
        
        // logica para mostrar dos listados ya que en el index 
        
        
         String listado;
        
         if (opcion) {
             
             listado = "SELECT * FROM Producto p  LEFT JOIN imagen i ON p.idProducto = i.idProducto GROUP BY p.idProducto, i.idProducto";
             
         }else{
         
             listado = "SELECT * FROM Producto p LEFT JOIN imagen i ON p.idProducto = i.idProducto WHERE i.tipoimagen = 0 OR i.tipoImagen IS NULL GROUP BY p.idProducto, i.idProducto;";
         }
        
        
       
        
        if (pagina>0) {
            
            int paginacionMax = pagina*this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            
            try {
             
                listado = " SELECT * FROM "+this.getClass().getSimpleName()+" GROUP BY idProducto LIMIT ?,?";
                
                PreparedStatement sql = Conexion.conectar().prepareStatement(listado);
                 
                sql.setInt(1, paginacionMin);
                sql.setInt(2, paginacionMax);
                
//              ResultSet resutadoL2 = sql.executeQuery(); creo que no es necesario
            } catch (Exception error) {
                System.err.println("Error al hacer la consulta select con limite en la funcion Listar"+error.getLocalizedMessage());   
            }
              System.out.println("llegue al final de la funcion de la listar");
        }
       

        try {
            
            
            
            PreparedStatement sql = Conexion.conectar().prepareStatement(listado);
            ResultSet rs = sql.executeQuery();// el execute query hace parte STETAMENT
            
            Producto unProducto;
            
            while (rs.next()) {

             
                unProducto = new Producto();
                unProducto.setIdProducto(rs.getInt("idProducto"));
                unProducto.setNombreProducto(rs.getString("nombreProducto"));
                unProducto.setDescripcionUnidad(rs.getString("descripcionUnidad"));
                unProducto.setDescripcionProductoGeneral(rs.getString("descripcionProductoGeneral"));
                unProducto.setStockProducto(rs.getInt("StockProducto"));
                unProducto.setPrecioProducto(rs.getFloat("precioProducto"));
                unProducto.setIdMarcaProducto(rs.getInt("idMarcaProducto"));
                
                
                // no creamos otro objeto para asignarle los valores que vienen 
                
                Imagen laImagen = new Imagen();
                
                laImagen.setIdProducto(rs.getInt("idProducto"));
                laImagen.setNombreImagen(rs.getString("nombreImagen"));
               
                if (laImagen.getNombreImagen() == null) {// si el nombre de la imagen viene como nulo se le asigna una imagen por defecto que serian siendo esta la que los producto que no tienen imagen se le pone
                    
                    laImagen.setNombreImagen("producto-sin-imagen.png");
                    
                }
                
                unProducto.setUnaImagen(laImagen); // le asinamos los atributos al objeto 

                listaProductos.add(unProducto);
            }
            
        } catch (SQLException error) {
            
            System.err.println("Error al listar las Farmacias: "+error.getLocalizedMessage());
        }
    
        Conexion.desconectar();
        return listaProductos;
    } 
    
    
    
    
    
    // Insertar
     
        public void insertar (){
//                

                try {
                     System.out.println("Dentre al try del insertar ");
                     String consulta = "INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,?,?,?,?,?,?)";
                    
                     PreparedStatement sql = Conexion.conectar().prepareStatement(consulta);
                     sql.setString(1, this.getNombreProducto());
                     sql.setString(2, this.getDescripcionUnidad());
                     sql.setString(3, this.getDescripcionProductoGeneral());
                     sql.setInt(4, this.getStockProducto());
                     sql.setDouble(5, this.getPrecioProducto());
                     sql.setInt(6, this.getIdMarcaProducto());


                     sql.executeUpdate();

                     System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");


                } catch (SQLException error) {

                    System.err.println("Error al insertar - "+this.getClass().getSimpleName()+": "+error.getMessage());
                }

        }
        
         public void modificar(){
       
           try {
               
               String consulta = " UPDATE "+this.getClass().getSimpleName()+" SET nombreProducto = ?, descripcionUnidad=?, "
                       + "descripcionProductoGeneral=?, stockProducto=?, precioProducto=?,"
                       + " idMarcaProducto=? WHERE idProducto=?";
               
                PreparedStatement sql = Conexion.conectar().prepareStatement(consulta);
              
               
                sql.setString(1, this.getNombreProducto());
                sql.setString(2, this.getDescripcionUnidad());
                sql.setString(3, this.getDescripcionProductoGeneral());
                sql.setInt(4, this.getStockProducto());
                sql.setDouble(5, this.getPrecioProducto());
                sql.setInt(6, this.getIdMarcaProducto());
                
                sql.setInt(7, this.getIdProducto());
               
                sql.executeUpdate(); 
                System.out.println(this.getClass().getSimpleName()+" Modificado correctamente ");
                
               
               
           } catch (SQLException error) {
               
               System.out.println(" Error al modificar :  "+this.getClass().getSimpleName());
               System.out.println(" Error :  "+error.getMessage());
               
           }
       }
         
        public void eliminar(){
           
           try {
               String consulta = " DELETE FROM "+this.getClass().getSimpleName()+" WHERE idProducto=?";
               PreparedStatement sql= Conexion.conectar().prepareStatement(consulta);
               
               sql.setInt(1,this.getIdProducto());
               sql.executeUpdate();
               
               System.out.println(this.getClass().getSimpleName()+" Eliminado correctamente");
               
           } catch (SQLException error) {
               
               System.err.println("Error al Eliminar "+this.getClass().getSimpleName()+" : "+error.getMessage()); 
           }
       }
        
        //buscar utilizado en la tabla imagen 
        
           public List <Producto> buscar (String busqueda){
           
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
           
             
               
               ResultSet rs = sql.executeQuery();
               
               Producto unProducto;
               
               while (rs.next()) {
                   
                    unProducto = new Producto();
                    unProducto.setIdProducto(rs.getInt("idProducto"));
                    unProducto.setNombreProducto(rs.getString("nombreProducto"));
                    unProducto.setDescripcionUnidad(rs.getString("descripcionUnidad"));
                    
                    
                    
                    System.out.println("busqueda: ");
                    System.out.println(rs.getInt("idProducto"));
                    System.out.println(rs.getString("nombreProducto"));
                    System.out.println(rs.getString("descripcionUnidad"));
                   
                   losProductos.add(unProducto);
                   
                 
               }
               
           } catch (SQLException error) {
               System.err.println("Error al buscar : "+this.getClass().getSimpleName()+" : "+error.getMessage());  
           }
           
           return losProductos;
       }
   
        
       
//        //buscar
//       
//       public Iterator <Producto> buscar (String busqueda){
//           
//           ArrayList <Producto> losProductos = new ArrayList<>();
//       
//           try {
//               PreparedStatement sql= Conexion.conectar().prepareStatement
//               (" SELECT * FROM "+this.getClass().getSimpleName()
//              +" WHERE nombreProducto LIKE ? OR descripcionUnidad LIKE ? OR descripcionProductoGeneral LIKE ?  OR StockProducto LIKE ?  OR precioProducto LIKE ?"
//                      + " OR nombreImagen LIKE ? OR idMarcaProducto LIKE ? ");
//               
//               sql.setString(1,"%"+busqueda+"%");
//               sql.setString(2,"%"+busqueda+"%");
//               sql.setString(3,"%"+busqueda+"%");
//               sql.setString(4,"%"+busqueda+"%");
//               sql.setString(5,"%"+busqueda+"%");
//               sql.setString(6,"%"+busqueda+"%");
//               sql.setString(7,"%"+busqueda+"%");
//             
//               
//               ResultSet rs = sql.executeQuery();
//               
//               Producto unProducto;
//               
//               while (rs.next()) {
//                   
//                    unProducto = new Producto();
//                    unProducto.setIdProducto(rs.getInt("idProducto"));
//                    unProducto.setNombreProducto(rs.getString("nombreProducto"));
//                    unProducto.setDescripcionUnidad(rs.getString("descripcionUnidad"));
//                    unProducto.setDescripcionProductoGeneral(rs.getString("descripcionProductoGeneral"));
//                    unProducto.setStockProducto(rs.getInt("StockProducto"));
//                    unProducto.setPrecioProducto(rs.getFloat("precioProducto"));
////                    unProducto.setImagenProducto(rs.getString("nombreImagen"));
//                    unProducto.setIdMarcaProducto(rs.getInt("idMarcaProducto"));
//                   
//                   losProductos.add(unProducto);
//                   
//                 
//               }
//               
//           } catch (SQLException error) {
//               System.err.println("Error al buscar : "+this.getClass().getSimpleName()+" : "+error.getMessage());  
//           }
//           
//           return losProductos.iterator();
//       }
////}         
//       
//        // buscar por id 
//       
//       public Producto buscarPorId ( int elId){
//       
//           Producto unProducto = new Producto();
//           unProducto.setNombreProducto(" la persona no existe");
//           
//           try {
//               
//               PreparedStatement sql = Conexion.conectar().prepareStatement(
//                     " SELECT * FROM "+this.getClass().getSimpleName()+" WHERE idProducto = ?");
//               
//               sql.setInt(1, elId);
//               
//               ResultSet rs = sql.executeQuery();
//               
//               while(rs.next()){
//                   
//                    unProducto = new Producto();
//                    unProducto.setIdProducto(rs.getInt("idProducto"));
//                    unProducto.setNombreProducto(rs.getString("nombreProducto"));
//                    unProducto.setDescripcionUnidad(rs.getString("descripcionUnidad"));
//                    unProducto.setDescripcionProductoGeneral(rs.getString("descripcionProductoGeneral"));
//                    unProducto.setStockProducto( rs.getInt("StockProducto"));
//                    unProducto.setPrecioProducto(rs.getFloat("precioProducto"));
////                    unProducto.setImagenProducto(rs.getString("nombreImagen"));
//                    unProducto.setIdMarcaProducto(rs.getInt("idMarcaProducto"));
//                   
//               }
//               
//           } catch (SQLException error) {
//               
//               System.err.println(" Error al buscar por id : "+error.getMessage());
//           }
//           return unProducto;
//        }
//       
    
    
    
    
}
