  <%-- 
    Document   : index.html
    Created on : 14/09/2023, 7:55:50 a. m.
    Author     : ADMON
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Public/Estilos/style.css"/>
        <link rel="stylesheet" href="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
        <link rel="stylesheet" href="Public/Fuentes/PtSansNarrow/PTSansNarrow-Regular.ttf">
        <link rel="icon" type="imagen/png" href="url  arreglar   "/>
        <script src="Public/Jquery/jquery-3.6.4.min.js"></script>
        <script src="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.js"></script>


        <title>index</title>

    </head>
    <body>
        <header>
            <!-- P==PRIMARI@ -->
            <!-- S==secundario -->

            <div id="parteP">
                <div id="iconoP">

                    <!--<img src="../imgs/logoQ1.png" alt="logo" width="65px" height="65px"> NOSE PORQUE LA LINEA DE ABAJO ME BOTADA ERROR SOLO ME DIJO QUE LA DESABILITARA-->

                    <img src="Public/imgs/logoQ1.png" alt="logo"  width="65px" height= "65px" />

                </div>
                <div id="tituloP">
                    <h1 id="soyh1">Farmacit</h1>
                </div>
                <div id="gif1">
                    <!-- <img src="/webs20/gifs/BHAH.gif" width="60px" height="80px" alt=""> -->
                </div>
            </div>
            <div class="areaHeaderG">
                <nav id="navSuperior">
                    <ul>
                        <li><a href="tablaProductoDeseado.php" id="aLinkProductos">Productos deseados</a></li>
                        <li><a href="CarritoCompras.php" id="aLinkProductos">Carrito</a></li>
                        <!-- <li>compras</li> -->
                        <li>Servicios</li>
                        <li>destacados</li>
                        <li>destacados</li>
                    </ul>
                </nav>


            </div>
            <!-- plb==palabra -->
            <div id="iconoG">

                <div id="iconoS">
                    
                    <a href="controladorDireccionamiento?opcion=Registro" class="aSvg">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle"
                             viewBox="0 0 16 16">
                        <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                        <path fill-rule="evenodd"
                              d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
                        </svg>  
                    </a>
                    <div id="plbRegistro">
                        
                        <%
                            
                            if((session.getId() != null) && (session.getAttribute("idPersona") != null) && (session.getAttribute("nombrePersona") != null)){
                            
                                String nombre = (String)session.getAttribute("nombrePersona");
                                String id = (String) session.getId(); // identificador de la sesion
                                
                        %>
                               
                                    <div class='btn-group'>
                                        <button type='button' class='btn btn-tranparent dropdown-toggle' style='padding: 0; border: none; display: flex; align-items: center; gap: 5px;' data-bs-toggle='dropdown' aria-expanded='false' id='btnTogglee'>
                                            <strong><%= nombre %></strong>
                                        </button>
                        
                                          <ul class='dropdown-menu' style='padding-left:10px; '>
                                            <li><a class='dropdown-items' href=''>action</a></li>
                                            <li><a class='dropdown-items' href=''> otra action</a></li>
                                            <li><a class='dropdown-items' href=''> otra action</a></li>
                                            <li><hr class='dropdown-divider'></li>
                                            <li><a class='dropdown-item' href='controladorCerrarSesion'>Cerrar session</a></li>
                                          </ul>
                                     </div>
                        
                        
                        
                        
                               

                        <%

                            }else{
                        %>
                        <a href="controladorDireccionamiento?opcion=Registro">
                            <strong class='aSvg'>Registro</strong>
                        </a>
                        <%
                            }
                            
                        
                        %>
                        
           
                        
                        

                        <!--           <?php 
                        
                                    if (!empty($_SESSION['nombre']) and !empty($_SESSION['apellido'])) { //si la variable no esta vacia haga esto 
                                        
                                      echo"<div class='btn-group'>";
                                        echo"<button type='button' class='btn btn-tranparent dropdown-toggle' style='padding: 0; border: none; display: flex; align-items: center; gap: 5px;' data-bs-toggle='dropdown' aria-expanded='false' id='btnTogglee'>";
                                          $nombre=$_SESSION['nombre'];
                                          
                                          echo "<strong id'strongT'>".$nombre."</strong>";
                                        echo"</button>";
                        
                                          echo"<ul class='dropdown-menu' style='padding-left:10px; '>";
                                            echo"<li><a class='dropdown-items' href=''>action</a></li>";
                                            echo"<li><a class='dropdown-items' href=''> otra action</a></li>";
                                            echo"<li><a class='dropdown-items' href=''> otra action</a></li>";
                                            echo"<li><hr class='dropdown-divider'></li>";
                                            echo"<li><a class='dropdown-item' href='../controlador/controladorCerrarSession.php'>Cerrar session</a></li>";
                                          echo"</ul>";
                                      echo"</div>";
                        
                                      // echo "<a  href='../controlador/controladorCerrarSession.php' >Soy yo</a>";
                        
                                    }else{
                                      // si esta vacio haga esto 
                                      echo"<a href='Registro.php'>";
                                        echo"<strong class='aSvg'>Registro</strong>";
                                      echo"</a>";
                                    }
                                    1-linea
                                    ?>-->
                                       
                    </div>
                </div>

                <nav id="navBar" class="navbar bg-body-tertiary fixed-top">
                    <div id="container-F" class="container-fluid">

                        <button id="btnVar" class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                                data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
                             aria-labelledby="offcanvasNavbarLabel">
                            <div class="offcanvas-header">
                                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">Barra Lateral</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                            </div>
                            <div class="offcanvas-body">
                                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                                    <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href="#"></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">Acerca de nosotros</a>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                                           aria-expanded="false">
                                            Dropdown
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li><a class="dropdown-item" href="#">Action</a></li>
                                            <li><a class="dropdown-item" href="#">Another action</a></li>
                                            <li>
                                                <hr class="dropdown-divider">
                                            </li>
                                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                                        </ul>
                                    </li>
                                    <li class="nav-item">
                                        <!-- <a class="nav-link" href="AreaAdministracion.html">Area de Administracion</a> -->
                                        <!--                  <?php
                                        
                                                            // cosas por arreglar si la persona ya esta iniciada y es administrador y se quiere cambiar a tro rol 
                                                            // por ejemplo a cliente y lo modifico y en la vista sigue como administrador como si no hubiera hecho el cambio 
                                                            // depronto es porque esa misma session esta activa pero si se session y va y mira los cambios ya se ven reflejados 
                                        
                                                            // arreglar el archivo de administracion osea poner que la idTipoPersona==3 dejelo ahi pero si no es redirecionelo a 
                                                            // la pagina principal.
                                                           
                                                            if(isset($_SESSION['id']) and isset($_SESSION['idTipoPer'])){
                                        
                                                              $verificacionT=$_SESSION['idTipoPer'];
                                        
                                                              if($verificacionT==3){
                                        
                                                               echo"<a class='nav-link' href='AreaAdministracion.html'>Area de Administracion</a>";
                                                              }
                                                            }
                                                            // session_start();
                                                            // $id=$_SESSION['id'];
                                                            if (isset($_SESSION['id'])) {
                                                              echo"<a class='nav-link' href='../controlador/controladorCerrarSession.php'>Cerrar session</a>";
                                                            }
                                                            
                                                            if(empty($_SESSION['id'])){
                                        
                                                              echo"<a class='nav-link' href='Registro.php'>Iniciar Sesion</a>";
                                                            }
                                                            1-linea
                                                          ?>-->
                                        
                                       
                                        
                                        
                                        
                                        <a class='nav-link' href='Registro.php'>Iniciar Sesion</a>
                                    </li>
                                </ul>
                                <form class="d-flex mt-3" role="search">
                                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                    <button class="btn btn-outline-success" type="submit">Search</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </nav>

            </div>
        </header>

        <main>
            <menu id="menuSecundario">
                <ul>

                    <li id="iconoSuperOfertas">
                        <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" fill="currentColor" class="bi bi-tags"
                             viewBox="0 0 16 16">
                        <path
                            d="M3 2v4.586l7 7L14.586 9l-7-7H3zM2 2a1 1 0 0 1 1-1h4.586a1 1 0 0 1 .707.293l7 7a1 1 0 0 1 0 1.414l-4.586 4.586a1 1 0 0 1-1.414 0l-7-7A1 1 0 0 1 2 6.586V2z" />
                        <path
                            d="M5.5 5a.5.5 0 1 1 0-1 .5.5 0 0 1 0 1zm0 1a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3zM1 7.086a1 1 0 0 0 .293.707L8.75 15.25l-.043.043a1 1 0 0 1-1.414 0l-7-7A1 1 0 0 1 0 7.586V3a1 1 0 0 1 1-1v5.086z" />
                        </svg>
                        Super ofertas
                    </li>

                    <li>
                        <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" fill="currentColor" class="bi bi-gift"
                             viewBox="0 0 16 16">
                        <path
                            d="M3 2.5a2.5 2.5 0 0 1 5 0 2.5 2.5 0 0 1 5 0v.006c0 .07 0 .27-.038.494H15a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1v7.5a1.5 1.5 0 0 1-1.5 1.5h-11A1.5 1.5 0 0 1 1 14.5V7a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h2.038A2.968 2.968 0 0 1 3 2.506V2.5zm1.068.5H7v-.5a1.5 1.5 0 1 0-3 0c0 .085.002.274.045.43a.522.522 0 0 0 .023.07zM9 3h2.932a.56.56 0 0 0 .023-.07c.043-.156.045-.345.045-.43a1.5 1.5 0 0 0-3 0V3zM1 4v2h6V4H1zm8 0v2h6V4H9zm5 3H9v8h4.5a.5.5 0 0 0 .5-.5V7zm-7 8V7H2v7.5a.5.5 0 0 0 .5.5H7z" />
                        </svg>
                        Enviar regalo
                    </li>
                    <li>
                        <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" fill="currentColor"
                             class="bi bi-credit-card-2-back" viewBox="0 0 16 16">
                        <path d="M11 5.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1-.5-.5v-1z" />
                        <path
                            d="M2 2a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H2zm13 2v5H1V4a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1zm-1 9H2a1 1 0 0 1-1-1v-1h14v1a1 1 0 0 1-1 1z" />
                        </svg>
                        Metodos de pago
                    </li>

                    <li>
                        <svg xmlns="http://www.w3.org/2000/svg" width="19" height="19" fill="currentColor"
                             class="bi bi-clipboard2-plus" viewBox="0 0 16 16">
                        <path
                            d="M9.5 0a.5.5 0 0 1 .5.5.5.5 0 0 0 .5.5.5.5 0 0 1 .5.5V2a.5.5 0 0 1-.5.5h-5A.5.5 0 0 1 5 2v-.5a.5.5 0 0 1 .5-.5.5.5 0 0 0 .5-.5.5.5 0 0 1 .5-.5h3Z" />
                        <path
                            d="M3 2.5a.5.5 0 0 1 .5-.5H4a.5.5 0 0 0 0-1h-.5A1.5 1.5 0 0 0 2 2.5v12A1.5 1.5 0 0 0 3.5 16h9a1.5 1.5 0 0 0 1.5-1.5v-12A1.5 1.5 0 0 0 12.5 1H12a.5.5 0 0 0 0 1h.5a.5.5 0 0 1 .5.5v12a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5v-12Z" />
                        <path d="M8.5 6.5a.5.5 0 0 0-1 0V8H6a.5.5 0 0 0 0 1h1.5v1.5a.5.5 0 0 0 1 0V9H10a.5.5 0 0 0 0-1H8.5V6.5Z" />
                        </svg>
                        Catologo
                    </li>
                </ul>
                <div id="areaCentralG">
                    <div class="areaCentral">

                        <input type="search" placeholder="Buscar producto" class="inputBuscar">

                        <svg xmlns="http://www.w3.org/2000/svg" id="iconoBuscar" width="24" height="24" fill="currentColor"
                             class="bi bi-search" viewBox="0 0 16 16">
                        <path
                            d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                        </svg>

                    </div>
                </div>
            </menu>


            <div id="seccionPrincipal">
                <div id="barraLateralG">
                    <aside>
                        <div id="barraL1">
                            <div class="barraC">
                                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                                     class="bi bi-filter-right" viewBox="0 0 16 16" id="iconoFiltro">
                                <path
                                    d="M14 10.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0 0 1h3a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-7a.5.5 0 0 0 0 1h7a.5.5 0 0 0 .5-.5zm0-3a.5.5 0 0 0-.5-.5h-11a.5.5 0 0 0 0 1h11a.5.5 0 0 0 .5-.5z" />
                                </svg>
                                <p>Filtros Aplicados</p>
                            </div>
                        </div>

                        <div id="barraL2">
                            <div class="barraC">
                                <p>Filtrar por:</p>
                            </div>

                            <div id="divSelectG">
                                <div class="divSelect">
                                    <select name="" class="selectBL2">

                                        <option disabled selected>Sub-Categoría</option>
                                        <option value="">Dolor muscular - articular</option>
                                        <option value="">Dolor de cabeza y general</option>
                                        <option value="">Dolor abdominal y colicos</option>
                                        <option value="">Migraña</option>
                                        <option value="">Dolor y fiebre niños</option>

                                    </select>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-arrow-down-circle-fill" viewBox="0 0 16 16">
                                    <path
                                        d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z" />
                                    </svg>
                                </div>

                                <div class="divSelect">
