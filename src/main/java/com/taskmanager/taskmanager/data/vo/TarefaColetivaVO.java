package com.taskmanager.taskmanager.data.vo;

import jakarta.persistence.Column;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TarefaColetivaVO extends RepresentationModel<TarefaColetivaVO> implements Serializable {

    private Long cod_tarefa_col;
    private String nome;
    private String descricao;
    private String categoria;
    private boolean status;
    private Date data_inicio;
    private Date data_fim;
    private int prioridade;
    private List<Long> idsParticipantes;

    public TarefaColetivaVO(Long cod_tarefa_col, String nome, String descricao, String categoria, boolean status, Date data_inicio, Date data_fim, int prioridade, List<Long> idsParticipantes) {
        this.cod_tarefa_col = cod_tarefa_col;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = status;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.prioridade = prioridade;
        this.idsParticipantes = idsParticipantes;
    }

    public TarefaColetivaVO() {
    }

    public Long getCod_tarefa_col() {
        return cod_tarefa_col;
    }

    public void setCod_tarefa_col(Long cod_tarefa_col) {
        this.cod_tarefa_col = cod_tarefa_col;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public List<Long> getIdsParticipantes() {
        return idsParticipantes;
    }

    public void setIdsParticipantes(List<Long> idsParticipantes) {
        this.idsParticipantes = idsParticipantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TarefaColetivaVO that = (TarefaColetivaVO) o;

        if (status != that.status) return false;
        if (prioridade != that.prioridade) return false;
        if (!cod_tarefa_col.equals(that.cod_tarefa_col)) return false;
        if (!descricao.equals(that.descricao)) return false;
        if (!categoria.equals(that.categoria)) return false;
        if (!data_inicio.equals(that.data_inicio)) return false;
        return data_fim.equals(that.data_fim);
    }

    @Override
    public int hashCode() {
        int result = cod_tarefa_col.hashCode();
        result = 31 * result + descricao.hashCode();
        result = 31 * result + categoria.hashCode();
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + data_inicio.hashCode();
        result = 31 * result + data_fim.hashCode();
        result = 31 * result + prioridade;
        return result;
    }

    @Override
    public String toString() {
        return "TarefaColetivaVO{" +
                "cod_tarefa_col=" + cod_tarefa_col +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", status=" + status +
                ", data_inicio=" + data_inicio +
                ", data_fim=" + data_fim +
                ", prioridade=" + prioridade +
                '}';
    }


}
