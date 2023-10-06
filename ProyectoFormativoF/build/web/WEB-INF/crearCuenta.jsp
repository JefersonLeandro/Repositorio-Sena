<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--    <meta http-equiv="Content-Security-Policy" content="default-src 'self';"> -->
    <!-- al dejarla me dice que no puede permitir css o estilos en linea o directamente ya que es inseguro -->
    <!--linea de arriba evita algunos ataques de inyección al cargar los recursos solamente en el dominio de origen lo que reduce significativamente
    el riesgo de ataques de inyección de scripts maliciosos (XSS) al evitar que los recursos externos sean cargados sin autorización.
    
    Puede proporcionar una capa adicional de seguridad en tu aplicación. Establecer 'self' como origen predeterminado significa que solo los recursos alojados en el mismo servidor (localhost) podrán cargarse y ejecutarse en tu página,
    lo que reduce el riesgo de ataques XSS.
    
    
    
    -->
    <title>RegistroCrearCuenta</title>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">
    <!--<script src="Public/Jquery/jquery-3.6.4.min.js"></script>-->
    <script src="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.js"></script>
    <!-- <link rel="stylesheet" href="../bootstrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.css"> -->
    <!-- <link rel="stylesheet" href="../Fuentes/PtSansNarrow/PTSansNarrow-Regular.ttf"> -->
    <script src="Public/Jquery/jquery-3.7.1.min.js"></script>
</head>



<body id="bodyResgistroC">

    <main>
        
