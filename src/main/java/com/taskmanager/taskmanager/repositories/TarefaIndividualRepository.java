package com.taskmanager.taskmanager.repositories;

import com.taskmanager.taskmanager.models.TarefaIndividual;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TarefaIndividualRepository extends JpaRepository<TarefaIndividual,Long> {

    @Transactional
    @Modifying
    @Query("UPDATE TarefaIndividual t SET t.status = true WHERE t.cod_tarefa_ind = :id")
    void marcarComoConcluida(Long id);

    @Query("SELECT t FROM TarefaIndividual t WHERE t.status = :status AND t.categoria = :categoria")
    List<TarefaIndividual> findByStatusAndCategoria(@Param("status") boolean status, @Param("categoria") String categoria);

    @Query("SELECT t FROM TarefaIndividual t WHERE t.nome = :nome")
    List<TarefaIndividual> findByNome(@Param("nome") String nome);

}
