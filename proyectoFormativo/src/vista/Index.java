
package vista;

import javax.swing.*;
import java.awt.*;

import com.sun.source.tree.SwitchTree;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;import java.sql.SQLException;
import java.sql.ResultSet;

import java.awt.Font;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.ConexionBD;
import static vista.CrearCuenta.comprobar;

//import static vista.index.panelPrincipal;

/**
 *
 * @author ADMON
 */
public class Index extends javax.swing.JFrame {
    
     //objetos globales
     JLabel mensaje;
     CrearCuenta crearCuenta;
     public static Registro unRegistro;
     
     
     // variables globles del metodo traer datos 
     
//          idProducto, nombreProducto, descripcionUnidad, precioProducto , nombreImagen
    private int idProducto;
    private String nombreProducto;
    private String descripcionUnidad;
    private int precioProducto;
    private String nombreImagen;
    
    
    /**
     * Creates new form Principal
     */
    public Index(){
        ConexionBD.getInstance();
        initComponents();
        cargarMetodos();
    }
    
    private void cargarMetodos () {
         
         agregarImgs();
         eventosEscucha();
         funcionesExtrasC();
//         traerProductosBd();
    }
     
    private void abrirVentanaRegistro(){
        
        unRegistro = new Registro();
        panelGeneral.add(unRegistro);
        unRegistro.setVisible(true);
        panelSecundario.setVisible(false);
    }

      private void agregarImgs(){
//            
//        //logo 
           ImageIcon importarImg = (new ImageIcon("imgs/logoQ1.png"));
           JLabel logoImg =new JLabel();
           logoImg.setIcon(new ImageIcon(importarImg.getImage().getScaledInstance(60,60, Image.SCALE_SMOOTH)));
           logoImg.setBounds(120,15,68,68);
           panelSecundario.add(logoImg);
           panelSecundario.setComponentZOrder(logoImg, 0); // orden de apilamiento o por decirlo asi el z-index en desarrollo web
            
          //iconoRegistro 
           ImageIcon importarIcono = (new ImageIcon("imgs/registro.png"));
           JLabel registroImg =new JLabel();
           registroImg.setIcon(new ImageIcon(importarIcono.getImage().getScaledInstance(45,40, Image.SCALE_SMOOTH)));
           registroImg.setBounds(1400,7,50,45);
           registroImg.setCursor( new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR){});
           panelSecundario.add(registroImg);
           panelSecundario.setComponentZOrder(registroImg, 0); //// orden de apilamiento o por decirlo asi el z-index en desarrollo web

           
           //eventos de escucha de la imagen registro 
            registroImg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirVentanaRegistro();
            }
            });
            
           // 
           ImageIcon importarIconoB = (new ImageIcon("imgs/buscar.png"));
           JLabel buscarImg =new JLabel();
           buscarImg.setIcon(new ImageIcon(importarIconoB.getImage().getScaledInstance(23,23, Image.SCALE_SMOOTH)));
           buscarImg.setBounds(1469,80,50,45);
           panelSecundario.add(buscarImg);
           panelSecundario.setComponentZOrder(buscarImg, 0); /// orden de apilamiento o por decirlo asi el z-index en desarrollo web
          
          
