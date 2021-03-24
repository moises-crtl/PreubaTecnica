/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.servicio.UsuarioServicio;
import com.example.demo.utils.Constans;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ioriyagamy
 */
@Controller
@Slf4j
public class UsuarioControlador {

    
    private UsuarioServicio usuarioServicio;

    
    @Autowired
    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }    

    @GetMapping(value = Constans.ENDPOINT_HOME_PAGE)
    public String inicio(Model model) {
        var clientes = usuarioServicio.findall();
        log.info("Se Esta inicializando la llamada el endpoint findAll");
        model.addAttribute("clientes", clientes);
        return "index";
    }

    @GetMapping(value = Constans.ENDPOINT_ADD_CLIENT)
    public String agregar(Usuario usuario) {
        return "modificar";
    }

    @PostMapping(value = Constans.ENDPOINT_SAVE_CLIENT)
    public String guardar(Usuario usuario) {
        log.info("Se Esta inicializando la llamada el endpoint guardar");
        usuarioServicio.save(usuario);
        return "redirect:/";
    }

    @GetMapping(value = Constans.ENPOINT_EDIT_CLIENT)
    public String editar(Usuario usuario, Model model) {
        log.info("Se Esta inicializando la llamada el endpoint editar");
        usuario = usuarioServicio.encontrarPersona(usuario);
        model.addAttribute("usuario", usuario);
        return "modificar";
    }

    @GetMapping(value = Constans.ENDPOINT_DELETE_CLIENT)
    public String eliminar(Usuario usuario, Model model) {
        log.info("Se Esta inicializando la llamada el endpoint eliminar");
        usuario = usuarioServicio.delete(usuario);
        model.addAttribute("usuario", usuario);
        return "redirect:/";
    }
//    @Autowired
//    private UsuarioServicio usuarioServicio;
//    @RequestMapping(value = "listar", method = RequestMethod.GET)
//    public List<Usuario> listar(){
//        log.info("Se Esta inicializando la llamada el endpoint findAll");
//        return usuarioServicio.findall();
//    }

}
