package com.taskmanager.taskmanager.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tarefa_ind_table")
public class TarefaIndividual implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_tarefa_ind;

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
}
