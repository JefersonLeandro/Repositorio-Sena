/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.controladorPersona;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import modelo.ConexionBD;
import modelo.Persona;
import static vista.Index.panelSecundario;
import org.mindrot.jbcrypt.BCrypt;// libreria para Encriptar
/**
 *
 * @author ADMON
 */
public class CrearCuenta extends javax.swing.JInternalFrame {

    /**
     * Creates new form prueba
     */
    public CrearCuenta() {
        initComponents();
        cargarMetodos();
        
    }

    controladorPersona personaControlador = new controladorPersona();
    
    
    //variables globales 
     public static boolean comprobar;
     private String contrasenaEncriptada;
    
     
      private void cargarMetodos(){
//            eventosEscucha();
            funcionesExtras();
            imgsCrearCuenta();
//            limpiarFormulario(); 
     }
      
     private void funcionesExtras(){
     
        this.setBounds(550, 70,this.getWidth(),this.getHeight());
     
        txtIdPersona.setValue(0);
        txtIdPersona.setVisible(false);
        
         System.out.println(this.getBounds()+" ESTE EL BOUNDS");
        
         System.out.println("-00-"+this.getWidth()+"---"+this.getHeight());
     }
    
     private void imgsCrearCuenta(){
        
        //logo 
           ImageIcon importarImg = (new ImageIcon("imgs/logoQ1.png"));
           JLabel logoImg = new JLabel();
           logoImg.setIcon(new ImageIcon(importarImg.getImage().getScaledInstance(60,60, Image.SCALE_SMOOTH)));
           logoImg.setBounds(125,23,68,68);
           menuCrearCuenta.add(logoImg);
           panelG.setComponentZOrder(logoImg, 0);
    }
       
       
    private void limpiarFormulario(){
    
        txtIdPersona.setValue(0);
        txtNombre.setText("Escriba el nombre");
        txtApellido.setText("Su apellido documento");
        txtIdentificacion.setText("Su Documento");
        txtTelefono.setText("Su numero Telefonico");
        txtCorreo.setText("Su correo ");
        txtContrasena.setText("Su contrasena");
        txtCContrasena.setText("Confirmar contrasena");

      
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        panelG = new javax.swing.JPanel();
        menuCrearCuenta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        vDatosInvalidos = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        txtCContrasena = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        txtIdPersona = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        vApellido = new javax.swing.JLabel();
        vCContrasena = new javax.swing.JLabel();
        vTelefono = new javax.swing.JLabel();
        vContrasena = new javax.swing.JLabel();
        vIdentificacion = new javax.swing.JLabel();
        vCorreo = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panelG.setBackground(new java.awt.Color(255, 255, 255));

        menuCrearCuenta.setBackground(new java.awt.Color(55, 146, 232));

        jLabel1.setFont(new java.awt.Font("PT Sans Narrow", 0, 65)); // NOI18N
        jLabel1.setText("Farmacit");

        javax.swing.GroupLayout menuCrearCuentaLayout = new javax.swing.GroupLayout(menuCrearCuenta);
        menuCrearCuenta.setLayout(menuCrearCuentaLayout);
        menuCrearCuentaLayout.setHorizontalGroup(
            menuCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuCrearCuentaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        menuCrearCuentaLayout.setVerticalGroup(
            menuCrearCuentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuCrearCuentaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        txtNombre.setText("  Sus nombres");
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.setText("  Sus apellidos");
        txtApellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        vDatosInvalidos.setBackground(new java.awt.Color(255, 255, 255));
        vDatosInvalidos.setFont(new java.awt.Font("PT Sans Narrow", 0, 19)); // NOI18N
        vDatosInvalidos.setForeground(new java.awt.Color(249, 17, 17));
        vDatosInvalidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        vDatosInvalidos.setEnabled(false);
        vDatosInvalidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vDatosInvalidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vDatosInvalidosMouseExited(evt);
            }
        });

