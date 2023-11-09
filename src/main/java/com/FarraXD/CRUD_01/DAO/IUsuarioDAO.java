package com.FarraXD.CRUD_01.DAO;

import com.FarraXD.CRUD_01.Models.Usuario;

import java.util.List;

public interface IUsuarioDAO {
    List<Usuario> getUsuario();
    void Eliminar(Long id);

    void CrearUsuario(Usuario usuario);

    boolean EmailAuthPass(Usuario usuario);
}
