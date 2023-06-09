package com.taskmanager.taskmanager.data.vo;

import jakarta.persistence.Column;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

public class TarefaIndividualVO extends RepresentationModel<TarefaIndividualVO> implements Serializable {

    private Long cod_tarefa_ind;

    private String nome;
    private String descricao;

    private String categoria;

    private boolean status;

    private Date data_inicio;

    private Date data_fim;

    private int prioriadade;

    public TarefaIndividualVO(Long cod_tarefa_ind, String nome, String descricao, String categoria, boolean status, Date data_inicio, Date data_fim, int prioriadade) {
        this.cod_tarefa_ind = cod_tarefa_ind;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = status;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.prioriadade = prioriadade;
    }

    public TarefaIndividualVO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCod_tarefa_ind() {
        return cod_tarefa_ind;
    }

    public void setCod_tarefa_ind(Long cod_tarefa_ind) {
        this.cod_tarefa_ind = cod_tarefa_ind;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TarefaIndividualVO that = (TarefaIndividualVO) o;

        if (status != that.status) return false;
        if (prioriadade != that.prioriadade) return false;
        if (!cod_tarefa_ind.equals(that.cod_tarefa_ind)) return false;
        if (!nome.equals(that.nome)) return false;
        if (!descricao.equals(that.descricao)) return false;
        if (!categoria.equals(that.categoria)) return false;
        if (!data_inicio.equals(that.data_inicio)) return false;
        return data_fim.equals(that.data_fim);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + cod_tarefa_ind.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + descricao.hashCode();
        result = 31 * result + categoria.hashCode();
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + data_inicio.hashCode();
        result = 31 * result + data_fim.hashCode();
        result = 31 * result + prioriadade;
        return result;
    }

    @Override
    public String toString() {
        return "TarefaIndividualVO{" +
                "cod_tarefa_ind=" + cod_tarefa_ind +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", status=" + status +
                ", data_inicio=" + data_inicio +
                ", data_fim=" + data_fim +
                ", prioriadade=" + prioriadade +
                '}';
    }
}
