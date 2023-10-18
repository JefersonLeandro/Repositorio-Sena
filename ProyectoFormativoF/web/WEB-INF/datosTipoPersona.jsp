<%-- 
    Document   : datosTipoPersona
    Created on : 17/10/2023, 6:20:12 p. m.
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
    <title>Datos TipoPersona</title>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <link rel="stylesheet" href="Public//Fuentes/PT_Sans_Narrow/PTSansNarrow-Regular.ttf">
    <link rel="stylesheet" href="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
</head>

  <jsp:useBean id="unTipoPersona" class="modelo.TipoPersona" scope="request" />

<body>
    <main id="mainVDF">
        <div id="divVG" class="subMain">
        
            <div id="tituloF">
                <div id="cotenedorVDF">
                    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-diagram-2" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M6 3.5A1.5 1.5 0 0 1 7.5 2h1A1.5 1.5 0 0 1 10 3.5v1A1.5 1.5 0 0 1 8.5 6v1H11a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-1 0V8h-5v.5a.5.5 0 0 1-1 0v-1A.5.5 0 0 1 5 7h2.5V6A1.5 1.5 0 0 1 6 4.5v-1zM8.5 5a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1zM3 11.5A1.5 1.5 0 0 1 4.5 10h1A1.5 1.5 0 0 1 7 11.5v1A1.5 1.5 0 0 1 5.5 14h-1A1.5 1.5 0 0 1 3 12.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1zm4.5.5a1.5 1.5 0 0 1 1.5-1.5h1a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1-1.5 1.5h-1A1.5 1.5 0 0 1 9 12.5v-1zm1.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1z"/>
                      </svg>
                </div>
                <div id="contenedorH1">
                    <h1>Roles</h1>
                </div>
                <div id="iconsH">
                    <div class="divMv">
                        <a href="controladorDireccionamiento?opcion=datosPersona">
                            <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-arrow-left-short" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M12 8a.5.5 0 0 1-.5.5H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5a.5.5 0 0 1 .5.5z"/>
                              </svg>
                              <!-- <svg xmlns="http://www.w3.org/2000/svg" width="25" height="30" fill="currentColor" class="bi bi-arrow-90deg-left" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M1.146 4.854a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 4H12.5A2.5 2.5 0 0 1 15 6.5v8a.5.5 0 0 1-1 0v-8A1.5 1.5 0 0 0 12.5 5H2.707l3.147 3.146a.5.5 0 1 1-.708.708l-4-4z"/>
                              </svg> -->
                        </a>
                    </div>
                    <div class="divMv">
                        <a href="index.php">
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
                                <th scope="col" style="padding-left: 60px">TipoPersona</th>
                                <th scope="col"></th>
                            </tr>
                            
                        </thead>
                        
                        
                            
                            <tbody>
                                <c:forEach items="${unTipoPersona.listar(0)}" var= "unTipoPersona">
                                <tr>
                                <form id="fModificarDatosFarmacia" action="controladorTipoPersona" method="post">
                                        <td class="align-middle text-right">
                                            <div class="row mb-2 justify-content-center">
                                                <div class="col-6">
                                                    <input type="hidden" name="fIdTipoPersona" value="${unTipoPersona.idTipoPersona}">
                                                    <input type="text" name="fNombreTipoPersona" style="margin-left: 15px;" value="${unTipoPersona.nombreTipoPersona}">
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
                                    <form id="fIngresarFarmacia" action="controladorTipoPersona" method="post">
                                            <td class="align-middle text-right">
                                                <div class="row mb-2 justify-content-center">
                                                    <div class="col-6">
                                                        <input type="hidden" name="fIdTipoPersona" value="0">
                                                        <input type="text"  name="fNombreTipoPersona"  style="margin-left: 15px;">
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