<!--                                    <?php 

                                    $consulta = "SELECT idMarcaProducto, nombreMarca FROM MarcaProducto;";           
                                    $resultado = mysqli_query($conexion, $consulta);
                                    echo"<select name='' class='selectBL2'>";
                                    echo"<option disabled selected>Marca</option>";
                                    foreach ($resultado as $fila) {
                                    echo "<option value='". $fila['idMarcaProducto'] . "'>" .$fila['nombreMarca'] ."</option>";
                                    }
                                    echo"</select>";// agruegar las opciones de la marca trayendo tambien los datos
                                    ?>-->
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-arrow-down-circle-fill" viewBox="0 0 16 16">
                                    <path
                                        d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z" />
                                    </svg>
                                </div>

                                <div class="divSelect">
                                    <select name="" class="selectBL2">

                                        <option disabled selected>Gama de precios</option>
                                        <option value="">menor a $10.000$</option>
                                        <option value="">menor a $50.000$</option>
                                        <option value="">menor a $100.000$</option>
                                        <option value="">menor a $180.000$</option>

                                    </select>
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-arrow-down-circle-fill" viewBox="0 0 16 16">
                                    <path
                                        d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8.5 4.5a.5.5 0 0 0-1 0v5.793L5.354 8.146a.5.5 0 1 0-.708.708l3 3a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V4.5z" />
                                    </svg>
                                </div>
                            </div>
                    </aside>
                </div>


                <div id="seccionProductos">
                    <section id="seccionP">
