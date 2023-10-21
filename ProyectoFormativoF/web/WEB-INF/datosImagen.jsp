<%-- 
    Document   : datosImagen
    Created on : 19/10/2023, 11:06:15 a. m.
    Author     : ADMON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos Personas</title>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <link rel="stylesheet" href="Public/Fuentes/PT_Sans_Narrow/PTSansNarrow-Regular.ttf">
    <link rel="stylesheet" href="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
</head>
  <jsp:useBean id="laImagen" class="modelo.Imagen" scope="request" />
  <jsp:useBean id="elProducto" class="modelo.Producto" scope="request" />

<body>
    <main id="mainVDF">
        <div id="divVG">

            <div id="tituloF">
                <div id="iconoImagen">
                    <svg xmlns="http://www.w3.org/2000/svg" width="32" height="35" fill="currentColor"
                        class="bi bi-file-earmark-image" viewBox="0 0 16 16">
                        <path d="M6.502 7a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z" />
                        <path
                            d="M14 14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h5.5L14 4.5V14zM4 1a1 1 0 0 0-1 1v10l2.224-2.224a.5.5 0 0 1 .61-.075L8 11l2.157-3.02a.5.5 0 0 1 .76-.063L13 10V4.5h-2A1.5 1.5 0 0 1 9.5 3V1H4z" />
                    </svg>
                </div>
                <div id="contenedorH1" class="Separar">

                    <h1>Imagenes</h1>

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
                <div class="miCaja1">
                    <div class="miSubC">
                        <div class="cajaIntermedia">
                            <table border="1" class="table table-striped">

                                <thead>

                                    <tr>
                                        <th scope="col" class="miThs">nombreImagen</th>
                                        <th scope="col" style="padding-left:10px;">TipoImagen</th>
                                        <th scope="col" style="padding-left: 35px;">idProducto</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>


                                </tBody>
                                <c:forEach items="${laImagen.listar(0)}" var= "unaImagen">
                                    <tr>
                                        <form id="fModificarDatosFarmacia">
                                            <td class="miTds">
                                                <input type="hidden" name="fIdImagem" value="${unaImagen.idImagen}">
                                                <input type="text" name="fNombreImagen" value="${unaImagen.nombreImagen}">
                                            </td>

                                            <td style="padding-left: 0!important;">
                                                <select name="fTipoImagen" >
                                                    
                                                     
                                                     <c:set var="seleccionada1" value="" />
                                                     <c:set var="seleccionada0" value="" />
                                                     
                                                     <c:if test="${ unaImagen.tipoImagen == 0}"> 
                                                         <c:set var="seleccionada0" value="selected" />
                                                     </c:if>
                                                     <c:if test="${ unaImagen.tipoImagen == 1}"> 
                                                         <c:set var="seleccionada1" value="selected" />
                                                     </c:if>
                                                     
                                                        <!--0 - primeria-->
                                                        <!--1 - segundarias-->
                                                        <option value="0" ${seleccionada0}>Primaria</option>
                                                        <option value="1" ${seleccionada1}>Secundaria</option>
                                                </select>
                                            </td>
                                            <td style="width: 18%;">
                                                <input type="number" style="width: 90%;" value="${unaImagen.idProducto}" readonly>
                                            </td>
                                            <td>
                                                <button type="submit" name="fEnviar" value="Modificar"
                                                    class="buttonEnviar2">Modificar</button>
                                                <button type="submit" name="fEnviar" value="Eliminar"
                                                    class="buttonEnviar2">Eliminar</button>
                                            </td>
                                        </form>
                                    </tr>
                                </c:forEach>

                                </tBody>
                            </table>

                        </div>
                    </div>
                </div>
                <div class="miCaja2">
                    <div class="cajaDerechaG">
                        <div class="buscarP">
                            <h5>Buscar un producto</h5>
                            <form action="controladorDatosImagen" method="post">
                                <!-- dentro de controlador usar una funcion que le quite los espacio al valor  -->
                                <div class="areaBuscar">
                                    <div class="subABuscar">

                                        <input type="search" placeholder="Aqui" class="inputBusquedaP" name="fValorBusqueda" >
                                    </div>

                                    <button type="submit" name="fEnviar" value="Buscar" class="buttonEnviar" style="width: 20%;">Buscar</button>
                                        
                                 

                                </div>
                            </form>

                        </div>
                        <div class="miListaP">

                            <form class="areaListaP" action="#" method="post">
                                <div class="miListaS">
                                      
                                    
                                    <!--<ul class="list-group list-group-flush scrollable listaFavoritos" id="listaProductos">-->
                                        <!--resultadoBusqueda se encuentra en la solicitud devuelta por el controlador--> 
                                        <c:if test="${not empty resultadosBusqueda}">
                                            
                                             
                                            
                                                        
                                                     <ol class="list-group list-group-numbered listaFavoritos scrollable" id="listaProductos">
                                                            <c:forEach items="${resultadosBusqueda}" var="elProducto">
                                                        
                                                                <li class="list-group-item d-flex justify-content-between align-items-start"  >
                                                                  <div class="ms-2 me-auto">
                                                                    <div class="fw-bold">${elProducto.nombreProducto}</div>
                                                                     ${elProducto.descripcionUnidad} 
                                                                  </div>
                                                                  <span class="badge bg-primary rounded-pill">${elProducto.idProducto}</span>
                                                                </li>
                                                          </c:forEach>
                                                    </ol>
                                                       
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                             
                                           
                                        </c:if>

                                    <!--</ul>-->

                                    
                                  
                                  
                                </div>


                            </form>


                        </div>

                        <form id="formularioPrincipal" action="">
                            <div class="areaInsertar">
                                <div class="subArea1P " >
                                    <table border="1" class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th scope="col" class="miThs">nombreImagen</th>
                                                <th scope="col" style="padding-left:10px;">TipoImagen</th>
                                                <th scope="col" style="padding-left: 35px;">idProducto</th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    <input type="hidden" name="fIdImagen" value="0">
                                                    <input type="file" name="file" class="custom-file-upload" required>
                                                </td>
                                                <td>
                                                    <select name="fTipoImagen" id="" required>
                                                        <option value="" disabled selected>-Selecciona-</option>
                                                        <option value="0">Primaria</option>
                                                        <option value="1">Secundaria</option>
                                                    </select>
                                                </td>
                                                <td>
                                                    <input type="number"  readonly value="" id="inputDisabled" required>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                        
                                <div class="subArea2P" id="formEnviar">
                                    <button type="submit" name="fEnviar" value="Ingresar" class="buttonEnviar miBtnW">Ingresar</button>
                                    <button type="reset" name="fEnviar" value="Limpiar" class="buttonEnviar miBtnW">Limpiar</button>
                                </div>
                            </div>
                        </form>
                        


                    </div>

                </div>
            </div>
            <div class="lineaAF"></div>
            <div id="tituloAbajo">
                <div id="iconoAbajo">

                    <img src="Public/imgs/logoQ1.png" alt="logo" width="41px" height="41px">
                </div>
                <div id="tituloH">
                    <h2>Farmacit</h2>
                </div>
            </div>
        </div>
    </main>
    <style>
        .miCaja1 {
            width: 60%;
            height: 83vh;
            /* background: palegoldenrod;s */
            padding: 15px;



        }

        .miCaja2 {
            width: 40%;
            height: 83vh;
            /* background: rgb(137, 131, 144); */
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .miSubC {
            height: 100%;
            /* border: 3px solid black; */
            display: flex;
            align-items: center;
            justify-content: center;

        }

        .cajaIntermedia {
            width: 95%;
            height: 71vh;
            /* border: 3px solid black; */
            /* background: white; */
        }


        #iconoImagen {
            height: 10vh;
            padding-bottom: 15px;
            box-sizing: border-box;
            padding-left: 10px;
            display: flex;
            align-items: end;
        }

        .miThs {
            padding-left: 45px !important;
            box-sizing: border-box;

        }

        .miTds {
            padding-left: 23px !important;
            padding-right: 1px !important;
            box-sizing: border-box;


        }

        .cajaDerechaG {

            /* border: 3px solid black; */
            width: 90%;
            height: 90%;

        }

        .buscarP {

            height: 25%;
            /* border: 3px solid black; */
            padding: 35px;
            border-radius: 10px;
            border-bottom: none;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;


        }

        .inputBusquedaP {

            height: 4.5vh;
            width: 94%;
            border-radius: 15px;
            border: none;

            outline: none;

        }

        .areaBuscar {
            display: flex;
            gap: 10px;
        }

        .subABuscar {

            width: 60%;
            background-color: white;
            border: 3px solid black;
            display: flex;
            align-items: center;
            padding-left: 15px;
            border-radius: 15px;
            outline: invert;


        }

        .miListaP {

            height: 50%;
            /* border: 3px solid black; */
            border-top: none;
            border-bottom-left-radius: 10px;
            border-bottom-right-radius: 10px;
            display: flex;
            justify-content: center;
        }

        .areaListaP {

            height: 33vh;
            width: 90%;
            /* border: 1px solid black; */

        }

        .areaInsertar {

            height: 25%;
            /* border: 3px solid black; */


        }

        .subArea1P {

            height: 70%;
        }

        .subArea2P {

            height: 30%;
        }


        #formEnviar{

            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;


        }

        .miBtnW {
            width: 20% !important;
        }

        .miListaS {

            width: 85%;
            height: 33vh;
            padding-left: 10px;
            padding-top: 10px;
            border: 3px solid;
            border-radius: 10px;


        }

        #inputDisabled {

            width: 90%;
            background-color: #f1f1f1; /* Cambia el color de fondo */
            color: #888; /* Cambia el color del texto */
            border: 1px solid #ccc; /* Cambia el borde */
            cursor: not-allowed; /* Cambia el cursor */
        }
        #listaProductos.scrollable{

            overflow-y: scroll;
            max-height: 31vh;


        }

        #listaProductos::-webkit-scrollbar {
            width: 8px; /* Ancho de la barra de desplazamiento */
        }
        #listaProductos::-webkit-scrollbar-track {
            background-color: #f3f3f3; /* Color del fondo de la barra de desplazamiento */
        }
        #listaProductos::-webkit-scrollbar-thumb {
            background-color: #e1e0e0; /* Color de la barra de desplazamiento */
            border-radius: 10px;
        }


    </style>






</body>

</html>
