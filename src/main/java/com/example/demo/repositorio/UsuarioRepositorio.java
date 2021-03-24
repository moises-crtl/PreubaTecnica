/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repositorio;


import com.example.demo.model.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author ioriyagamy
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{
    
}
