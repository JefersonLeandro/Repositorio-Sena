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
    private int paginacion;

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
    // constructor vacio 

    public MarcaProducto() {
    }
    
    // constructor de datos

    public MarcaProducto(int idMarcaProducto, String nombreMarca ) {// en caso se recibe la pagina pero  como nose paginar la voy a pasar como cero solo la dejo para acordarme y despues hacerme una         this.idMarcaProducto = idMarcaProducto;
        this.nombreMarca = nombreMarca;
    }
    
    
    
    
    
    
    
    
    //    CRUD{
    
//    Listar
  
    public ArrayList listar(int pagina) throws SQLException{
       
        
//    
        System.out.println("dentre al Listar - modeloPersona");
        
        ArrayList listaMarcas = new ArrayList();
        
        MarcaProducto laMarca;
        String listado = " SELECT * FROM "+this.getClass().getSimpleName()+" GROUP BY idMarcaProducto";
        
       
       
        if (pagina>0) {
           
            int paginacionMax = pagina*this.paginacion;
            int paginacionMin = paginacionMax - this.paginacion;
            
            System.out.println("dentre al if del listar");
            try {
                System.out.println("dentre al try catch");
                listado = " SELECT * FROM "+this.getClass().getSimpleName()+" GROUP BY idMarcaProducto LIMIT ?,?";
                
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

            while (rs.next()) {
                MarcaProducto unaMarca = new MarcaProducto();
                unaMarca.setIdMarcaProducto(rs.getInt("idMarcaProducto"));
                unaMarca.setNombreMarca(rs.getString("nombreMarca"));
                listaMarcas.add(unaMarca);
            }
            
        } catch (SQLException error) {
            
            System.err.println("Error al listar las Personas: "+error.getLocalizedMessage());
            
        }
    
        Conexion.desconectar();
        return listaMarcas;

    
    }
    
    
       
       
          public void insertar (){
//                

                try {
                     System.out.println("Dentre al try del insertar ");
                     
                     String consulta = " INSERT INTO "+this.getClass().getSimpleName()+" VALUES (NULL,?)"; 
                     PreparedStatement sql = Conexion.conectar().prepareStatement(consulta);
                 

                     sql.setString(1, this.getNombreMarca());
                     sql.executeUpdate();

                     System.out.println(this.getClass().getSimpleName()+" Insertado correctamente");


                } catch (SQLException error) {

                    System.err.println("Error al insertar - "+this.getClass().getSimpleName()+":"+error.getMessage());
                }

        }
    
         // Modificar
        public void modificar(){
            
            
           String consulta = " UPDATE "+this.getClass().getSimpleName()+" SET nombreMarca =?  WHERE idMarcaProducto=?"; 
           
           try {
               PreparedStatement sql = Conexion.conectar().prepareStatement(consulta);
              
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
               String consulta = " DELETE FROM "+this.getClass().getSimpleName()+" WHERE idMarcaProducto=?";
               PreparedStatement sql= Conexion.conectar().prepareStatement(consulta);
               
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
               
               
               PreparedStatement sql= Conexion.conectar().prepareStatement
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
          
//           public MarcaProducto buscarPorId (int elId){
//       
//           MarcaProducto unaMarca = new MarcaProducto();
//           unaMarca.setNombreMarca(" la Marca no existe");
//           
//           try {
//               
//               PreparedStatement sql = ConexionBD.conexion.prepareStatement(
//                       " SELECT * FROM "+this.getClass().getSimpleName()+" WHERE idMarcaProducto = ?");
//               
//               sql.setInt(1, elId);
//               
//               ResultSet rs = sql.executeQuery();
//               
//               
//               while(rs.next()){
//                   
//                   unaMarca = new MarcaProducto();
//                   unaMarca.setIdMarcaProducto(rs.getInt ("idMarcaProducto"));
//                   unaMarca.setNombreMarca(rs.getString("nombreMarca"));
//               }
//               
//           } catch (SQLException error) {
//               
//               System.err.println(" Error al buscar por id : "+error.getMessage());
//           }
//           return unaMarca;
//        }
          
          
          
}
