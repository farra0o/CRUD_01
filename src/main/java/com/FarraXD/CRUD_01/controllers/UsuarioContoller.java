package com.FarraXD.CRUD_01.controllers;
import com.FarraXD.CRUD_01.Models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioContoller {

    @RequestMapping(value = "Usuario/{ID}")
    public Usuario getUsuario (@PathVariable long ID  )
    {
        Usuario usuario = new Usuario();
        usuario.setID(ID);
        usuario.setNombre("Rafael");
        usuario.setApellido("Guerrero");
        usuario.setEmail("RFAB_0@hotmail.com");
        usuario.setContrasena("123456");
        usuario.setTelefono("777-7777");

        return usuario;
    }

    @RequestMapping(value = "Usuarios")
    public List <Usuario> ListaUsuarios  (){

        List <Usuario> ListUsuarios = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setID(1);
        usuario.setNombre("Rafael");
        usuario.setApellido("Guerrero");
        usuario.setEmail("RFAB_0@hotmail.com");
        usuario.setContrasena("123456");
        usuario.setTelefono("777-7777");

        Usuario usuario2 = new Usuario();
        usuario2.setID(2);
        usuario2.setNombre("RA");
        usuario2.setApellido("NA");
        usuario2.setEmail("RF_0@hotmail.com");
        usuario2.setContrasena("123456");
        usuario2.setTelefono("777-7777");

        Usuario usuario3 = new Usuario();
        usuario3.setID(3);
        usuario3.setNombre("Mi");
        usuario3.setApellido("RA");
        usuario3.setEmail("RAB_0@hotmail.com");
        usuario3.setContrasena("123456");
        usuario3.setTelefono("777-7777");



        ListUsuarios.add(usuario);
        ListUsuarios.add(usuario2);
        ListUsuarios.add(usuario3);
        return ListUsuarios;
    }


}
