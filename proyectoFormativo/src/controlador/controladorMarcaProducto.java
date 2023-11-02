/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.MarcaProducto;


/**
 *
 * @author ADMON
 */
public class controladorMarcaProducto {
    
     public void controlarAccion (ActionEvent evento, MarcaProducto unaMarca){
         
         System.out.println("lleguen al encabezado del controlador Marca");
     
        String accion = evento.getActionCommand();
        
    
        switch (accion) {
            case "Insertar": //337D600
                unaMarca.insertar();
                System.out.println("Dentre a la opcion llamar metodoInsertar");
                break;
            case "Modificar":
                unaMarca.modificar();
                System.out.println(" llegue a la opcion Modificar del controlador de la marca ");
                break;
                
            case "Eliminar":
                unaMarca.eliminar();
                System.out.println(" llegue a la opcion Eliminar del controlador de la farmacia ");

                break;
           
        }
    }
    
    
    
    
    
}
