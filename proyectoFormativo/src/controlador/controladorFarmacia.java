/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Farmacia;

/**
 *
 * @author ADMON
 */
public class controladorFarmacia {
    
     public void controlarAccion (ActionEvent evento, Farmacia unaFarmacia){
         
         System.out.println("lleguen al encabezado del controlador FARMACIA");
     
        String accion = evento.getActionCommand();
        
    
        switch (accion) {
            case "Insertar": //337D600
                unaFarmacia.insertar();
                System.out.println("Dentre a la opcion llamar metodoInsertar");
                break;
            case "Modificar":
                unaFarmacia.modificar();
                System.out.println(" llegue a la opcion Modificar del controlador de la farmacia ");
                break;
                
            case "Eliminar":
                unaFarmacia.eliminar();
                System.out.println(" llegue a la opcion Eliminar del controlador de la farmacia ");

                break;
           
        }
    }
    
}
