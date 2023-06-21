package com.taskmanager.taskmanager.controllers;

import com.taskmanager.taskmanager.data.vo.TarefaColetivaVO;
import com.taskmanager.taskmanager.data.vo.TarefaIndividualVO;
import com.taskmanager.taskmanager.services.TarefaIndividualService;
import com.taskmanager.taskmanager.services.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tarefa_individual")
@Tag(name = "TarefaIndividual", description = "Endpoint for managing Tarefas individuais")
public class TarefaIndividualController {

    @Autowired
    private TarefaIndividualService service;

    @GetMapping("/{id}")
    public TarefaIndividualVO findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    public List<TarefaIndividualVO> findAll(){
        return service.findAll();
    }
}