<!--                        <?php
                        $consulta = "SELECT idProducto, nombreProducto, descripcionUnidad,precioProducto ,imagenProducto FROM producto";
                        $resultado = mysqli_query($conexion, $consulta);
                        // $miFila = mysqli_fetch_assoc($resultado);

                        foreach ($resultado as $miFila) {

                        echo"<div class='divSeccion'>";
                        echo"<div class='cajas'>";
                        // echo"<div class='cajaSecundaria'>";
                        echo"<div  class='linkDi1'>";
                        echo"<div class='contenedorImgP'>";
                        echo "<a href='DescripcionProductos.php' class='contenedorImg'>";
                        ?>
                        <img src="data:image/jpeg;base64,<?php echo base64_encode($miFila['imagenProducto']); ?>" alt="<?php echo $miFila['nombreProducto'];?>" class='imgsG' width='75%' height='145px'>
                        <?php
                        echo"</a>";  
                        echo"<a href='DescripcionProductos.php' class='cajaC'>";
                        echo "<span>" . $miFila['nombreProducto'] . "</span>";
                        echo "<h6>" .$miFila['descripcionUnidad']. "</h6>";
                        echo "<h6>$" .$miFila['precioProducto']. "$</h6>";
                        echo"</a>";
                        echo"</div>";
                        // si esta definido me dejar enviar los datos a deseados del resto no 
                        // si no esta entonces llevelo a registrar
                        if (isset($_SESSION['id'])) {

                        echo"<form class='cajaFP'action='../controlador/controladorProductoDeseado.php' method='post'>";
                        echo"<button class='cajaFavorito' name='favorito' value='".$miFila['idProducto']."'>";
                        echo"<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-bookmark-star' viewBox='0 0 16 16'>
                        <path d='M7.84 4.1a.178.178 0 0 1 .32 0l.634 1.285a.178.178 0 0 0 .134.098l1.42.206c.145.021.204.2.098.303L9.42 6.993a.178.178 0 0 0-.051.158l.242 1.414a.178.178 0 0 1-.258.187l-1.27-.668a.178.178 0 0 0-.165 0l-1.27.668a.178.178 0 0 1-.257-.187l.242-1.414a.178.178 0 0 0-.05-.158l-1.03-1.001a.178.178 0 0 1 .098-.303l1.42-.206a.178.178 0 0 0 .134-.098L7.84 4.1z'/>
                        <path d='M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z'/>
                        </svg>";
                        echo"</button>";
                        echo"</form>";
                        echo"</div>";

                        echo"<form class='cajaCB' action='../controlador/controladorCarritoProducto.php' method='post'>";
                        echo"<button class='buttonComprar' type='button'>";
                        echo "<p>Comprar</p>";
                        echo"</button>";
                        echo"<button class='buttonAgregar' name='agregar' value='".$miFila['idProducto']."' type='submit'>";
                        echo"<svg xmlns='http://www.w3.org/2000/svg' width='20' height='20' fill='currentColor' class='bi bi-cart-plus-fill' viewBox='0 0 16 16'>
                        <path d='M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0z'/>
                        </svg>";
                        echo"</button>";
                        echo"</form>";

                        }else{

                        echo"<a class='cajaFP' href='../vista/Registro.php'>";
                        echo"<button class='cajaFavorito' name='favorito' type='button'>";
                        echo"<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' class='bi bi-bookmark-star' viewBox='0 0 16 16'>
                        <path d='M7.84 4.1a.178.178 0 0 1 .32 0l.634 1.285a.178.178 0 0 0 .134.098l1.42.206c.145.021.204.2.098.303L9.42 6.993a.178.178 0 0 0-.051.158l.242 1.414a.178.178 0 0 1-.258.187l-1.27-.668a.178.178 0 0 0-.165 0l-1.27.668a.178.178 0 0 1-.257-.187l.242-1.414a.178.178 0 0 0-.05-.158l-1.03-1.001a.178.178 0 0 1 .098-.303l1.42-.206a.178.178 0 0 0 .134-.098L7.84 4.1z'/>
                        <path d='M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5V2zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1H4z'/>
                        </svg>";
                        echo"</button>";
                        echo"</a>";
                        echo"</div>";

                        echo"<a class='cajaCB' href='../vista/Registro.php' >";
                        echo"<button class='buttonComprar' type='button'>";
                        echo "<p>Comprar</p>";
                        echo"</button>";
                        echo"<button class='buttonAgregar' name='agregar' type='button'>";
                        echo"<svg xmlns='http://www.w3.org/2000/svg' width='20' height='20' fill='currentColor' class='bi bi-cart-plus-fill' viewBox='0 0 16 16'>
                        <path d='M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM9 5.5V7h1.5a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0V8H6.5a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 1 0z'/>
                        </svg>";
                        echo"</button>";
                        echo"</a>";
                        }
                        echo"</div>";
                        echo"</div>"; 


                        }
                        // RECUERDE QUE LO TOCA TRABAJAR CON LA ULTIMA BD DATOS Y AGREGAR SOLAMENTE EL NOMBRE DE LAS IMAGENES EN VEZ DE LAS IMAGENES
                        ?>-->
                    </section>
                </div>
            </div>




        </main>
        
         <footer>
    <div id="divContactG">

      <div id="divCR1">
        <h4>Contáctanos</h4>
        <div>
