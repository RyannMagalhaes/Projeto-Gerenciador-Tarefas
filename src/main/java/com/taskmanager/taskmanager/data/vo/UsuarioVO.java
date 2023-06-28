package com.taskmanager.taskmanager.data.vo;


import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

public class UsuarioVO extends RepresentationModel<UsuarioVO> implements Serializable {

    private long cod_user;

    private String nome;

    private String email;

    public UsuarioVO(long cod_user, String nome, String email) {
        this.cod_user = cod_user;
        this.nome = nome;
        this.email = email;
    }

    public UsuarioVO() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioVO usuarioVO = (UsuarioVO) o;

        if (cod_user != usuarioVO.cod_user) return false;
        if (!nome.equals(usuarioVO.nome)) return false;
        return email.equals(usuarioVO.email);
    }

    @Override
    public int hashCode() {int result = (int) (cod_user ^ (cod_user >>> 32));
        result = 31 * result + nome.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" +
                "cod_user=" + cod_user +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
