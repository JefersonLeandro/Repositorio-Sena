/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.MarcaProducto;
import modelo.TipoPersona;

/**
 *
 * @author ADMON
 */
public class controladorTipoPersona {
    
     public void controlarAccion (ActionEvent evento, TipoPersona unTipoPersona){
         
         System.out.println("lleguen al encabezado del controlador Marca");
     
        String accion = evento.getActionCommand();
        
    
        switch (accion) {
            case "Insertar": //337D600
                unTipoPersona.insertar();
                System.out.println("Dentre a la opcion llamar metodoInsertar");
                break;
            case "Modificar":
                unTipoPersona.modificar();
                System.out.println(" llegue a la opcion Modificar del controlador de la TipoPersona ");
                break;
                
            case "Eliminar":
                unTipoPersona.eliminar();
                System.out.println(" llegue a la opcion Eliminar del controlador de la TipoPersona ");
                break;
        }
     }
    
}
