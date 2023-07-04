package com.taskmanager.taskmanager.repositories;


import com.taskmanager.taskmanager.models.TarefaColetiva;
import com.taskmanager.taskmanager.models.TarefaIndividual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaColetivaRepository extends JpaRepository<TarefaColetiva, Long> {

    @Query("UPDATE TarefaColetiva t SET t.status = true WHERE t.cod_tarefa_col = :id")
    void marcarComoConcluida(Long id);

    @Query("SELECT t FROM TarefaColetiva t WHERE t.status = :status AND t.categoria = :categoria")
    List<TarefaColetiva> findByStatusAndCategoria(@Param("status") boolean status, @Param("categoria") String categoria);

    @Query("SELECT t FROM TarefaColetiva t WHERE t.nome = :nome")
    List<TarefaColetiva> findByNome(@Param("nome") String nome);
}
