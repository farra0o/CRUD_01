package com.FarraXD.CRUD_01.controllers;
import com.FarraXD.CRUD_01.DAO.UsuarioDAOImplement;
import com.FarraXD.CRUD_01.Models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioContoller {

    @Autowired
    private UsuarioDAOImplement UserDAO;

    @RequestMapping(value = "api/Usuarios")
    public List<Usuario> ListaUsuarios() {

        List<Usuario> ListUsuarios = new ArrayList<>();
        return UserDAO.getUsuario();

    }

    @RequestMapping(value = "api/Usuarios/{ID}", method = RequestMethod.DELETE)
    public void DeleteUsuario(@PathVariable long ID) {

        UserDAO.Eliminar(ID);
    }

    @RequestMapping(value = "api/Usuarios", method = RequestMethod.POST)
    public void CrearUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String ContrasenaHash = argon2.hash(1, 1024, 1, usuario.getContrasena() );
        usuario.setContrasena(ContrasenaHash);

        UserDAO.CrearUsuario(usuario);
    }

}
