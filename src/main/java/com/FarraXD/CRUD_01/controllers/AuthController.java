package com.FarraXD.CRUD_01.controllers;

import com.FarraXD.CRUD_01.DAO.UsuarioDAOImplement;
import com.FarraXD.CRUD_01.Models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDAOImplement userDAO;
    @RequestMapping(value = "api/Login" , method = RequestMethod.POST)
    public String LoginUser(@RequestBody Usuario usuario) {

       if(userDAO.EmailAuthPass(usuario)){
           return "OK";
        }
       return "Fail";
    }

}
