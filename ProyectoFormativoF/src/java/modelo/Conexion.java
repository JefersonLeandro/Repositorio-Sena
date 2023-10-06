/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ADMON
 */
public class Conexion {
    
     // se establecio la conexion de manera para trabajar de la manera mas recomendable ya que no estaria bien trabajar con statemento o preparedSTAMENT
    // Declarar la conexión como estática
    
    protected static Connection conexion = null;// se deja protected para que siga respectando la integridad de la conexion pero pueda ser accible dentro de los archivos que esten en el mismo paquete 

    public static Connection conectar() {
        
        if (conexion == null) {
            try {
                
                Context ctx = new InitialContext();
                DataSource ds = (DataSource) ctx.lookup("jdbc/proyectoFormativo");
                conexion = ds.getConnection("Jeferson", "1234");
                
                
                
            } catch (NamingException | SQLException error) {
                System.err.println("Error al iniciar la conexión: " + error.getMessage());
            }
        }
        return conexion;
    }

    public static void desconectar() {
        try {
            
            if (conexion != null) {
                conexion.close();
                conexion = null;
            }
            
        } catch (SQLException error) {
            System.err.println("Error al cerrar la conexión: " + error.getLocalizedMessage());
        }
    }
    
}
