/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicio;

import com.example.demo.model.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ioriyagamy
 */
@Service
public class UsuarioServicioImp implements UsuarioServicio {


    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    public UsuarioServicioImp(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findall() {
        return (List<Usuario>) usuarioRepositorio.findAll();
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarPersona(Usuario usuario) {
        return usuarioRepositorio.findById(usuario.getIdusuarios()).orElse(null);
    }

    @Override
    @Transactional
    public Usuario delete(Usuario usuario) {
        Usuario eliminarUsuario = usuarioRepositorio.findById(usuario.getIdusuarios()).orElse(null);
        if (eliminarUsuario == null) {
            return null;
        } else {
            eliminarUsuario.setStatus("ELIMINADO");
            return usuarioRepositorio.save(eliminarUsuario);
        }
    }

}
