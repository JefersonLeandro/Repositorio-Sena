<%-- 
    Document   : datosProductos
    Created on : 18/10/2023, 10:27:14 a. m.
    Author     : ADMON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos Producto</title>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <link rel="stylesheet" href="Public/Fuentes/PT_Sans_Narrow/PTSansNarrow-Regular.ttf">
    <link rel="stylesheet" href="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
</head>

<body>
    <main id="mainVDF">
        <div id="divVG">

            <div id="tituloF">
                <div id="cotenedorVDF">
                    <div class="SvgA">
                        <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                            class="bi bi-boxes" viewBox="0 0 16 16">
                            <path
                                d="M7.752.066a.5.5 0 0 1 .496 0l3.75 2.143a.5.5 0 0 1 .252.434v3.995l3.498 2A.5.5 0 0 1 16 9.07v4.286a.5.5 0 0 1-.252.434l-3.75 2.143a.5.5 0 0 1-.496 0l-3.502-2-3.502 2.001a.5.5 0 0 1-.496 0l-3.75-2.143A.5.5 0 0 1 0 13.357V9.071a.5.5 0 0 1 .252-.434L3.75 6.638V2.643a.5.5 0 0 1 .252-.434L7.752.066ZM4.25 7.504 1.508 9.071l2.742 1.567 2.742-1.567L4.25 7.504ZM7.5 9.933l-2.75 1.571v3.134l2.75-1.571V9.933Zm1 3.134 2.75 1.571v-3.134L8.5 9.933v3.134Zm.508-3.996 2.742 1.567 2.742-1.567-2.742-1.567-2.742 1.567Zm2.242-2.433V3.504L8.5 5.076V8.21l2.75-1.572ZM7.5 8.21V5.076L4.75 3.504v3.134L7.5 8.21ZM5.258 2.643 8 4.21l2.742-1.567L8 1.076 5.258 2.643ZM15 9.933l-2.75 1.571v3.134L15 13.067V9.933ZM3.75 14.638v-3.134L1 9.933v3.134l2.75 1.571Z" />
                        </svg>
                    </div>

                </div>
                <div id="contenedorH1" class="Separar">
                    <h1>Productos</h1>
                </div>
                <div id="iconsAV">
                    <div class="divMv">
                        <a href="index.php">
                            <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor"
                                class="bi bi-house-fill" viewBox="0 0 16 16">
                                <path
                                    d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z" />
                                <path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z" />
                            </svg>
                        </a>
                    </div>
                </div>


            </div>
            <div class="lineaA"></div>
            <div id="seccionGV">
                <div class="seccionCV">
                    <table border="1" class="table  table-striped">
                        <tBody>
                            <tr>
                                <th scope="col">nombreProducto</th>
                                <th scope="col">descripcionUnidad</th>
                                <th scope="col">descripcionProductoGeneral</th>
                                <th scope="col">stockProducto</th>
                                <th scope="col">precioProducto</th>
                                <th scope="col">idMarcaProducto</th>
                                <th scope="col"></th>

                            </tr>
