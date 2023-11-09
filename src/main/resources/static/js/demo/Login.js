$(document).ready(function() {
    
    
});

async function IniciarSesion(){
  
  let InicioUsuario ={};

 
  InicioUsuario.email = document.getElementById("txtEmail").value,
 
  InicioUsuario.contrasena = document.getElementById("txtContraseña").value;
  
    const Request = await fetch('api/Login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },  
      body: JSON.stringify(InicioUsuario)    
    });
    const Respuesta = await Request.text();  
    if (Respuesta == "OK"){
      window.location.href = "usuarios.html"
    }
    else{
      alert ("las credenciales ingresadas no son correctas");
    }
}
