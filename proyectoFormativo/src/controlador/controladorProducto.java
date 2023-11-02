/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Producto;

/**
 *
 * @author ADMON
 */
public class controladorProducto {
    
    public void controlarAccion (ActionEvent evento, Producto unProducto){
         
         System.out.println("lleguen al encabezado del controlador FARMACIA");
     
        String accion = evento.getActionCommand();
        
        switch (accion) {
            case "Insertar": 
                unProducto.insertar();
                System.out.println("Dentre a la opcion llamar metodo Inserta Producto ");
                break;
            case "Modificar":
                unProducto.modificar();
                System.out.println(" llegue a la opcion Modificar del controlador de Producto ");
                break;
                
            case "Eliminar":
                unProducto.eliminar();
                System.out.println(" llegue a la opcion Eliminar del controlador producto ");
                break;
           
        }
    }
}
