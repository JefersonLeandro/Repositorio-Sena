<%-- 
    Document   : datosMarca
    Created on : 19/10/2023, 9:51:16 a. m.
    Author     : ADMON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:if test="${sessionScope.idTipoPersona != 3}">
    <script>
         window.location.href = 'index.jsp';
    </script>
</c:if>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Datos Marcas</title>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <link rel="stylesheet" href="Public//Fuentes/PT_Sans_Narrow/PTSansNarrow-Regular.ttf">
    <link rel="stylesheet" href="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
</head>

  <jsp:useBean id="unaMarca" class="modelo.MarcaProducto" scope="request" />

<body>
    <main id="mainVDF">
        <div id="divVG" class="subMain">
        
            <div id="tituloF"  class="gap4">
                <div id="cotenedorVDF">
                  <svg xmlns="http://www.w3.org/2000/svg" width="34" height="35" fill="currentColor" class="bi bi-journal-text" viewBox="0 0 16 16">
                    <path d="M5 10.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5zm0-2a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5z"/>
                    <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2z"/>
                    <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1H1z"/>
                  </svg>
                </div>
                <div id="contenedorH1">
                    <h1>Marcas</h1>
                </div>
                <div id="iconsH">
                    <div class="divMv">
                        <a href="controladorDireccionamiento?opcion=datosProducto">
                            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-arrow-left-short" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M12 8a.5.5 0 0 1-.5.5H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5a.5.5 0 0 1 .5.5z"/>
                              </svg>
                              <!-- <svg xmlns="http://www.w3.org/2000/svg" width="25" height="30" fill="currentColor" class="bi bi-arrow-90deg-left" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M1.146 4.854a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 4H12.5A2.5 2.5 0 0 1 15 6.5v8a.5.5 0 0 1-1 0v-8A1.5 1.5 0 0 0 12.5 5H2.707l3.147 3.146a.5.5 0 1 1-.708.708l-4-4z"/>
                              </svg> -->
                        </a>
                    </div>
                    <div class="divMv">
                        <a href="controladorDireccionamiento?opcion=">
                            <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="currentColor"
                                class="bi bi-house-fill" viewBox="0 0 16 16">
                                <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z" />
                                <path
                                    d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z" />
                            </svg>
                        </a>
                    </div>
                </div>
            </div>
            <div class="lineaA"></div>
            <div id="seccionGV" class="seccionGeneral">
                
                <!--arreglar el posicionamiento de la tabla o dejarlo asi o mirar otro diseno de tabla y mirar los espacios --> 
                <div class="seccionCV subSeccion">
                    <table border="1" class="table table-striped">
                        <thead>
                            
                            <tr class="encabezadoGris">
                                <th scope="col" style="padding-left: 60px">nombre Marca</th>
                                <th scope="col"></th>
                            </tr>
                            
                        </thead>
                        
                        
                            
                            <tbody>
                                <c:forEach items="${unaMarca.listar(0)}" var= "laMarca">
                                <tr>
                                    <form  action="controladorMarcaProducto" method="post">
                                        <td class="align-middle text-right">
                                            <div class="row mb-2 justify-content-center">
                                                <div class="col-6">
                                                    <input type="hidden" name="fIdMarcaProducto" value="${laMarca.idMarcaProducto}">
                                                    <input type="text" name="fNombreMarca" style="margin-left: 15px;" value="${laMarca.nombreMarca}">
                                                </div>
                                                <div class="col-6">
                                                    <button type="submit" name="fOpcion" value="Modificar" class="buttonEnviar2">Modificar</button>
                                                    <button type="submit" name="fOpcion" value="Eliminar" class="buttonEnviar2">Eliminar</button>
                                                </div>
                                            </div>
                                        </td>
                                    </form>
                                </tr>
                                </c:forEach>
                                    <tr>
                                    <form  action="controladorMarcaProducto" method="post">
                                            <td class="align-middle text-right">
                                                <div class="row mb-2 justify-content-center">
                                                    <div class="col-6">
                                                        <input type="hidden" name="fIdMarcaProducto" value="0">
                                                        <input type="text"  name="fNombreMarca"  style="margin-left: 15px;">
                                                    </div>
                                                    <div class="col-6">
                                                        <button type="submit" name="fOpcion" value="Ingresar" class="buttonEnviar">Ingresar</button>
                                                        <button type="reset"  value="Limpiar" class="buttonEnviar">Limpiar</button>
                                                    </div>
                                                </div>
                                            </td>
                                        </form>
                                    </tr>
                            </tbody>
                        
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

    <style>
        .seccionGeneral{
            /* arreglar */
            height: 71vh!important;
        }

        .subSeccion{

            width: 80%;
            height: 65vh;

        }

        .subMain{
            /* arreglar */
            width: 45%!important;

        }
        #iconsH{

            height: 10vh;
            box-sizing: border-box;
            display: flex;
            align-items: end;
            justify-content: end;
            width: 79%;
            display: flex;
            gap: 10px ;

        }
        
       
       

    </style>
</body>

</html>
