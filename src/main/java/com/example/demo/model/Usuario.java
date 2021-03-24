package com.example.demo.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuarios")
    private Long idusuarios;
    private String nombre;
    private String apellido;
    private String telefono;
    @Column(name = "direccion")
    private String direccionCasa;
    @Column(name = "direccion2")
    private String direccionTrabajo;
    @Transient
    private String status;

}
