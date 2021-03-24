/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.servicio;

import com.example.demo.model.Usuario;
import java.util.List;

/**
 *
 * @author ioriyagamy
 */
public interface UsuarioServicio {
    
    public List<Usuario> findall();
    
    public Usuario save(Usuario usuario);
    
    public Usuario encontrarPersona(Usuario usuario);
    
    public Usuario delete(Usuario usuario);
    
}