//            //codigo para otro lado 
       
     }
      
       private void eventosEscucha(){
         
         //Jlabel con actions 
     
        mensaje = new JLabel(); // mensaje con actionListener escuchador de eventos
        mensaje.setBounds(300,130, 400, 50);
        mensaje.setFont( new Font("Arial",Font.BOLD,20));
        mensaje.setForeground(Color.white);
     
         
//         panelPrincipal.add(mensaje);
         
          ActionListener escuchadorE =new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
            MouseListener escuchadorMouse =new MouseListener() {
                
            @Override
            public void mouseClicked(MouseEvent e) {
                areaTexto.setText(" Evento activo :  mouseClicked  ");
                System.out.println("clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                areaTexto.setText(" Evento activo :  mousePressed  ");
                System.out.println("pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               areaTexto.setText(" Evento activo :  mouseReleased ");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               areaTexto.setText(" Evento activo :  mouseEntered ");
//               mBtn.setOpaque(true);
//               mBtn.setBackground(Color.darkGray);
              
            }

            @Override
            public void mouseExited(MouseEvent e) {


                System.out.println("evento exited ");
//                areaTexto.setText("\n Evento activo :  Exited ");
                areaTexto.setText(" "+areaTexto.getText()+" \nEvento activo :  Exited");
              
            } 
        };
        
        btn.addActionListener(escuchadorE);    
        btn.addMouseListener(escuchadorMouse);

     }
       private boolean bandera ;
       private void funcionesExtrasC(){
           
            setLocationRelativeTo(null); // es para pocisionar la ventana en centro.
            setMinimumSize(new Dimension(200,200)); // tamano minimo de la ventana al ajustarla
//          this.setSize(900, 800);
            this.setBounds(300, 70, 1000 , 750);
            bandera = true;
            Registro unRegistro = new Registro();
            String nombreP = unRegistro.getNombrePersona();
            System.out.println(nombreP+"--");
            System.out.println("--"+vRegistro.getBounds()+"--");
            System.out.println(comprobar+"&&");
       }

    
       
     
       private void  llenarSeccionProducto(){
           
           
           System.out.println("dentre a la funcion llenarSeccionProducto");
           
           ImageIcon importarIcono = (new ImageIcon("imgs/"+nombreImagen));
           JLabel imagenBD =new JLabel();
           imagenBD.setIcon(new ImageIcon(importarIcono.getImage().getScaledInstance(23,23, Image.SCALE_SMOOTH)));
           imagenBD.setBounds(1469,80,50,45);
//           cuadroImg1.add(imagenBD);
       
       
       
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        panelSecundario = new javax.swing.JPanel();
        menuP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        vFavoritos = new javax.swing.JLabel();
        vCarrito = new javax.swing.JLabel();
        vServicios = new javax.swing.JLabel();
        vDestacados = new javax.swing.JLabel();
        vSuperOfertas = new javax.swing.JLabel();
        vEnviarRegalo = new javax.swing.JLabel();
        vMetodosPago = new javax.swing.JLabel();
        vCatalogo = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        vRegistro = new javax.swing.JLabel();
        vFavoritos1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        btn = new javax.swing.JButton();
        vCajaNombre = new javax.swing.JLabel();
        vCarrito1 = new javax.swing.JLabel();
        vCarrito2 = new javax.swing.JLabel();
        vCarrito3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 51));

        panelGeneral.setBackground(new java.awt.Color(255, 255, 255));

        panelSecundario.setBackground(new java.awt.Color(255, 255, 255));

        menuP.setBackground(new java.awt.Color(55, 146, 232));

        jLabel1.setFont(new java.awt.Font("PT Sans Narrow", 1, 65)); // NOI18N
        jLabel1.setText("Farmacit");

        vFavoritos.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vFavoritos.setForeground(new java.awt.Color(255, 255, 255));
        vFavoritos.setText("Favoritos");
        vFavoritos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vFavoritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vFavoritosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vFavoritosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vFavoritosMouseExited(evt);
            }
        });

        vCarrito.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vCarrito.setForeground(new java.awt.Color(255, 255, 255));
        vCarrito.setText("Carrito");
        vCarrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vCarritoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vCarritoMouseExited(evt);
            }
        });

        vServicios.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vServicios.setForeground(new java.awt.Color(255, 255, 255));
        vServicios.setText("Servicios");
        vServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vServiciosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vServiciosMouseExited(evt);
            }
        });

        vDestacados.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vDestacados.setForeground(new java.awt.Color(255, 255, 255));
        vDestacados.setText("destacados");
        vDestacados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vDestacados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vDestacadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vDestacadosMouseExited(evt);
            }
        });

        vSuperOfertas.setFont(new java.awt.Font("PT Sans Narrow", 0, 19)); // NOI18N
        vSuperOfertas.setText("Super ofertas");
        vSuperOfertas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vSuperOfertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vSuperOfertasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vSuperOfertasMouseExited(evt);
            }
        });

        vEnviarRegalo.setFont(new java.awt.Font("PT Sans Narrow", 0, 19)); // NOI18N
        vEnviarRegalo.setText("Enviar Regalo");
        vEnviarRegalo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vEnviarRegalo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vEnviarRegaloMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vEnviarRegaloMouseExited(evt);
            }
        });

        vMetodosPago.setFont(new java.awt.Font("PT Sans Narrow", 0, 19)); // NOI18N
        vMetodosPago.setText("Metodos de pago ");
        vMetodosPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vMetodosPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vMetodosPagoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vMetodosPagoMouseExited(evt);
            }
        });

        vCatalogo.setFont(new java.awt.Font("PT Sans Narrow", 0, 19)); // NOI18N
        vCatalogo.setText("Catalogo");
        vCatalogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vCatalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vCatalogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vCatalogoMouseExited(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("PT Sans Narrow", 0, 14)); // NOI18N
        jTextField2.setText("  buscar un producto ");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        vRegistro.setFont(new java.awt.Font("PT Sans Narrow", 0, 19)); // NOI18N
        vRegistro.setText("Registro");
        vRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vRegistroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vRegistroMouseExited(evt);
            }
        });

        javax.swing.GroupLayout menuPLayout = new javax.swing.GroupLayout(menuP);
        menuP.setLayout(menuPLayout);
        menuPLayout.setHorizontalGroup(
            menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPLayout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203)
                .addGroup(menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPLayout.createSequentialGroup()
                        .addComponent(vSuperOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPLayout.createSequentialGroup()
                        .addComponent(vFavoritos)
                        .addGap(26, 26, 26)))
                .addGroup(menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(vCarrito)
                        .addGap(18, 18, 18)
                        .addComponent(vServicios)
                        .addGap(31, 31, 31)
                        .addComponent(vDestacados))
                    .addGroup(menuPLayout.createSequentialGroup()
                        .addComponent(vEnviarRegalo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vMetodosPago, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
                .addGroup(menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPLayout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPLayout.createSequentialGroup()
                        .addComponent(vRegistro)
                        .addGap(133, 133, 133))))
        );
        menuPLayout.setVerticalGroup(
            menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(vRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPLayout.createSequentialGroup()
                        .addGroup(menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuPLayout.createSequentialGroup()
                                .addGroup(menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vFavoritos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(vServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vDestacados, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(menuPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(vSuperOfertas)
                                    .addComponent(vEnviarRegalo)
                                    .addComponent(vMetodosPago)
                                    .addComponent(vCatalogo)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );

        vFavoritos1.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vFavoritos1.setText("Eventos");
        vFavoritos1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vFavoritos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vFavoritos1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vFavoritos1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vFavoritos1MouseExited(evt);
            }
        });

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        btn.setText("Aqui");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        vCajaNombre.setFont(new java.awt.Font("PT Sans Narrow", 0, 19)); // NOI18N
        vCajaNombre.setText(" ");
        vCajaNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vCajaNombre.setEnabled(false);
        vCajaNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vCajaNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vCajaNombreMouseExited(evt);
            }
        });

        vCarrito1.setBackground(new java.awt.Color(255, 255, 255));
        vCarrito1.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vCarrito1.setText("0000");
        vCarrito1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vCarrito1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vCarrito1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vCarrito1MouseExited(evt);
            }
        });

        vCarrito2.setBackground(new java.awt.Color(255, 255, 255));
        vCarrito2.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vCarrito2.setText("CUENTA DE ADMINISTRACION");
        vCarrito2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vCarrito2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vCarrito2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vCarrito2MouseExited(evt);
            }
        });

        vCarrito3.setBackground(new java.awt.Color(255, 255, 255));
        vCarrito3.setFont(new java.awt.Font("PT Sans Narrow", 0, 24)); // NOI18N
        vCarrito3.setText("admin@gmail.com");
        vCarrito3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vCarrito3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vCarrito3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vCarrito3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelSecundarioLayout = new javax.swing.GroupLayout(panelSecundario);
        panelSecundario.setLayout(panelSecundarioLayout);
        panelSecundarioLayout.setHorizontalGroup(
            panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSecundarioLayout.createSequentialGroup()
                .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSecundarioLayout.createSequentialGroup()
                                .addGap(679, 679, 679)
                                .addComponent(vFavoritos1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelSecundarioLayout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(vCarrito1)
                                .addGap(222, 222, 222)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSecundarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vCajaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
            .addGroup(panelSecundarioLayout.createSequentialGroup()
                .addGap(680, 680, 680)
                .addComponent(btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSecundarioLayout.createSequentialGroup()
                    .addGap(257, 257, 257)
                    .addComponent(vCarrito2)
                    .addContainerGap(1189, Short.MAX_VALUE)))
            .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSecundarioLayout.createSequentialGroup()
                    .addGap(294, 294, 294)
                    .addComponent(vCarrito3)
                    .addContainerGap(1248, Short.MAX_VALUE)))
        );
        panelSecundarioLayout.setVerticalGroup(
            panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSecundarioLayout.createSequentialGroup()
                .addComponent(menuP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151)
                .addComponent(vCajaNombre)
                .addGap(55, 55, 55)
                .addComponent(vFavoritos1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSecundarioLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(vCarrito1)))
                .addGap(18, 18, 18)
                .addComponent(btn)
                .addContainerGap(788, Short.MAX_VALUE))
            .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSecundarioLayout.createSequentialGroup()
                    .addGap(327, 327, 327)
                    .addComponent(vCarrito2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(961, Short.MAX_VALUE)))
            .addGroup(panelSecundarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelSecundarioLayout.createSequentialGroup()
                    .addGap(380, 380, 380)
                    .addComponent(vCarrito3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(908, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSecundario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addComponent(panelSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vFavoritos1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vFavoritos1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_vFavoritos1MouseExited

    private void vFavoritos1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vFavoritos1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_vFavoritos1MouseEntered

    private void vFavoritos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vFavoritos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_vFavoritos1MouseClicked

    private void vCatalogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCatalogoMouseExited
        // TODO add your handling code here:
        vCatalogo.setForeground(Color.black);
    }//GEN-LAST:event_vCatalogoMouseExited

    private void vCatalogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCatalogoMouseEntered
        // TODO add your handling code here:
        vCatalogo.setForeground(Color.white);
    }//GEN-LAST:event_vCatalogoMouseEntered

    private void vMetodosPagoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vMetodosPagoMouseExited
        // TODO add your handling code here:
        vMetodosPago.setForeground(Color.black);
    }//GEN-LAST:event_vMetodosPagoMouseExited

    private void vMetodosPagoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vMetodosPagoMouseEntered
        // TODO add your handling code here:
        vMetodosPago.setForeground(Color.white);
    }//GEN-LAST:event_vMetodosPagoMouseEntered

    private void vEnviarRegaloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vEnviarRegaloMouseExited
        // TODO add your handling code here:
        vEnviarRegalo.setForeground(Color.black);
    }//GEN-LAST:event_vEnviarRegaloMouseExited

    private void vEnviarRegaloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vEnviarRegaloMouseEntered
        // TODO add your handling code here:
        vEnviarRegalo.setForeground(Color.white);
    }//GEN-LAST:event_vEnviarRegaloMouseEntered

    private void vSuperOfertasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vSuperOfertasMouseExited
        // TODO add your handling code here:
        vSuperOfertas.setForeground(Color.black);
    }//GEN-LAST:event_vSuperOfertasMouseExited

    private void vSuperOfertasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vSuperOfertasMouseEntered
        // TODO add your handling code here:
        vSuperOfertas.setForeground(Color.white);
    }//GEN-LAST:event_vSuperOfertasMouseEntered

    private void vDestacadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vDestacadosMouseExited
        // TODO add your handling code here:
        vDestacados.setForeground(Color.white);
    }//GEN-LAST:event_vDestacadosMouseExited

    private void vDestacadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vDestacadosMouseEntered
        // TODO add your handling code here:
        vDestacados.setForeground(Color.black);
    }//GEN-LAST:event_vDestacadosMouseEntered

    private void vServiciosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vServiciosMouseExited
        // TODO add your handling code here:
        vServicios.setForeground(Color.white);
    }//GEN-LAST:event_vServiciosMouseExited

    private void vServiciosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vServiciosMouseEntered
        // TODO add your handling code here:
        vServicios.setForeground(Color.black);
    }//GEN-LAST:event_vServiciosMouseEntered

    private void vCarritoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCarritoMouseExited
        // TODO add your handling code here:

        vCarrito.setForeground(Color.white);
    }//GEN-LAST:event_vCarritoMouseExited

    private void vCarritoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCarritoMouseEntered
        // TODO add your handling code here:
        vCarrito.setForeground(Color.black);
    }//GEN-LAST:event_vCarritoMouseEntered

    private void vFavoritosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vFavoritosMouseExited
        // TODO add your handling code here:
        vFavoritos.setForeground(Color.white);
    }//GEN-LAST:event_vFavoritosMouseExited

    private void vFavoritosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vFavoritosMouseEntered
        // TODO add your handling code here:
        vFavoritos.setForeground(Color.black);
    }//GEN-LAST:event_vFavoritosMouseEntered

    private void vFavoritosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vFavoritosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_vFavoritosMouseClicked

    private void vCajaNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCajaNombreMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_vCajaNombreMouseEntered

    private void vCajaNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCajaNombreMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_vCajaNombreMouseExited

    private void vRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vRegistroMouseEntered
        vRegistro.setForeground(Color.WHITE);
    }//GEN-LAST:event_vRegistroMouseEntered

    private void vRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vRegistroMouseExited
        vRegistro.setForeground(Color.BLACK);
    }//GEN-LAST:event_vRegistroMouseExited

    private void vRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vRegistroMouseClicked

       abrirVentanaRegistro();
    }//GEN-LAST:event_vRegistroMouseClicked

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnActionPerformed

    private void vCarrito1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCarrito1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_vCarrito1MouseEntered

    private void vCarrito1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCarrito1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_vCarrito1MouseExited

    private void vCarrito2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCarrito2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_vCarrito2MouseEntered

    private void vCarrito2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCarrito2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_vCarrito2MouseExited

    private void vCarrito3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCarrito3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_vCarrito3MouseEntered

    private void vCarrito3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vCarrito3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_vCarrito3MouseExited
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JPanel menuP;
    public static javax.swing.JPanel panelGeneral;
    public static javax.swing.JPanel panelSecundario;
    public static javax.swing.JLabel vCajaNombre;
    private javax.swing.JLabel vCarrito;
    private javax.swing.JLabel vCarrito1;
    private javax.swing.JLabel vCarrito2;
    private javax.swing.JLabel vCarrito3;
    private javax.swing.JLabel vCatalogo;
    private javax.swing.JLabel vDestacados;
    private javax.swing.JLabel vEnviarRegalo;
    private javax.swing.JLabel vFavoritos;
    private javax.swing.JLabel vFavoritos1;
    private javax.swing.JLabel vMetodosPago;
    public static javax.swing.JLabel vRegistro;
    private javax.swing.JLabel vServicios;
    private javax.swing.JLabel vSuperOfertas;
    // End of variables declaration//GEN-END:variables

}
