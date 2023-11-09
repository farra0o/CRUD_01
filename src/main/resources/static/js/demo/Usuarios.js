// Call the dataTables jQuery plugin
$(document).ready(function() {
  CargarUsuarios();
  $('#Usuarios').DataTable();
});

async function CargarUsuarios(){
  
    const Request = await fetch('api/Usuarios', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },      
    });
    const Usuarios = await Request.json();
    

    let UsuarioList =" ";
    for (let usuario of Usuarios){
      // cargar el ID 
      let Botoneliminar ='<a href="#" onclick ="EliminarUsuario('+ usuario.id + ')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
      let UsuarioHTML = 
                      "<tr><td>"+usuario.id + "</td>" +
                      "<td>"+usuario.nombre + usuario.apellido +"</td>" +
                      "<td>"+usuario.email + "</td>" +
                      "<td>"+usuario.telefono + "</td>" +
                      "<td>"+usuario.contrasena + "</td>" +
                      "<td>"+ Botoneliminar + "</td></tr>";
                      UsuarioList += UsuarioHTML;
    }
  
    console.log(Usuarios);
    document.querySelector("#Usuarios tbody" ).outerHTML = UsuarioList;
}

async function EliminarUsuario(id){
  
  if ( !confirm("¿Desea borrar el usuario?")){
    return;
  }
  
  const Request = await fetch('api/Usuarios/' + id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },      
  });
  document.location.reload();
}