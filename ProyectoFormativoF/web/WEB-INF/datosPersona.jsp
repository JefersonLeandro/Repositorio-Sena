<%-- 
    Document   : datosPersona
    Created on : 16/10/2023, 9:36:18 a. m.
    Author     : ADMON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos Personas</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="../Fuentes/PT_Sans_Narrow/PTSansNarrow-Regular.ttf">
    <link rel="stylesheet" href="../bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
</head>

<body>
    <main id="mainVDF">
        <div id="divVG">

            <div id="tituloF">
                <div id="cotenedorVDF">
                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor"
                        class="bi bi-person-vcard-fill" viewBox="0 0 16 16">
                        <path
                            d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm9 1.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4a.5.5 0 0 0-.5.5ZM9 8a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 0-1h-4A.5.5 0 0 0 9 8Zm1 2.5a.5.5 0 0 0 .5.5h3a.5.5 0 0 0 0-1h-3a.5.5 0 0 0-.5.5Zm-1 2C9 10.567 7.21 9 5 9c-2.086 0-3.8 1.398-3.984 3.181A1 1 0 0 0 2 13h6.96c.026-.163.04-.33.04-.5ZM7 6a2 2 0 1 0-4 0 2 2 0 0 0 4 0Z" />
                    </svg>
                </div>
                <div id="contenedorH1" class="Separar">
                    <h1>Personas</h1>
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
                <div class="seccionCVP">
                    <table border="1" class="table  table-striped">
                        <tBody>
                            <tr>
                                <th scope="col">nombrePersona</th>
                                <th scope="col">apellidoPersona</th>
                                <th scope="col">identificacionPersona</th>
                                <th scope="col">correoPersona</th>
                                <th scope="col">telefonoPersona</th>
                                <th scope="col">contraseñaPersona</th>
                                <th scope="col">idTipoPersona</th>
                                <th scope="col"></th>

                            </tr>
<!--                            <?php


                            include_once("../modelo/conexion.php");
                            $objetoConexion = new conexion();
                            $conexion = $objetoConexion->conectar();

                            include_once("../modelo/DatosPersona.php");

                            $objetoPersona = new Persona($conexion, 0, 'nombrePersona', 'apellidoPersona', 'identificacionPersona', 'correoPersona', 'telefonoPersona', 'contrasenaPersona','idTipoPersona');
                            $listaDatosPersonas = $objetoPersona->listar(0);

                            while ($unRegistro = mysqli_fetch_array($listaDatosPersonas)) {

                                echo '<tr><form id="fModificarDatosPersona"' . $unRegistro["idPersona"] . ' action="../controlador/controladorDatosPersona.php"method="post">';
                                echo '<td><input type="hidden" name="fIdPersona" value="' . $unRegistro['idPersona'] . '">';
                                echo '    <input type="text" name="fNombrePersona" value="' . $unRegistro['nombrePersona'] . '"></td>';
                                echo '<td><input type="text" name="fApellidoPersona" value="' . $unRegistro['apellidoPersona'] . '"></td>';
                                echo '<td><input type="number" name="fIdentificacionPersona" value="' . $unRegistro['identificacionPersona'] . '"></td>';
                                echo '<td><input type="email" name="fCorreoPersona" value="' . $unRegistro['correoPersona'] . '"></td>';
                                echo '<td><input type="number" name="fTelefonoPersona" value="' . $unRegistro['telefonoPersona'] . '"></td>';
                                echo '<td><input type="text" name="fContrasenaPersona" value="' . $unRegistro['contrasenaPersona'] . '"></td>';

                                $consulta = "SELECT idTipoPersona, nombreTipoPersona FROM tipopersona;";
                               
                                $resultado = mysqli_query($conexion, $consulta);
                                $valorAlmacenadoEnLaBaseDeDatos = $unRegistro['idTipoPersona'];
                                echo "<td><select name='fIdTipoPersona' required>";
                                foreach ($resultado as $fila) {
                                $selected = "";
                                if ($fila['idTipoPersona'] == $valorAlmacenadoEnLaBaseDeDatos) {
                                    $selected = "selected";
                                }
                                echo "<option value='" . $fila['idTipoPersona'] . "' " . $selected . ">" . $fila['nombreTipoPersona'] . "</option>";
                                }
                                echo "</select></td>";
                                
                                //  echo '<td><input type="number" name="fIdTipoPersona" value="' . $unRegistro['idTipoPersona'] . '"></td>';
                                echo '<td><button type="submit" name="fEnviar" value="Modificar" class="buttonEnviar2">Modificar</button>
                                            <button type="submit" name="fEnviar" value="Eliminar" class="buttonEnviar2">Eliminar</button></td>';
                                echo '</form></tr>';

                            }
                          
                            ?>-->

                            <tr>
                                <form id="fIngresarPersona" action="../controlador/controladorDatosPersona.php"
                                    method="post">
                                    <input type="hidden" name="fIdPersona" value="0">
                                    <td><input type="text" name="fNombrePersona" required></td>
                                    <td><input type="text" name="fApellidoPersona" required></td>
                                    <td><input type="number" name="fIdentificacionPersona" required></td>
                                    <td><input type="email" name="fCorreoPersona" required></td>
                                    <td><input type="number" name="fTelefonoPersona" required></td>
                                    <td><input type="text" name="fContrasenaPersona" required></td>
                                    <!-- <option value="" disabled selected></option> -->
<!--                                    <?php
                                        echo "<td><select name='fIdTipoPersona'>";
                                        echo"<option disabled selected>-Seleciona-</option>";
                                        foreach ($resultado as $fila) {

                                            echo "<option  value='" .$fila['idTipoPersona']. "'>" .$fila['nombreTipoPersona']. "</option>";
                                        }
                                        echo "</select></td>";
                                    ?>-->
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
                    mysqli_free_result($listaDatosPersonas);
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
