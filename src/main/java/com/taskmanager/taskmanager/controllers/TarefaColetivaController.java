package com.taskmanager.taskmanager.controllers;

import com.taskmanager.taskmanager.data.vo.TarefaColetivaVO;
import com.taskmanager.taskmanager.data.vo.TarefaIndividualVO;
import com.taskmanager.taskmanager.exceptions.RequiredObjectIsNullException;
import com.taskmanager.taskmanager.services.TarefaColetivaService;
import com.taskmanager.taskmanager.utils.MediaType;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<TarefaColetivaVO> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public TarefaColetivaVO save(@RequestBody TarefaColetivaVO tarefaColetivaVO) throws Exception {
        TarefaColetivaVO savedTarefaCol = service.save(tarefaColetivaVO);
        return savedTarefaCol;

    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    public TarefaColetivaVO update(@RequestBody TarefaColetivaVO tarefaColetivaVO) throws Exception {
        return service.update(tarefaColetivaVO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}
