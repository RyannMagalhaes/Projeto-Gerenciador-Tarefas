package com.taskmanager.taskmanager.repositories;


import com.taskmanager.taskmanager.models.TarefaColetiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaColetivaRepository extends JpaRepository<TarefaColetiva, Long> {
}
