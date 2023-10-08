<%-- 
    Document   : Registro
    Created on : 14/09/2023, 6:39:53 p. m.
    Author     : ADMON
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro</title>
    <link rel="stylesheet" href="Public/Estilos/style.css"> 
</head>
<!--cambiar la clase del button registrar ya que al cambiarle las propiedades cambio todo copiar el de visual y crear una nueva .-->
<body>
    <main>
        <div id="divContainer">
            <div id="divFormulario">

            <!--  action="../controlador/controladorInicioSession.php"   PONER LA VISTA DE REGISTRO EXIOSO YA PUEDE INICIAR SESION  -->
                <form  class="formulario" method="post" action="controladorSesion">

                    <div id="tituloForm">
                        <div id="iconoForm">
                            <!--aca me botada el error de desabilitar la imagen-->
                            <img src="Public/imgs/logoQ1.png" alt="logo" width="70px" height="70px" />

                        </div>
                        <div>
                            <h1>Farmacit</h1>
                        </div>
                    </div>
                    <div class="areainputsG">

                        <div id="plbIngresar">
                            <h2>Ingresa a tu cuenta</h2>
                        </div>
                        
                      
                        <h5 style="font-size: 18px; color: red ;"  id="datosInvalidos"></h5>
                                

                        <div class="areaInputForm">
                            <input type="text" placeholder="Email o Numero de identificacion"  class="inputsForm" name="emailDocumento" id="DocumentoCorreo" required>
                        </div>
                        <div class="areaInputForm">
                            <input type="password" placeholder="Contraseña" class="inputsForm" name="contrasena" id="contrasena" required>
                        </div>
                        <div class="olvidarContrasena">
                            <h3><a href="">¿Olvido la contraseña?</a></h3>
                        </div>
                        <!--en este div cambie la clase--> 
                        <div class="divButtonIngresar">
                            <button class="buttonIngresarF" style="font-family: inherit; font-size: 18px;" type="submit"  name="btnIngresar" value="iniciarSession" onclick=" return verificarCredenciales();"  > 
                            <!--onclick="/*location.href='index.php*/'"-->
                            <h3>Ingresar</h3>
                            </button>

                        </div>
                        <div id="divCrearC">
                            <p>¿No tienes una cuenta?<a href="controladorDireccionamiento?opcion=crearCuenta" class="linkCuenta"><h4>Crear una cuenta</h4></a></p>
                           
                        </div>
                        

                    </div>
                </form>

            </div>
           


        </div>

    </main>
    
</body>

    <script>
        
            function verificarCredenciales() {
                // Obtener los valores de correo y contraseña
                let correo = document.getElementById("DocumentoCorreo").value;
                let contrasena = document.getElementById("contrasena").value;

                // Verificar si los campos están vacíos
                if (correo.trim() === "" || contrasena.trim() === "") {
                    // Mostrar un mensaje de alerta
                    window.alert("Rellene todos los campos");
                    return false; // Detiene el envío del formulario
                }

                // Crear una instancia de XMLHttpRequest para realizar la solicitud AJAX
                let xhr = new XMLHttpRequest();

                // Configurar el manejo de la respuesta
                xhr.onreadystatechange = function () {
                    
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        // Obtener la respuesta del servidor
                        let respuesta = xhr.responseText;

                        // Manejar la respuesta según su valor
                        console.log("La respuesta es: " + respuesta);

                        if (respuesta === "true") {
                            document.getElementById("datosInvalidos").innerHTML = "";
                            // Permitir el envío del formulario
                        } else if (respuesta === "false") {
                            document.getElementById("datosInvalidos").innerHTML = "Datos Invalidos";
                            return false; // Detiene el envío del formulario
                        } else {
                            document.getElementById("datosInvalidos").innerHTML = "Error en la consulta.";
                            return false; // Detiene el envío del formulario
                        }
                    }
                };

                // Configurar la solicitud AJAX
                xhr.open("POST", "controladorSesion", true);
                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

                // Enviar los datos al servidor
                xhr.send("emailDocumento=" + correo + "&contrasena=" + contrasena);

                // Mostrar los datos en la consola (para depuración)
                console.log("Los datos son: ");
                console.log("Correo: " + correo);
                console.log("Contraseña: " + contrasena);

//                 Detener el envío del formulario de forma predeterminada
             return false;
    }


        

        



    </script>
</html>
