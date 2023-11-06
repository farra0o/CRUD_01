// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#Usuarios').DataTable();
});

async function cargarUsuarios(){
  
    const Request = await fetch('Usuarios', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },      
    });
    const Usuarios = await Request.json();

    let UsuarioList =" ";
    for (let usuario of Usuarios){
      let UsuarioHTML = 
                      "<tr><td>"+usuario.id + "</td>" +
                      "<td>"+usuario.nombre + usuario.apellido +"</td>" +
                      "<td>"+usuario.correo + "</td>" +
                      "<td>"+usuario.telefono + "</td>" +
                      "<td>"+usuario.contrasena + "</td>" +
                      '<td><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a></td></tr>';
                      UsuarioList += UsuarioHTML;
    }
  
    console.log(Usuarios);
    document.querySelector("#Usuarios tbody" ).outerHTML = UsuarioList;
}