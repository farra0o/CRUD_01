$(document).ready(function() {
    
    
});

async function IniciarSesion(){
  
  let InicioUsuario ={};

 
  InicioUsuario.email = document.getElementById("txtEmail").value,
 
  InicioUsuario.contrasena = document.getElementById("txtContraseña").value;
  
  let repContraseña = document.getElementById("txtRepeatContra").value;

  if (repContraseña != datosUsuario.contrasena){
      alert("la contraseña ingresada no son iguales")
  }

    const Request = await fetch('api/Login', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },  
      body: JSON.stringify(datosUsuario)    
    });
    const Respuesta = await Request.json();  
}