<!--                            <?php


                            include_once("../modelo/conexion.php");
                            $objetoConexion = new conexion();
                            $conexion = $objetoConexion->conectar();

                            include_once("../modelo/DatosProducto.php");

                            $objetoProducto = new DatosProducto($conexion,0,'nombreProducto','descripcionUnidad', 'descripcionProductoGeneral', 'stockProducto', 'precioProducto', 'idMarcaProducto');
                            $listaDatosProducto = $objetoProducto->listar(0);

                            while ($unRegistro = mysqli_fetch_array($listaDatosProducto)) {

                                echo '<tr><form id="fModificarDatosProducto"' . $unRegistro["idProducto"] . ' action="../controlador/controladorDatosProducto.php"method="post">';
                                echo '<td><input type="hidden" name="fIdProducto" value="' . $unRegistro['idProducto'] . '">';
                                echo '    <input type="text" name="fNombreProducto" required value="' . $unRegistro['nombreProducto'] . '"></td>';
                                echo '<td><input type="text" name="fDescripcionUnidad" required value="' . $unRegistro['descripcionUnidad'] . '"></td>';
                                echo '<td><input type="text" name="fDescripcionProductoGeneral" value="' . $unRegistro['descripcionProductoGeneral'] . '"></td>';
                                echo '<td><input type="number" name="fStockProducto" value="' . $unRegistro['stockProducto'] . '"></td>';
                                echo '<td><input type="number" name="fPrecioProducto" value="' . $unRegistro['precioProducto'] . '"></td>';
                                
                                $consulta = "SELECT idMarcaProducto, nombreMarca FROM marcaproducto;";
                                $resultado = mysqli_query($conexion, $consulta);
                                $valorAlmacenadoEnLaBaseDeDatos = $unRegistro['idMarcaProducto'] ;
                                echo "<td><select required name='fIdMarcaProducto' >";
                                foreach ($resultado as $fila) {
                                $selected = "";
                                if ($fila['idMarcaProducto'] == $valorAlmacenadoEnLaBaseDeDatos) {
                                    $selected = "selected";
                                }
                                echo "<option value='" . $fila['idMarcaProducto'] . "' " . $selected . ">" . $fila['nombreMarca'] . "</option>";
                                }
                                echo "</select></td>";

                                // echo '<td><input type="number" name="fIdMarcaProducto" value="' . $unRegistro['idMarcaProducto'] . '"></td>';

                                echo '<td><button type="submit" name="fEnviar" value="Modificar" class="buttonEnviar2">Modificar</button>
                                            <button type="submit" name="fEnviar" value="Eliminar" class="buttonEnviar2">Eliminar</button></td>';
                                echo '</form></tr>';

                            }

                            ?>-->

                            <tr>
                                <form id="fIngresarProducto" action="../controlador/controladorDatosProducto.php" method="post">
                                    <input type="hidden" name="fIdProducto" value="0">
                                    <td><input type="text" name="fNombreProducto" required></td>
                                    <td><input type="text" name="fDescripcionUnidad" required></td>
                                    <td><input type="text" name="fDescripcionProductoGeneral" required></td>
                                    <td><input type="number" name="fStockProducto" required></td>
                                    <td><input type="number" name="fPrecioProducto" required></td>

<!--                                 <?php
                                        echo "<td><select required name='fIdMarcaProducto' >";
                                        echo"<option disabled selected>-Seleciona-</option>";
                                        foreach ($resultado as $fila) {

                                            echo "<option  value='" .$fila['idMarcaProducto']. "'>" .$fila['nombreMarca']. "</option>";
                                        }
                                        echo "</select></td>";
                                    ?>-->

                                            

                                    <!-- <td><input type="number" name="fIdMarcaProducto" required></td> -->
                                    <!-- //arreglar al select nose porque no me coje la propiedad required hacer un if que si no nada
                                    // selecionado y se le dio click al button de ingresar mandar una alerta o mensaje diciendo que selecione
                                    // algo y ya. -->


                                    <td><button type="submit" name="fEnviar" value="Ingresar"
                                            class="buttonEnviar">Ingresar</button>
                                        <button type="reset" name="fEnviar" value="Limpiar"
                                            class="buttonEnviar">Limpiar</button>
                                    </td>

                                </form>
                            </tr>
                        </tBody>

                    </table>

<!--                    <?php
                    mysqli_free_result($listaDatosProducto);
                    $objetoConexion->desconectar($conexion);

                    ?>-->
                </div>


            </div>
            <div class="lineaAF"></div>
            <div id="tituloAbajo">
                <div id="iconoAbajo">
                    <img src="../Public/imgs/logoQ1.png" alt="logo" width="41px" height="41px">

                </div>
                <div id="tituloH">
                    <h2>Farmacit</h2>
                </div>

            </div>

        </div>


    </main>

</body>

</html>
