<%-- 
    Document   : datosPersona
    Created on : 16/10/2023, 9:36:18 a. m.
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
    <title>Datos Personas</title>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <link rel="stylesheet" href="Public/Fuentes/PT_Sans_Narrow/PTSansNarrow-Regular.ttf">
    <link rel="stylesheet" href="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css">
</head>
  <jsp:useBean id="laPersona" class="modelo.Persona" scope="request" />
  <jsp:useBean id="unTipoPersona" class="modelo.TipoPersona" scope="request" />

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
                 <div class="subTituloT" style="display: flex; align-items: end; padding-bottom: 4px; margin-left: 20px; width: auto;">
                    <a href="#">
                    <h4>-Roles</h4>
                    </a>
                </div>
                <div id="iconsAV">
                    <div class="divMv">
                        <a href="controladorDireccionamiento?opcion=index">
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
                        
                        <thead>
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
                        </thead>     
                        <tBody>
                            
                           <!--la variable var unaPersona recibe los datos y con ella misma se muestran--> 
                            <c:forEach items="${laPersona.listar(0)}" var= "unaPersona">
                                
                                <tr><form id="fModificarDatosPersona"  action="controladorDatosPersona" method="post">
                                    <td><input type="hidden" name="fIdPersona" value="${unaPersona.idPersona}">
                                    <input type="text" name="fNombrePersona" value="${unaPersona.nombrePersona}"></td>
                                <td><input type="text" name="fApellidoPersona" value="${unaPersona.apellidoPersona}"></td>
                                <td><input type="number" name="fIdentificacionPersona" value="${unaPersona.identificacionPersona}"></td>
                                <td><input type="email" name="fCorreoPersona" value="${unaPersona.correoPersona}" disabled ></td>
                                <td><input type="number" name="fTelefonoPersona" value="${unaPersona.telefonoPersona}"></td>
                                <td><input type="text" name="fContrasenaPersona" value="${unaPersona.contrasenaPersona}" disabled ></td>
                                  <!--logica jcomboBox-->
                               <td>
                                    <select name="fIdTipoPersona" required>
                                        <c:set var="valorAlmacenadoTPBD" value="${unaPersona.idTipoPersona}" />
                                        <c:forEach items="${unTipoPersona.listar(0)}" var="elTipoPersona">
                                            <c:set var="selected" value=""/> <!-- Restablecer "selected" en cada iteración -->
                                            <c:if test="${valorAlmacenadoTPBD == elTipoPersona.idTipoPersona}">
                                                <!-- Código a ejecutar si la condición es verdadera -->
                                                 <c:set var="selected" value="selected"/>
                                            </c:if> 
                                            <option value="${elTipoPersona.idTipoPersona}"  ${selected}>
                                                <c:out value="${elTipoPersona.nombreTipoPersona}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </td>

                                <td>
                                    <button type="submit" name="fOpcion" value="Modificar" class="buttonEnviar2">Modificar</button>
                                    <button type="submit" name="fOpcion" value="Eliminar" class="buttonEnviar2">Eliminar</button>
                                </td>
                                </form></tr>
                            </c:forEach>

                            <tr>
                                <form id="fIngresarPersona" action="controladorDatosPersona" method="post">
                                    <input type="hidden" name="fIdPersona" value="0">
                                    <td><input type="text" name="fNombrePersona" required></td>
                                    <td><input type="text" name="fApellidoPersona" required></td>
                                    <td><input type="number" name="fIdentificacionPersona" required></td>
                                    <td><input type="email" name="fCorreoPersona" required></td>
                                    <td><input type="number" name="fTelefonoPersona" required></td>
                                    <td><input type="text" name="fContrasenaPersona" required></td>

                                          <td>
                                              <select name='fIdTipoPersona' required>
                                                <option disabled selected>
                                                       <c:out value="-Seleciona-"/>
                                                 </option>
                                                <c:forEach items="${unTipoPersona.listar(0)}" var="elTipoPersona">
                                                  <option value="${elTipoPersona.idTipoPersona}" >
                                                        <c:out value="${elTipoPersona.nombreTipoPersona}"/>
                                                  </option>

                                                </c:forEach>
                                            </select> 
                                          </td>
                                    <td>
                                        <button type="submit" name="fOpcion" value="Ingresar" class="buttonEnviar">Ingresar</button>
                                        <button type="reset"  value="Limpiar" class="buttonEnviar">Limpiar</button>
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
