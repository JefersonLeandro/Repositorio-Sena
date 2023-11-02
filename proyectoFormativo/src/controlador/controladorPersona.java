/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Persona;

/**
 *
 * @author ADMON
 */
public class controladorPersona {
    
   
     
    public void controlarAccion (ActionEvent evento, Persona unaPersona){
        
        System.out.println("llegue al encabezado del controlador-");
        //  cambiarle el nombre aca el insertar que es Registrar
        String accion = evento.getActionCommand();
        
        System.out.println("===="+accion+"=====");
        
        switch (accion) {
            case "Registrar":
                unaPersona.insertar();
                System.out.println("llegue a la opcion Registrar");
                break;
            case "Modificar":
                unaPersona.modificar();
                break;
                
            case "Eliminar":
                unaPersona.eliminar();
                break;
           
        }
        
        
        
        
    
    }
    
    
    
    
}