        txtIdentificacion.setText("  Su identificacion");
        txtIdentificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCorreo.setText("  Su Correo");
        txtCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        txtTelefono.setText("  Su Telefono");
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtContrasena.setText("  Su Contraseña");
        txtContrasena.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });

        txtCContrasena.setText("  contraseña");
        txtCContrasena.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCContrasenaActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(0, 102, 255));
        btnRegistrar.setFont(new java.awt.Font("PT Sans Narrow", 0, 20)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setName("Registrar"); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        txtIdPersona.setFont(new java.awt.Font("PT Sans Narrow", 0, 14)); // NOI18N
        txtIdPersona.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        jLabel6.setText("Nombre");

        vApellido.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vApellido.setText("Apellido");

        vCContrasena.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vCContrasena.setText("Confirmar");

        vTelefono.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vTelefono.setText("Telefono");

        vContrasena.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vContrasena.setText("Contraseña");

        vIdentificacion.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vIdentificacion.setText("Identificacion");

        vCorreo.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vCorreo.setText("Correo");

        javax.swing.GroupLayout panelGLayout = new javax.swing.GroupLayout(panelG);
        panelG.setLayout(panelGLayout);
        panelGLayout.setHorizontalGroup(
            panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuCrearCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGLayout.createSequentialGroup()
                .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGLayout.createSequentialGroup()
                        .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelGLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(vContrasena)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)))
                        .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelGLayout.createSequentialGroup()
                                    .addComponent(vIdentificacion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelGLayout.createSequentialGroup()
                                    .addComponent(vCorreo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelGLayout.createSequentialGroup()
                                    .addComponent(vTelefono)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelGLayout.createSequentialGroup()
                                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(vCContrasena)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelGLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(vApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(204, 204, 204))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGLayout.createSequentialGroup()
                .addGap(20, 140, Short.MAX_VALUE)
                .addComponent(vDatosInvalidos, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        panelGLayout.setVerticalGroup(
            panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGLayout.createSequentialGroup()
                .addComponent(menuCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(vDatosInvalidos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(panelGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vCContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnRegistrar)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        
         panelSecundario.setVisible(true);
    }//GEN-LAST:event_formInternalFrameClosed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        personaControlador.controlarAccion(evt, obtenerPersona());
        limpiarFormulario();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCContrasenaActionPerformed

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void vDatosInvalidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vDatosInvalidosMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_vDatosInvalidosMouseExited

    private void vDatosInvalidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vDatosInvalidosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_vDatosInvalidosMouseEntered

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed
//     
     
    @SuppressWarnings("empty-statement")
      private Persona obtenerPersona() {
          
//          System.out.println(txtNombre.getText()+"--txtNombre");
//          
//          Object [] vector  = {txtNombre.getText(),txtApellido.getText(),txtIdentificacion.getText(),txtTelefono.getText(),txtCorreo.getText()}; 
//          
////            [  Su nombres]
////            [  Sus nombres]
////            [  Su apellidos]
////            [  Su identificacion]
////            [  Su Telefono]
////            [  Su Correo]
////          
//
//    boolean probar = false;
//    
//        for (int i = 0; i < vector.length; i++) {
//            
//            if (vector[i].equals("  Sus nombres")||vector[i]=="  Sus apellidos"||vector[i]=="  Su identificacion"|| vector[i]=="  Su Telefono"||vector[i]=="  Su Correo") {
//               probar=true;
//                System.out.println("hay uno que es igual ");
//            }
//            System.out.println("["+vector[i]+"]");
//            
//        }
//        System.out.println(probar+"--: probar ");

//        if (probar) {} aca preguntarle al cucho que cual es mejor, si quiere 


        if ((txtNombre.getText().equals("  Sus nombres")) || ("".equals(txtNombre.getText())) || (txtApellido.getText().equals("  Sus apellidos")) || ("".equals(txtApellido.getText()))
            ||txtIdentificacion.getText().equals("  Su identificacion")|| ("".equals(txtIdentificacion.getText()))|| txtTelefono.getText().equals("  Su Telefono")|| ("".equals(txtTelefono.getText()))
               ||txtCorreo.getText().equals("  Su Correo") || ("".equals(txtCorreo.getText()))|| txtContrasena.getText().equals("  Su Contraseña")|| ("".equals(txtContrasena.getText()))|| txtCContrasena.getText().equals("  contraseña")|| ("".equals(txtCContrasena.getText()))) {
            
          vDatosInvalidos.setEnabled(true);
          vDatosInvalidos.setText("Rellene todos los campos");
          vDatosInvalidos.setHorizontalAlignment(SwingConstants.CENTER); 
          
        }else{
            
            //        combracion de igualdad CONTRASENAS

                String Contrasena1 = txtContrasena.getText();
                String Contrasena2 = txtCContrasena.getText();
        
        
            if (Contrasena1.equals(Contrasena2)) {

                System.out.println("la contrasenas son iguales ");
                
                
                //Encriptamiento con la consulta SELECT SHA2("texto a encriptar",256);"
                try {
                    //ENCRIPTAMIENTO DE LA CONTRASENA 
                    
                        // De esta manera sirve 
                        
       //               String ConsultaContrasena = " SELECT SHA2('"+Contrasena1+"',256);"; diractamente pero sin seguridad
//                        String ConsultaContrasena1 = " SELECT SHA2(?,256);";
//
//                        PreparedStatement sentenciaSQLC = ConexionBD.conexion.prepareStatement(ConsultaContrasena1);
//
//                        sentenciaSQLC.setString(1, Contrasena1);
//                        ResultSet resultadoEncriptado = sentenciaSQLC.executeQuery();
//                        
//                        
//
//                    if (resultadoEncriptado.next()) {
//                        contrasenaEncriptada = resultadoEncriptado.getString("SHA2('"+Contrasena1+"',256)"); 
//                        System.out.println("Esta es la contrasena Encriptadaaaaa "+contrasenaEncriptada);
//                    }else{
//                        System.err.println("El resultSet no devolvio ningun Resultado");
//                    }
                    
                        //Segunda parte de encriptamiento 
//                        String plainPassword = ; // La contraseña en texto claro que deseas encriptar
        
                        // Genera un hash seguro de la contraseña utilizando BCrypt
                        contrasenaEncriptada = BCrypt.hashpw(Contrasena1, BCrypt.gensalt());// se le pasa una variable la contrsena encriptada teniendo encuenta el metodo que le esta encriptando tiniendo en cuenta que se le esta agregado sal o salting

                        System.out.println("Contraseña en texto claro: " + Contrasena1);
                        System.out.println("Contraseña encriptadaAAAAA: " + contrasenaEncriptada);// esta es la forma mas recomendable para encriptar la contrasena
   
                } catch (Exception e) {
                    
                    System.err.println("Error al encriptar la contrasena : "+e);
                }
                

                    Persona laPersona = new Persona();

                    laPersona.setIdPersona((Integer) txtIdPersona.getValue());
                    laPersona.setNombrePersona(txtNombre.getText());
                    laPersona.setApellidoPersona(txtApellido.getText());
                    laPersona.setIdentificacionPersona(txtIdentificacion.getText());
                    laPersona.setTelefonoPersona(txtTelefono.getText());
                    laPersona.setCorreoPersona(txtCorreo.getText());
                    laPersona.setContrasenaPersona(contrasenaEncriptada);


              // aca faltaria el idTipo persona pero no importa porque ese ya esta definido en la consulta 
                System.out.println("llegue a la funcion obtenerPersona "); 
              // para poder abrir la ventana de registro despues de ingresar los datos en crear cuenta 
                comprobar=true;
                System.out.println(comprobar+"ww");
                return laPersona;

            }else{
                
              System.out.println("Datos no insertados -MTD: obtenerPersona ");
              vDatosInvalidos.setEnabled(true);
              vDatosInvalidos.setText("Las contraseñas ingresadas no son iguales");
               
              return null;
            }   
        }
        return null;
    }
//    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel menuCrearCuenta;
    private javax.swing.JPanel panelG;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCContrasena;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JSpinner txtIdPersona;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JLabel vApellido;
    private javax.swing.JLabel vCContrasena;
    private javax.swing.JLabel vContrasena;
    private javax.swing.JLabel vCorreo;
    private javax.swing.JLabel vDatosInvalidos;
    private javax.swing.JLabel vIdentificacion;
    private javax.swing.JLabel vTelefono;
    // End of variables declaration//GEN-END:variables
}
