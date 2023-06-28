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

    public long getCod_user() {
        return cod_user;
    }

    public void setCod_user(long cod_user) {
        this.cod_user = cod_user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
