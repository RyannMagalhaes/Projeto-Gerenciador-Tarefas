package com.taskmanager.taskmanager.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "usuario_table")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cod_user;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

}
