package com.taskmanager.taskmanager.repositories;

import com.taskmanager.taskmanager.models.TarefaIndividual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaIndividualRepository extends JpaRepository<TarefaIndividual,Long> {
}
