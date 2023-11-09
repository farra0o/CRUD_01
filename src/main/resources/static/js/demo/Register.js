// Call the dataTables jQuery plugin
$(document).ready(function() {
    
    
  });
  
  async function ResgistrarUsuario(){
    
    let datosUsuario ={};

    datosUsuario.nombre = document.getElementById("txtNombre").value,
    datosUsuario.apellido = document.getElementById("txtApellido").value,
    datosUsuario.email = document.getElementById("txtEmail").value,
    datosUsuario.telefono = document.getElementById("txtTelefono").value,
    datosUsuario.contrasena = document.getElementById("txtContraseña").value;
    
    let repContraseña = document.getElementById("txtRepeatContra").value;

    if (repContraseña != datosUsuario.contrasena){
        alert("la contraseña ingresada no son iguales")
    }

      const Request = await fetch('api/Usuarios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },  
        body: JSON.stringify(datosUsuario)    
      });
      alert("Usuario Ingresado")

      document.location.reload();
      
  }
  