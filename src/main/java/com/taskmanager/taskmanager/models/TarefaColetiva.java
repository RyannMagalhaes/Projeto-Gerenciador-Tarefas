package com.taskmanager.taskmanager.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tarefa_col_table")
public class TarefaColetiva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_tarefa_col;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "data_inicio", nullable = false)
    private Date data_inicio;

    @Column(name = "data_fim", nullable = false)
    private Date data_fim;

    @Column(name = "prioridade", nullable = false)
    private int prioriadade;

    public Long getCod_tarefa_col() {
        return cod_tarefa_col;
    }

    public void setCod_tarefa_col(Long cod_tarefa_col) {
        this.cod_tarefa_col = cod_tarefa_col;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public int getPrioriadade() {
        return prioriadade;
    }

    public void setPrioriadade(int prioriadade) {
        this.prioriadade = prioriadade;
    }
}
