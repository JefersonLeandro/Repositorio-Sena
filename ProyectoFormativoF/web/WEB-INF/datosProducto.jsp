<%-- 
    Document   : datosProductos
    Created on : 18/10/2023, 10:27:14 a. m.
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
    <title>Datos Producto</title>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <link rel="stylesheet" href="Public/Fuentes/PT_Sans_Narrow/PTSansNarrow-Regular.ttf">
    <link rel="stylesheet" href="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
</head>


  <jsp:useBean id="unProducto" class="modelo.Producto" scope="request" />
  <jsp:useBean id="laMarca" class="modelo.MarcaProducto" scope="request" />

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
                        <thead>    
                            <tr>
                                <th scope="col">nombreProducto</th>
                                <th scope="col">descripcionUnidad</th>
                                <th scope="col">descripcionProductoGeneral</th>
                                <th scope="col">stockProducto</th>
                                <th scope="col">precioProducto</th>
                                <th scope="col">idMarcaProducto</th>
                                <th scope="col"></th>

                            </tr>
                        </thead>
                            
                         <tBody>
                             
                         <c:forEach items="${unProducto.listar(0)}" var= "elProducto">
                             
                            <tr>
                                <form id="fModificarDatosProducto" action="controladorDatosProducto" method="post">
                                    <td><input type="hidden" name="fIdProducto" value="${elProducto.idProducto}">
                                        <input type="text" name="fNombreProducto" required value="${elProducto.nombreProducto}"></td>
                                    <td><input type="text" name="fDescripcionUnidad" required value="${elProducto.descripcionUnidad}"></td>
                                    <td><input type="text" name="fDescripcionProductoGeneral" value="${elProducto.descripcionProductoGeneral}"></td>
                                    <td><input type="number" name="fStockProducto" value="${elProducto.stockProducto}"></td>
                                    <td><input type="number" name="fPrecioProducto" value="${elProducto.precioProducto}"></td>
                                    
                                     <!--logica jcomboBox-->
                                     <!--se toma el id del producto de la marca y el id de la marca y se combrueban si son iguales los pone en ==-->
                                    <td>
                                         <select name="fIdMarcaProducto" required>
                                             <c:set var="idMarcaProductoG" value="${elProducto.idMarcaProducto}" />
                                             <c:forEach items="${laMarca.listar(0)}" var="unaMarca">
                                                 <c:set var="selected" value=""/> <!-- Restablecer "selected" en cada iteración -->
                                                 <c:if test="${idMarcaProductoG == unaMarca.idMarcaProducto}">
                                                     <!-- Código a ejecutar si la condición es verdadera -->
                                                      <c:set var="selected" value="selected"/>
                                                 </c:if> 
                                                 <option value="${unaMarca.idMarcaProducto}"  ${selected}>
                                                     <c:out value="${unaMarca.nombreMarca}"/>
                                                 </option>
                                             </c:forEach>
                                         </select>
                                     </td>
                                    
                                    <td><button type="submit" name="fOpcion" value="Modificar" class="buttonEnviar2">Modificar</button>
                                        <button type="submit" name="fOpcion" value="Eliminar" class="buttonEnviar2">Eliminar</button></td>
                                </form>
                               
                            </tr>
                             </c:forEach>

                            <tr>
                                <form id="fIngresarProducto" action="controladorDatosProducto" method="post">
                                    <input type="hidden" name="fIdProducto" value="0">
                                    <td><input type="text" name="fNombreProducto" required></td>
                                    <td><input type="text" name="fDescripcionUnidad" required></td>
                                    <td><input type="text" name="fDescripcionProductoGeneral" required></td>
                                    <td><input type="number" name="fStockProducto" required></td>
                                    <td><input type="number" name="fPrecioProducto" required></td>

                                    
                                    <!--logica para el select de insertar-->
                                    <td>
                                        <select name='fIdMarcaProducto' required>
                                          <option disabled selected>
                                                 <c:out value="-Seleciona-"/>
                                           </option>
                                          <c:forEach items="${laMarca.listar(0)}" var="unaMarca">
                                            <option value="${unaMarca.idMarcaProducto}" >
                                                <c:out value="${unaMarca.nombreMarca}"/>
                                            </option>

                                          </c:forEach>
                                         </select> 
                                    </td>

                                    <td><button type="submit" name="fOpcion" value="Ingresar"
                                            class="buttonEnviar">Ingresar</button>
                                        <button type="reset" value="Limpiar"
                                            class="buttonEnviar">Limpiar</button>
                                    </td>

                                </form>
                            </tr>
                        </tBody>

                    </table>
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

</body>

</html>
