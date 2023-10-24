<%-- 
    Document   : Favoritos
    Created on : 24/10/2023, 8:36:11 a. m.
    Author     : ADMON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<?php
     session_start();
?>-->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla Productos deseados</title>

    <script src="../Jquery/jquery-3.6.4.min.js"></script>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <script src="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.js"></script>
    <link rel="stylesheet" href="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
    <link rel="stylesheet" href="Public/Fuentes/PtSansNarrow/PTSansNarrow-Regular.ttf">

</head>

    <jsp:useBean id="unProductoD" class="modelo.ProductoDeseado" scope="request" />

<body>
    
    

    <main>


    <div class="cerrarVentanaG">
         <div class="overLay">
                <div class="formVentana">
                    <div class="descripcionVentana">
                        <div class="descripcionVentanaS" >
<!--                            <?php
                                include_once("../modelo/conexion.php");
                                $objetoConexion = new conexion();
                                $conexion = $objetoConexion->conectar();

                                if (isset($_SESSION['id'])) {

                                    $consultaContar="SELECT COUNT(*) FROM productodeseado WHERE idPersona=$_SESSION[id];";
                                    $resultadoCantidadP= mysqli_query($conexion,$consultaContar);
                                    $miResultado = mysqli_fetch_assoc($resultadoCantidadP);
                                    $contador=$miResultado['COUNT(*)'];

                                    if ($contador==0) {

                                        echo"<p>No hay productos por eliminar</p>";
                                        echo"<strong>¿Deseas agregar?</strong>";
    
                                     }else{
                                        echo"<strong>¿Deseas eliminar todos los productos?</strong>";
                                     }
    

                                    
                                }else{
                                    
                                    echo"<p>No hay productos por eliminar</p>";
                                    echo"<strong>¿Deseas agregar?</strong>";

                                }
                                 
                            ?>-->
                            <c:set var="" value="" />                   
                            <c:if test="${not empty (sessionScope.idPersona)}">
                                
                                <!--implementar esta logica con un contador al momento de listar--> 
                                
                                
                                
                            </c:if>
                            
                        </div>
                        <div class="CerrarVentana" >
                            <a href="#" id="aCerrarPopup" class="aCerrarPopup">
                                <svg id="svgCerrar" xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor"
                                    class="bi bi-x" viewBox="0 0 16 16">
                                
                                    <path
                                        d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                                </svg>
                            </a>
                        </div>
                    </div>
                   
<!--                        <?php
                            //!isset($contador) || empty($contandor)
                            if (isset($_SESSION['id'])) {
                        
                                if ($contador==0) {
                                echo" <div class='ventanaBotones' >";
                                    echo"<button class='buttonVentana' id='cancelarBtn'>Cancelar</button>";
                                    echo"<button type'click' class='buttonVentana' onclick'direccionar()'  id='aceptarBtn1' >Aceptar</button>";
                                echo"</div>";

                                }else{

                                    echo "<form class='ventanaBotones'  action='../controlador/controladorProductoDeseado.php' method='post'>";
                                        echo"<button class='buttonVentana' id='cancelarBtn'>Cancelar</button>";
                                        echo"<button class='buttonVentana' id='aceptarBtn' name='eliminarTodo'  value='EliminarTodo'>Aceptar</button>";
                                    echo"</form>";

                                }
                            }else{

                                echo" <div class='ventanaBotones' >";
                                    echo"<button class='buttonVentana' id='cancelarBtn'>Cancelar</button>";
                                    echo"<button type'click' class='buttonVentana' onclick'direccionar()'  id='aceptarBtn1' >Aceptar</button>";
                                echo"</div>";



                            }-->
                        
                        
                        <!--?>-->

                    </div>
                </div>
            </div>
        </div>

        <div id="divTablaG">

            <div id="divTablaC">
                <div id="tituloTabla1">
                    <div id="iconoTabla">
                        <img src="Public/imgs/logoQ1.png" alt="logo" width="42px" height="42px">

                    </div>
                    <div>
                        <h1>Farmacit</h1>
                    </div>

                </div>
                <div id="divCentralTabla">
                    <div id="contenedorTrash">
                        <h4 id="soyh2">Productos deseados</h4>

                        <div id="contenedorSTrash">
                            <div class="contenedorSvg">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                                    id="svgTrash" class="bi bi-trash3" viewBox="0 0 16 16" >
                                    <path
                                        d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z" />
                                </svg>
                                <div class="lineaTrash"></div>

                            </div>
                        </div>
                    </div>

                    <div id="encajar">
                        <div id="listaP">
                            <div id="centrarLista">
                                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                                    class="bi bi-star-fill" viewBox="0 0 16 16">
                                    <path
                                        d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z" />
                                </svg>
                                <div class="lineaA1"></div>
                                <div id="encerrarLista">
                                    <ul class="list-group list-group-flush scrollable listaFavoritos" id="listaG">
