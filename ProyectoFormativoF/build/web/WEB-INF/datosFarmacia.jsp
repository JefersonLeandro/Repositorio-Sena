<%-- 
    Document   : datosFarmacia
    Created on : 14/10/2023, 2:20:43 p. m.
    Author     : ADMON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos Farmacias</title>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <link rel="stylesheet" href="Public/Fuentes/PT_Sans_Narrow/PTSansNarrow-Regular.ttf">
    <link rel="stylesheet" href="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
</head>

<body>
    <main id="mainVDF">
        <div id="divVG">
        
            <div id="tituloF">
                <div id="cotenedorVDF">
                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                        class="bi bi-building" viewBox="0 0 16 16">
                        <path
                            d="M4 2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3 0a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1ZM4 5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1ZM7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1Zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1ZM4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1Zm2.5.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1Zm3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1Z" />
                        <path
                            d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V1Zm11 0H3v14h3v-2.5a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5V15h3V1Z" />
                    </svg>
                </div>
                <div id="contenedorH1">
                    <h1>Farmacias</h1>
                </div>
                <div id="iconsAV">
                        <div class="divMv">
                        <a href="index.php">
                            <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
                                <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
                                <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
                            </svg>
                        </a>
                        </div>
                 </div>
                

            </div>
            <div class="lineaA"></div>
            <div id="seccionGV">
                <div class="seccionCV">                                    
                    <table border="1"  class="table table-striped">
                            
                        <!--cambiar el color a gris el encabezado y mirara si esta cogiendo la clase STRIPE-->
                        <thead class="Secondary">
                                <tr> 
                                    <th scope="col">nitFarmacia</th>
                                    <th scope="col">nombreFarmacia</th>
                                    <th scope="col">telefonoFarmacia</th>
                                    <th scope="col">correoFarmacia</th>
                                    <th scope="col">ubicacionFarmacia</th>
                                    <th scope="col"></th>
                
                                </tr>
                        </thead>
                                
                                
                        <tBody>  
<!--                        <?php

                        
                            include_once("../modelo/conexion.php");
                            $objetoConexion = new conexion();
                            $conexion = $objetoConexion->conectar();

                            include_once("../modelo/DatosFarmacia.php");
                            
                            $objetoDatosFarmacia = new DatosFarmacia ($conexion,0,'nitFarmacia','nombreFarmacia','telefonoFarmacia','correoFarmacia','ubicacionFarmacia');
                            $listaDatosFarmacia = $objetoDatosFarmacia->listar(0);
                        
                            while($unRegistro = mysqli_fetch_array($listaDatosFarmacia)){
                            
                                echo '<tr><form id="fModificarDatosFarmacia"'.$unRegistro["idFarmacia"].' action="../controlador/controladorDatosFarmacia.php"method="post">';
                                    echo '<td><input type="hidden" name="fIdFarmacia" value="'.$unRegistro['idFarmacia'].'">';
                                    echo '    <input type="text" name="fNitFarmacia" value="'.$unRegistro['nitFarmacia'].'"></td>';
                                    echo '<td><input type="text" name="fNombreFarmacia" value="'.$unRegistro['nombreFarmacia'].'"></td>';
                                    echo '<td><input type="number" name="fTelefonoFarmacia" value="'.$unRegistro['telefonoFarmacia'].'"></td>';
                                    echo '<td><input type="email" name="fCorreoFarmacia" value="'.$unRegistro['correoFarmacia'].'"></td>';
                                    echo '<td><input type="text" name="fUbicacionFarmacia" value="'.$unRegistro['ubicacionFarmacia'].'"></td>';
                                    echo '<td><button type="submit" name="fEnviar" value="Modificar" class="buttonEnviar2">Modificar</button>
                                            <button type="submit" name="fEnviar" value="Eliminar" class="buttonEnviar2">Eliminar</button></td>';
                                echo '</form></tr>';
                                    
                            }
                            // session_start();

                            // $alert = $_SESSION['mensaje']; // Recuperar el valor de la variable de sesión

                            // if ($alert == "Modificado") {
                            //     echo '<script>alert("Mensaje de alerta");</script>'; // Mostrar mensaje de alerta si $alert es "Modificado"
                            // }

                            // var_dump($alert);
                           
                            
                           

                        ?>-->

                                <tr>
                                    <form id="fIngresarFarmacia" action="../controlador/controladorDatosFarmacia.php" method="post">
                                        <input type="hidden" name="fIdFarmacia" value="0">
                                        <td><input type="text"  name="fNitFarmacia"></td>
                                        <td><input type="text"  name="fNombreFarmacia"></td>
                                        <td><input type="number" name="fTelefonoFarmacia"></td>
                                        <td><input type="email" name="fCorreoFarmacia"></td>
                                        <td><input type="text" name="fUbicacionFarmacia"></td>
                                        <td><button type="submit" name="fEnviar" value="Ingresar" class="buttonEnviar">Ingresar</button>
                                            <button type="reset" name="fEnviar" value="Limpiar"  class="buttonEnviar">Limpiar</button></td>
                                    </form>
                                </tr>  
                            </tBody>

                        </table>
                        
<!--                        <?php
                            mysqli_free_result($listaDatosFarmacia);
                            $objetoConexion->desconectar($conexion);
                        
                        ?>-->
                </div>

                
            </div>
            <div class="lineaAF"></div>
            <div id="tituloAbajo">
                <div id="iconoAbajo">
                    <img src="../Imgs/logoQ1.png" alt="logo" width="41px" height="41px">

                </div>
                <div id="tituloH">
                    <h2>Farmacit</h2>
                </div>
                    
            </div>
            
        </div>


    </main>

</body>

</html>
