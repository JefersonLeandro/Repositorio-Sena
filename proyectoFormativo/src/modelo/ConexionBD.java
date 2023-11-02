/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMON
 */
public class ConexionBD {

    public static Connection conexion;

    private ConexionBD() {
        System.out.println(" llegue al encabezado de la conexion  ");

        try {

            String driverBD = "com.mysql.cj.jdbc.Driver";
            String urlBD = "jdbc:mysql://localhost/proyectoformativof";
            String usuarioBD = "root";
            String claveBD = "";
            Class.forName(driverBD);

            conexion = DriverManager.getConnection(urlBD, usuarioBD, claveBD);

            System.out.println("Se establecio la conexion");

            //-------Verificacion de la conexion 
            if (conexion.isValid(5)) {
                System.out.println("La conexión sigue siendo válida");
            } else {
                System.out.println("La conexión ya no es válida");
            }

        } catch (ClassNotFoundException error) {

            System.err.println("No se encontro el driver: " + error.getMessage());

        } catch (SQLException error) {
            System.err.println("Error al conectar: " + error.getMessage());
        }

    }

    public static void desconectar() {

        try {
            conexion.close();

        } catch (SQLException error) {

            System.err.println("Error al desconectar: " + error.getMessage());
        }
    }

    public static ConexionBD getInstance() {
        return ConexHolder.INSTANCE;
    }

    private static class ConexHolder {

        private static final ConexionBD INSTANCE = new ConexionBD();
    }
}
