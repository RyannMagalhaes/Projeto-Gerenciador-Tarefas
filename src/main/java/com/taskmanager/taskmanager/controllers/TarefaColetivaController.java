package com.taskmanager.taskmanager.controllers;

import com.taskmanager.taskmanager.data.vo.TarefaColetivaVO;
import com.taskmanager.taskmanager.data.vo.UsuarioVO;
import com.taskmanager.taskmanager.services.TarefaColetivaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tarefa_coletiva")
@Tag(name = "TarefaColetiva", description = "Endpoint for managing Tarefas individuais")
public class TarefaColetivaController {

    @Autowired
    private TarefaColetivaService service;


    @GetMapping("/{id}")
    public TarefaColetivaVO findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    public List<TarefaColetivaVO> findAll(){
        return service.findAll();
    }
}