<!--        <?php
          $consulta = "SELECT telefonoFarmacia FROM farmacia WHERE idFarmacia=1;";
          $resultado = mysqli_query($conexion, $consulta);
          $fila = mysqli_fetch_assoc($resultado);
          echo "<span>Telefono: " . $fila['telefonoFarmacia'] . "</span>";
        ?>-->
          <span>Telefono: 3143842657</span>
        </div>
        <div>
          <span>Correo: servicio_cliente@gmail.com</span>
        </div>

      </div>

      <div id="tituloA">

        <div>
          <img src="Public/imgs/logoQ1.png" alt="logo" width="50px" height="50px">

        </div>
        <div>
          <h3>Farmacit</h3>
        </div>

      </div>

      <div id="divCR2">

        <div id="tituloR">
          <h4>Redes</h4>
        </div>
        <div id="divRGE">

          <a href="https://es-la.facebook.com/" target="_blank">
            <div class="centrarIconos">
              <div class="iconosHover">

                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                  class="bi bi-facebook" viewBox="0 0 16 16">
                  <path
                    d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z" />
                </svg>
              </div>

              <span>Facebook</span>

            </div>
          </a>
          <a href="https://twitter.com/" target="_blank">
            <div class="centrarIconos">
              <div class="iconosHover">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-twitter"
                  viewBox="0 0 16 16">
                  <path
                    d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z" />
                </svg>
              </div>

              <span>twitter</span>

            </div>
          </a>
          <a href="https://www.instagram.com/" target="_blank">
            <div class="centrarIconos">
              <div class="iconosHover">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                  class="bi bi-instagram" viewBox="0 0 16 16">
                  <path
                    d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z" />
                </svg>

              </div>

              <span>Instagram</span>

            </div>
          </a>


        </div>


      </div>


    </div>
  </footer>



    </body>
</html>