<!--                                        <?php
                                       
                                       
                                        // $miConsultaProductos="SELECT p.nombreProducto, p.descripcionUnidad, p.descripcionProductoGeneral, p.precioProducto, p.imagenProducto ,d.idProductoD
                                        // FROM productodeseado d 
                                        // JOIN producto p ON d.idProducto = p.idProducto; ";
                                        if (isset($_SESSION['id'])) {
                                            $miConsultaProductos = "SELECT p.nombreProducto, p.descripcionUnidad, p.descripcionProductoGeneral, p.precioProducto, p.imagenProducto ,d.idProductoD FROM productodeseado d JOIN producto p ON d.idProducto = p.idProducto and idPersona=$_SESSION[id];";

                                            $resultado2 = mysqli_query($conexion, $miConsultaProductos);
                                            $filaL = mysqli_fetch_array($resultado2);

                                            $cont = 0;
                                            foreach ($resultado2 as $filaL) {

                                                echo "<a href='" . "#" . $filaL['idProductoD'] . "'>";
                                                echo "<li class='list-group-item' id='" . $filaL['nombreProducto'] . "'><h6>" . $filaL['nombreProducto'] . "</h6>" . $filaL['descripcionUnidad'] . "</li>";
                                                echo "</a>";
                                                $cont = $cont + 1;
                                            }
                                        }

                                        ?>-->
                                        
                                        




                                    </ul>
                                </div>
                                <div class="lineaA1"></div>
                            </div>
                            <div id="comprarTodo">
<!--                                <?php
                                if (isset($cont) and $cont > 0) {

                                    echo "<button class='buttonComprarTodo'>";
                                    echo "<p>COMPRAR TODO</p>";
                                    echo "</button>";
                                } else {
                                    echo "<a href='../vista/index.php' class='buttonComprarTodo' style='text-align: center;' >";
                                    echo "<p>AGREGAR PRODUCTOS</p>";
                                    echo "</a>";

                                }
                               

                                ?>-->
                            </div>
                        </div>
                        <div id="lineaLateral"></div>
                        <div id="productosGeneral">
                            <div id="productoD">
                                <div>