<!--    pasar los datos de la persona a un objeto 

        <?php

        include_once("../modelo/conexion.php");
        $objetoConexion = new conexion();
        $conexion = $objetoConexion->conectar();

        include_once("../modelo/RegistroCrearCuenta.php");
            `
        $objetoPersona = new Persona($conexion,0, 'nombrePersona', 'apellidoPersona', 'identificacionPersona', 'correoPersona', 'telefonoPersona', 'contrasenaPersona');

        ?>-->
        <div id="divContainer2">
            <div id="divFormulario2">

                <form class="formulario" action="controladorCrearCuenta" method="post" id="miFormulario">
                    <div id="tituloForm">
                        <div id="iconoForm">
                            <!--el mismo error de la imagen-->
                            <img src="Public/imgs/logoQ1.png" alt="logo" width="70px" height="70px">

                        </div>
                        <div>
                            <h1>Farmacit</h1>
                        </div>
                        <div>
                            
                            
                            
                        </div>
                            
                        
                    </div>
                    <div id="divInputsG">

                        <div>

                            <div id="plbIngresar">
                                
                                <h2>Crear una cuenta</h2>

                            </div>
                               <div class="divInputsC">

                                <div class="cajaInps">
                                    <div>
                                        <label for="cajaInps">Nombre</label>
                                    </div>
                                    <!--<input type="hidden" name="fIdPersona" value="0"> es inesesario enviar este dato al controlador ya que va en auto Incremento--> 
                                    <input type="text" name="fNombrePersona" placeholder="Sus nombres" class="divAB" id="nombreP" required>
                                </div>

                                <div class="cajaInps">
                                    <div>
                                        <label for="cajaInps">Apellido</label>

                                    </div>
                                    <input type="text" name="fApellidoPersona" placeholder="Sus apellidos" class="divAB" id="apellidoP" required>
                                </div>

                            </div>
                            <div class="divGid">
                                <div class="divIdentificacion">

                                    <div class="labelid">
                                        <label for="labelid">Identificacion</label>

                                    </div>
                                    <div class="cajasId">
                                        <input type="number" class="inputId" name="fIdentificacionPersona"
                                            placeholder="Su identificacion" id="documentoP" required>

                                    </div>


                                </div>
                            </div>
                            <div class="divGid">
                                <div class="divIdentificacion">

                                    <div class="labelid">
                                        <label for="labelid">Correo</label>

                                    </div>
                                    <div class="cajasId">
                                        <input type="email" class="inputId" name="fCorreoPersona"
                                               placeholder="Su correo"  id="inputCorreo"   required>

                                    </div>


                                </div>
                            </div>
                            <div class="divGid">
                                <div class="divIdentificacion">

                                    <div class="labelid">
                                        <label for="labelid">Telefono</label>

                                    </div>
                                    <div class="cajasId">
                                        <input type="number" class="inputId" name="fTelefonoPersona"
                                            placeholder="Su Telefono" id="telefonoP" required>

                                    </div>


                                </div>
                            </div>
                        </div>
                        <div class="divInputsC2">

                            <div class="cajaInps">
                                <div>
                                    <label for="cajaInps" >Contraseña</label>
                                </div>

                                <input type="password" placeholder="Su Contraseña" name="fContrasenaPersona" class="divAB" id="inputContrasena" required autocomplete="new-password">

                            </div>

                            <div class="cajaInps">
                                <div>
                                    <label for="cajaInps">Confirmar contraseña</label>

                                </div>
                                <input type="password" placeholder="Confirmar" class="divAB" id="inputConfirmarContrasena" required >
                            </div>

                        </div>
                        
                        <div id="divTerminos">
                            <!--el checkbox cuando no esta marcado el java script le agrega una clase-->                                                                                                                                                        
                            
                            <input type="checkbox" id="aceptarTerminos"  onchange="manipularCheckbox();" required >   
                          
                            <a href="#"  id="aTerminos" > Aceptar los términos y condiciones </a>
 
                        </div>
                        
                       
                    </div>
                    <div class="divButtonIn">
                        
                        <button class="buttonIngresarF" type="button"  name="fAccion" style="font-family: inherit; font-size: 18px;" onclick=" return verificarCampos() && manipularCheckbox() && ultimaValidacion();" id="mibtnC">
                                <h3>Registrar</h3> 
                        </button>
                    </div>

<!--                si esto cambiar esto lo de la alerta y por una ventana emergente RECUERDE AGREGAR EL MENSAJE DE REGISTRO EXITOSO , tambien lo de decirt la contrasena  incorreta y  los campos vacios     
                        el return dentro onclick recibe un parametro osea si es true el  formulario valida la informacion y la envia mas cambia si es false no la envia 

                        // c
<?php
                        if (isset($_GET['msj'])) {

                            $mostrarMensaje =$_GET['msj'];
                            echo "<script>alert('$mostrarMensaje')</script>";  
                        }
                    
                    ?>-->
                 </form>   
            </div>

        </div>

</body>

</html>

  <script>
                               // Obtén el valor de la variable "elMensaje" y úsalo en JavaScriptasdla
//                              en ves de obtener el mensaje por medio del request si hace con javaScript directamente trayendo los datos  de los lnputs con .value y asi manejar la ligica de manera local 
                               // trabajar con ajax para mantener los dastos y enviarlos al controlador solo si estan bien todos 
                               
                              
                        
                               
                               
                             function verificarCampos(){
                                 
                                let nombre = document.getElementById("nombreP").value;
                                let apellido = document.getElementById("apellidoP").value;
                                let identificacion = document.getElementById("documentoP").value;
                                let correo = document.getElementById("inputCorreo").value;
                                let telefono = document.getElementById("telefonoP").value;
                                let contrasena = document.getElementById("inputContrasena").value;
                                let confirmarC = document.getElementById("inputConfirmarContrasena").value;

                               // Verificar si los campos están vacíos
                               if (nombre.trim() === "" || apellido.trim() === ""  || identificacion.trim() === "" || correo.trim() === "" || telefono.trim() === "" || contrasena.trim() === "" || confirmarC.trim() === "") {
                                   // Mostrar un mensaje de alerta
                                   window.alert("Rellene todos los campos");
                                   return false; // Detiene el envío del formulario
                                   
                                   
                               }else if (contrasena !== confirmarC) {
                                   
                                    console.log(" Dentre a validar la contrasenas");
                                    window.alert("Las contraseñas no coinciden");
                                    document.getElementById("inputContrasena").value = "";
                                    document.getElementById("inputConfirmarContrasena").value = "";                                                                    

                                    return false; // Evita que el formulario se envíe
                                }              

                                 return true;// Permite que el formulario se envíe si todo está bien
                                 
                             }
    
    
    
                              function manipularCheckbox(){
                                
                                
                                console.log(" Dentre a la funcion manipularCheckbox");

                                // Obtener el checkbox por su id
                                let checkbox = document.getElementById("aceptarTerminos");
                                let aCheckbox = document.getElementById("aTerminos");
                               
                                
                                let estaChekeado = checkbox.checked;
//                                checkbox.addEventListener("click", function() {   
                                    
                                    if (!(checkbox.checked)) { 

                                        aCheckbox.classList.add("checkBoxActivado");
                                        checkbox.classList.add("checkBoxActivado");
                                        return false;
                                    } else{
                                        
                                      aCheckbox.classList.remove("checkBoxActivado");
                                      checkbox.classList.remove("checkBoxActivado");
                                      return true; // mirar la logica 
                                    }
//                                 });

                            }
                            
                            
                            
                            
                           function ultimaValidacion() {
                               
                               console.log("111");
                               
                                event.preventDefault(); // Previene el comportamiento predeterminado del botón

                                let nombre = document.getElementById("nombreP").value;
                                let apellido = document.getElementById("apellidoP").value;
                                let identificacion = document.getElementById("documentoP").value;
                                let correo = document.getElementById("inputCorreo").value;
                                let telefono = document.getElementById("telefonoP").value;
                                let contrasena = document.getElementById("inputContrasena").value;

                                let ruta =
                                    "fNombrePersona=" +
                                    nombre +
                                    "&fApellidoPersona=" +
                                    apellido +
                                    "&fIdentificacionPersona=" +
                                    identificacion +
                                    "&fCorreoPersona=" +
                                    correo +
                                    "&fTelefonoPersona=" +
                                    telefono +
                                    "&fContrasenaPersona=" +
                                    contrasena;

                                $(document).ready(funcionPrincipal);
                                console.log("222");

                                function funcionPrincipal() {
                                    console.log("333");
                                    $("#miFormulario").on("submit", function (e) {
                                        e.preventDefault(); // Previene el envío del formulario por defecto
                                       
                                        ejecutarAjax();
                                    });
                                     console.log("444");
                                    function ejecutarAjax() {
                                        
                                        console.log("555");
                                        $.ajax({
                                            
                                           
                                            
                                            type: "POST",
                                            url: "controladorCrearCuenta",
                                            data: ruta,
                                            success: function (respuesta) {
                                                if (respuesta === "true") {
                                                    window.alert(
                                                        "El correo suministrado ya está registrado, debes cambiarlo."
                                                    );
                                                } else if (respuesta === "false") {
                                                    console.log("El correo no está registrado");
                                                    // Permite el envío del formulario
                                                    $("#miFormulario").unbind("submit").submit();
                                                } else {
                                                    console.log("Error en la consulta");
                                                    console.log(respuesta + " esta es la respuesta");
                                                }
                                            },
                                            error: function (xhr, status, error) {
                                                console.log("Error en la solicitud AJAX:", error);
                                                // Puedes mostrar un mensaje de error al usuario o realizar acciones necesarias aquí.
                                            },
                                        });
                                    }
                                }
                            }

                                    
                                
                                
                                
                                
                            
                            
                            
                            
                            
//                            function validarInformacion() {
//                                
//                                event.preventDefault(); // Previene el comportamiento predeterminado del botón
//
//                                
//                                
//                                let nombre = document.getElementById("nombreP").value;
//                                let apellido = document.getElementById("apellidoP").value;
//                                let identificacion = document.getElementById("documentoP").value;
//                                let correo = document.getElementById("inputCorreo").value;
//                                let telefono = document.getElementById("telefonoP").value;
//                                let contrasena = document.getElementById("inputContrasena").value;
//
//                                let ruta = "fNombrePersona=" + nombre + "&fApellidoPersona=" + apellido + "&fIdentificacionPersona=" + identificacion + "&fCorreoPersona=" + correo + "&fTelefonoPersona=" + telefono + "&fContrasenaPersona=" + contrasena;
//
//                                $.ajax({
//                                    url: 'controladorCrearCuenta',
//                                    type: 'POST',
//                                    data: ruta,
//                                    success: function (respuesta) {
//                                        // La función se ejecutará cuando la solicitud sea exitosa,
//                                        // pero como no esperas una respuesta en JSON, no necesitas analizarla.
//                                        // Si no necesitas hacer nada específico con la respuesta, puedes omitir esta parte.
//
//                                        // Ejemplo de cómo puedes manejar la respuesta
////                                        if (miRespuesta === "true") {
////                                            window.alert("El correo suministrado ya está registrado, debes cambiarlo.");
////                                        } else if (miRespuesta === "false") {
////                                            console.log("El correo no está registrado");
////                                        } else {
////                                            console.log("Error en la consulta");
////                                            console.log(miRespuesta+" esta es la respuesta");
////                                        }
//
//
//
//                                         if (respuesta === "true") {
////                                                document.getElementById("datosInvalidos").innerHTML = "";
//                                                 window.alert("El correo suministrado ya está registrado, debes cambiarlo.");
//                                                // Permitir el envío del formulario
//                                            } else if (respuesta === "false") {
//                                                 console.log("El correo no está registrado");
//                                                return true; // Detiene el envío del formulario
//                                            } else {
//                                                console.log("Error en la consulta");
//                                                console.log(respuesta + " esta es la respuesta");
//                                                return false; // Detiene el envío del formulario
//                                            }
//                                
//                                    },
//                                    error: function (xhr, status, error) {
//                                        // Esta función se ejecutará en caso de un error en la solicitud.
//                                        console.log('Error en la solicitud AJAX:', error);
//                                        // Puedes mostrar un mensaje de error al usuario u realizar acciones necesarias aquí.
//                                    }
//                                });
//                            }
//
//                            
//                            
//                         function validarCorreo() {
//                             
//                             
////                             utiliza HTTPS para cifrar la comunicación. llaque no se debe enviar los datos sensibles  al servidor por medio de ajax y
//
//                                // Realizar una solicitud AJAX para verificar si el correo está registrado en la base de datos
//                                // Actualizar el contenido de "mensajeCorreo" con el resultado
////                                 var id = 450; // Esta variable está fuera de la IIFE y es accesible globalmente.
////
////                                    !(function(window, document) {
////                                      // Esta es una función IIFE que toma window y document como argumentos, que son objetos globales.
////
////                                      var id2 = 500; // Esta variable está dentro de la IIFE y no es accesible desde fuera.
////
////                                      console.log("Dentro de IIFE", id2);
////                                    })(window, document);
////
////                                    console.log("Fuera de IIFE", id); // La variable 'id' se puede acceder fuera de la IIFE.
////
////                                    console.log(id2); // Esta línea generaría un error porque 'id2' no es accesible fuera de la IIFE.
//                                // 
//                                
//                            console.log(" Dentre a la funcion validarCorreo");
//                                
//                                // encriptar la contrasena desde aqui asi no la pueden obtener 
//                                
//                                
////                                let bandera = false;
//                            
//                             !(function(window, document) {
////                                   Esta es una función IIFE que toma window y document como argumentos, que son objetos globales. y se utliza para encapsular las variables
//                                  
//                                    let nombre = document.getElementById("nombreP").value;
//                                    let apellido = document.getElementById("apellidoP").value;
//                                    let identificacion = document.getElementById("documentoP").value;
//                                    let correo = document.getElementById("inputCorreo").value;
//                                    let telefono = document.getElementById("telefonoP").value;
//                                    let contrasena = document.getElementById("inputContrasena").value;
//                                    
//                                    
//                                    
//                                     let xhr = new XMLHttpRequest();// se encarga de la comunicacion entre la otra vista enviar y recibir la respuesta 
//                            
//                                    xhr.onreadystatechange = function() {
//
//                                        if (xhr.readyState === 4 && xhr.status === 200) {
//
//                                            let respuesta = xhr.responseText;// obtiene la respuesta  
//
//                                            console.log(" La respuesta es ::::: "+ respuesta+" ______------ final de la respuesta ");
//
//
//                                            if (respuesta === "true") {
//
//                                                window.alert("El correo sumistrado ya esta Registrado, debes cambiarlo.");
//
////                                                bandera = false;/
//                                                // desactivar el boton  Registrar
//
//                                            } else if (respuesta === "false") {
//
//                                                console.log("el correo no esta Registrado");
////                                                bandera = true;
//                                                xhr.abort();
//
//                                            } else {
//
//                                                console.log("Error en la consulta");
////                                                bandera = false;
//
//                                            }
//                                        }
//                                    };
//                            
//                                        
//                                    xhr.open("POST", "controladorCrearCuenta", true); // se envia el correo por medio de la url a controlador 
//                                    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//                                    xhr.send("fNombrePersona="+nombre+"&fApellidoPersona="+apellido+"&fIdentificacionPersona=" + identificacion +"&fCorreoPersona=" + correo +"&fTelefonoPersona=" + telefono +"&fContrasenaPersona=" + contrasena);
//
//
//                                    console.log(correo+" EEEEEEEEEEL CORREO ");
//                                 
//                            
//                                        // dejar esto con una variable 
////                                    return false; 
////                                  return bandera;
//
//
//                                })(window, document);
//                            
//
//                            
//                        }

                            
                            // validar si los datos son campos vacios 
                            // si todo sale bien mandar el mensaje de registro exitoso 
                               
                               
                       </script>
                               



