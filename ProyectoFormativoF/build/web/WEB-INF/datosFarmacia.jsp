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
  <!--es como un import este useBean-->
  <jsp:useBean id="unaFarmacia" class="modelo.Farmacia" scope="request" />

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
                        <a href="controladorDireccionamiento?opcion=">
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
                            
                            <c:forEach items="${unaFarmacia.listar(0)}" var= "laFarmacia">
                                 
                                 <tr><form id="fModificarDatosFarmacia"    action="controladorDatosFarmacia"  method="post">
                                    <td><input type="hidden" name="fIdFarmacia" value="${laFarmacia.idFarmacia}">
                                       <input type="text" name="fNitFarmacia" value="${laFarmacia.nitFarmacia}"></td>
                                    <td><input type="text" name="fNombreFarmacia" value="${laFarmacia.nombreFarmacia}"></td>
                                    <td><input type="number" name="fTelefonoFarmacia" value="${laFarmacia.telefonoFarmacia}"></td>
                                    <td><input type="email" name="fCorreoFarmacia" value="${laFarmacia.correoFarmacia}"></td>
                                    <td><input type="text" name="fUbicacionFarmacia" value="${laFarmacia.ubicacionFarmacia}"></td>
                                    <td><button type="submit" name="fOpcion" value="Modificar" class="buttonEnviar2">Modificar</button>
                                            <button type="submit" name="fOpcion" value="Eliminar" class="buttonEnviar2">Eliminar</button></td>
                                </form></tr>
                                
                                
                            </c:forEach>

                                <tr>
                                <form id="fIngresarFarmacia" action="controladorDatosFarmacia" method="post">
                                        <input type="hidden" name="fIdFarmacia" value="0">
                                        <td><input type="text"  name="fNitFarmacia"></td>
                                        <td><input type="text"  name="fNombreFarmacia"></td>
                                        <td><input type="number" name="fTelefonoFarmacia"></td>
                                        <td><input type="email" name="fCorreoFarmacia"></td>
                                        <td><input type="text" name="fUbicacionFarmacia"></td>
                                        <td><button type="submit" name="fOpcion" value="Ingresar" class="buttonEnviar">Ingresar</button>
                                            <button type="reset"  value="Limpiar"  class="buttonEnviar">Limpiar</button></td>
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