<!--                                    <?php

                                    if (isset($_SESSION['id'])) {

                                        foreach ($resultado2 as $miFila) {

                                            echo "<a href='DescripcionProductos.php'><div class='cajaPD' id='" . $miFila['idProductoD'] . "'>";
                                            echo "<h6></h6>";
                                            echo "<h6>" . $miFila['nombreProducto'] . "</h6>";
                                            echo "<div class='dividirD'>";
                                            echo "<div class='descripcionP'>";
                                            echo " <div class='descripcionR'>";
                                            echo "<p>" . $miFila['descripcionProductoGeneral'] . "</p>";
                                            echo "</div></a>";
                                            echo "<div id='botonesCE'>";
                                            echo "<Form class='botonG' action='../controlador/controladorProductoDeseado.php' method='post'>";
                                            echo "<button type='button'name='#'class='buttonComprar' id='botonC'>Comprar</button>";
                                            echo "<button type='submit' name='eliminar' value='" . $miFila['idProductoD'] . "'class='buttonComprar' id='botonC'>Eliminar</button>";

                                            echo " </Form>";
                                            echo "</div>";
                                            echo "</div>";
                                            echo "<div class='divImagen'>";
                                            echo "<a href='DescripcionProductos.php'class='imagenProducto'>";
                                            ?>
                                            <img src="data:image/jpeg;base64,<?php echo base64_encode($miFila['imagenProducto']); ?>"
                                                alt="<?php echo $miFila['nombreProducto']; ?>" class='imgsG' width='100%'
                                                height='100px'>

                                            <?php
                                            echo "</a>";
                                            echo "</div>";
                                            echo "</div>";
                                            echo "</div>";
                                        }
                                    } else {

                                        echo "<div class='alert alert-dark-tranparent' role='alert'>";
                                        echo "<h5>Tu menu favoritos esta vacio, Registrate ";
                                        echo "<a href='../vista/Registro.php' style='text-decoration: underline ;  opacity: 0.6;'>aqui</a>";
                                        echo " para poder agregar productos.</h5>";
                                        echo "</div>";

                                    }
                                    ?>-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="divFooter">
                    <footer id="footerG">

                        <div id="footerC">
                            <a href="controladorDireccionamiento?opcion=">
                                <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                                    class="bi bi-house-fill" viewBox="0 0 16 16">
                                    <path
                                        d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z" />
                                    <path
                                        d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z" />
                                </svg>
                            </a>
                        </div>


                    </footer>
                </div>


            </div>
        </div>

       
        


        <!-- ventana emergente  -->

        <style>
        /* ----------------------------STYLE PARA VENTANA EMERGENTE------------------- */

         .cerrarVentanaG{ 
            visibility: hidden;
            height: 100vh;
            width: 100%;
            background: rgb(0,0,0,0.3);
            position: fixed;
            z-index: 2;
        }  

        .cerrarVentanaG.active{
            visibility: visible;
        } 
        /* color de fondo de la ventana emergente overlay  */
        .overLay {  
            height: 60vh;
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            opacity: 0;
            transition: .3s ease all;
            transform: scale(0.7);
        }
        .overLay.active{
         opacity: 1;
         transform: scale(1);
        }
        
        /* el forwards es para que tome la ultimas propiedades que tiene una etiqueta */

        .overLay.active  .descripcionVentanaS strong{ animation: tituloStrong  700ms ease .2s  forwards;} 
        /* .overLay.active  .descripcionVentanaS p{ animation: tituloStrong  800ms ease .3s  forwards;}  */
        .overLay.active .ventanaBotones button{ animation: botones 800ms ease 500ms  forwards;}
        .overLay.active .ventanaBotones a{ animation: botones 800ms ease 500ms  forwards;}

      

        @keyframes tituloStrong{

            from {

                transform : translateY(-25px);
                opacity: 0;
                
            }
            to {

                transform : translateY(0);
                opacity: 1;
            }


        }
        @keyframes botones{

            from {

                transform : translateY(-25px);
                opacity: 0;
            }
            to {

                transform : translateY(0);
                opacity: 1;
            }
            
        }

        /* .buttonVentana:hover.active2{
            transition: 0ms; 
            esto era para solucionar el problema de la transicion del buttom
        } */

        .aCerrarPopup svg{   
            /* color: rgb(255, 255, 255); */
            transition: 4ms ease all;
        }
        .aCerrarPopup svg:hover{   
            color: red;
            /* transition: 3ms ease all; */
            
        }

        .formVentana {

            background-color: white;
            box-shadow: 0px 0px 5px 0px rgb(0, 0, 0 ,0.3);
            border-radius: 10px;
            width: 25%;
            height: 20vh;
        }

        .cajaVentana p {
            padding: 8px;
            font-size: 20px;
        }

        .descripcionVentana {
          
            display: flex;
            width: 100%;
            height: 12vh;
        }

        .descripcionVentanaS {
            padding-top: 12px;
            padding-left: 10px;
            font-size: 23px;
            display: flex;
            align-items: start;
            flex-direction: column;
            width: 90%;

        }
        .descripcionVentanaS strong{
            opacity: 0;
        }

        .CerrarVentana {
            width: 10%;
            display: flex;
            justify-content: center;
            padding-top: 15px;
        }

        .ventanaBotones {
            width: 100%;
            display: flex;
            align-items: end;
            padding-left: 10px;
            height: 6vh;
            gap: 10px;

        }

        .ventanaBotones button {
            width: 30%;
            height: 5vh;
            opacity: 0;
        }
        #svgTrash:hover{
            color: red;
        }



/* ------------------------------------------------------------------- */
        </style>
        
       

        <script>

            const  clickSvg = document.getElementById("svgTrash"),
                   ventana = document.querySelector(".cerrarVentanaG"),
                   svgCerrar =document.getElementById("svgCerrar"),
                   btnCancelar =document.getElementById("cancelarBtn"),
                   overLay =document.querySelector(".overLay"),
                   btnAceptar1 =document.getElementById("aceptarBtn1");

            
                        clickSvg.addEventListener('click',function () {
                            ventana.classList.add('active'); 
                            overLay.classList.add('active');
                        });

                        svgCerrar.addEventListener('click',function () {
                            ventana.classList.remove('active');
                            overLay.classList.remove('active'); 
                        });

                        btnCancelar.addEventListener('click',function () {
                            
                            ventana.classList.remove('active');
                            overLay.classList.remove('active');
                            // btnCancelar.classList.add('active2');
                            // location.reload(); 
                        });
                        btnAceptar1.addEventListener('click',function () {
                            window.location.href = '/index.jsp';
                        
                        });
         </script>
    </main>
</body>

</html>