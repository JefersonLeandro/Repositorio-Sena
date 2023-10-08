<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RegistroCrearCuenta</title>
    <link rel="stylesheet" href="Public/Estilos/style.css">
    <link rel="icon" href="data:;base64,iVBORw0KGgo="> 
    <script src="Public/bootstrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.js"></script>
    <script src="Public/Jquery/jquery-3.7.1.min.js"></script>
</head>



<body id="bodyResgistroC">

    <main>
       
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
                                    <input type="text" name="fNombrePersona" placeholder="Sus nombres" class="divAB nombreC" id="nombreP" onclick="cambiarColor();"  required>
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
                                        <input type="number" class="inputId cambiarC" name="fIdentificacionPersona"
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
                                        <input type="email" class="inputId cambiarC" name="fCorreoPersona"
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
                                        <input type="number" class="inputId cambiarC" name="fTelefonoPersona"
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

                                <input type="password" placeholder="Su Contraseña" name="fContrasenaPersona" class="divAB cambiarC" id="inputContrasena" required autocomplete="new-password">

                            </div>

                            <div class="cajaInps">
                                <div>
                                    <label for="cajaInps">Confirmar contraseña</label>

                                </div>
                                <input type="password" placeholder="Confirmar" class="divAB cambiarC" id="inputConfirmarContrasena" required >
                            </div>

                        </div>
                        
                        <div id="divTerminos">
                            <!--el checkbox cuando no esta marcado el java script le agrega una clase-->                                                                                                                                                        
                            
                            <input type="checkbox" id="aceptarTerminos" class="cambiarC" onchange="manipularCheckbox();" required >   
                          
                            <a href="#"  id="aTerminos" > Aceptar los términos y condiciones </a>
 
                        </div>
                        
                       
                    </div>
                    <div class="divButtonIn">
                        
                        <button class="buttonIngresarF" type="submit"  name="fAccion" style="font-family: inherit; font-size: 18px;" onclick="return verificarCampos() && manipularCheckbox(); " id="mibtnC">
                                <h3>Registrar</h3> 
                        </button>
                    </div>

                 </form>   
            </div>

        </div>

</body>

</html>

  <script>
                               
                             function verificarCampos(){
                                 
                                 
                              !(function(window, document) {//Esta es una función IIFE que toma window y document como argumentos, que son objetos globales. y se utliza para encapsular las variables

                                 
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
                                 
                                 
                                })(window, document);
                                 
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
                            
                            
                            
                            function cambiarColor(){
                                
                            // Selecciona el input
                                    const inputs = document.querySelector(".nombreC");
                                    const originalColor = inputs.style.borderBottomColor;
                                    
                                  //nombre
                                  inputs.addEventListener("input", function(event) {
//                                      event.preventDefault(); // Evita que el navegador establezca el foco en el input
//                //                        el evento input pasa cuando uno empieza a cambiar algo dentro de el como escribir 
                                       inputs.style.borderBottomColor = "black";
                                    });

//                                     Agrega un evento de blur al input
                                    inputs.addEventListener("blur", function() {
//                                       Cambia el color del input al original  
                                        inputs.style.borderBottomColor = originalColor;  
//                                                                         
                                   });

                                  

//                                    inputs.forEach(function(input) {
//                                        input.addEventListener("input", function() {
//                                                  inputs.style.borderBottomColor = "red";
//                                        });
//                                        
//                                        input.addEventListener("blur", function() {
//                                      // Cambia el color del input al original
//                                        inputs.style.borderBottomColor = originalColor;
//                                        });
//                                        
//                                        
//                                    });

                                
                            }
                            
                            
                            
                            
//                            
//                            
                         function validarCorreo() {// esta funcion no esta en uso porque al final no sirvio
                             
                                
                            console.log(" Dentre a la funcion validarCorreo");
                                

                            
                             !(function(window, document) {//Esta es una función IIFE que toma window y document como argumentos, que son objetos globales. y se utliza para encapsular las variables
//                                   
                                  
                                    let nombre = document.getElementById("nombreP").value;
                                    let apellido = document.getElementById("apellidoP").value;
                                    let identificacion = document.getElementById("documentoP").value;
                                    let correo = document.getElementById("inputCorreo").value;
                                    let telefono = document.getElementById("telefonoP").value;
                                    let contrasena = document.getElementById("inputContrasena").value;
                                    
                                    
                                    
                                     let xhr = new XMLHttpRequest();// se encarga de la comunicacion entre la otra vista enviar y recibir la respuesta 
                            
                                    xhr.onreadystatechange = function() {

                                        if (xhr.readyState === 4 && xhr.status === 200) {

                                            let respuesta = xhr.responseText;// obtiene la respuesta  

                                            console.log(" La respuesta es ::::: "+ respuesta+" ______------ final de la respuesta ");


                                            if (respuesta === "true") {

                                                window.alert("El correo sumistrado ya esta Registrado, debes cambiarlo.");

                                     
                                            }else if (respuesta === "false") {

                                                console.log("el correo no esta Registrado");
                                                xhr.abort();

                                            } else {

                                                console.log("Error en la consulta");
//                                             

                                            }
                                        }
                                    };
                            
                                        
                                    xhr.open("POST", "controladorCrearCuenta", true); // se envia el correo por medio de la url a controlador 
                                    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                                    xhr.send("fNombrePersona="+nombre+"&fApellidoPersona="+apellido+"&fIdentificacionPersona=" + identificacion +"&fCorreoPersona=" + correo +"&fTelefonoPersona=" + telefono +"&fContrasenaPersona=" + contrasena);


                                    console.log(correo+" EEEEEEEEEEL CORREO ");
                                 
                            
                                    
                                event.preventDefault(); // Previene el comportamiento predeterminado del botón 


                                })(window, document);
                            

                            
                        }

                               
                       </script>
                               



