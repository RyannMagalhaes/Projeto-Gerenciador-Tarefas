package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.controllers.TarefaColetivaController;
import com.taskmanager.taskmanager.data.vo.TarefaColetivaVO;
import com.taskmanager.taskmanager.exceptions.RequiredObjectIsNullException;
import com.taskmanager.taskmanager.exceptions.ResourceNotFoundException;
import com.taskmanager.taskmanager.mapper.DozerMapper;
import com.taskmanager.taskmanager.models.TarefaColetiva;
import com.taskmanager.taskmanager.repositories.TarefaColetivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class TarefaColetivaService {
    @Autowired
    private TarefaColetivaRepository repository;

    public List<TarefaColetivaVO> findAll() {
        var tarefaColDbList = repository.findAll();
        return DozerMapper.parseListObject(tarefaColDbList, TarefaColetivaVO.class);
    }

    public TarefaColetivaVO findById(Long id) throws Exception {
        var tarefaColDbList = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        return DozerMapper.parseObject(tarefaColDbList, TarefaColetivaVO.class);
    }

    public TarefaColetivaVO save(TarefaColetivaVO tarefaColetivaVO) throws Exception {
        if (tarefaColetivaVO == null) {
            throw new RequiredObjectIsNullException();
        }

        Long id = tarefaColetivaVO.getCod_tarefa_col(); //

        if (verificarIdExistente(id)) {
            throw new Exception("ID already exists.");
        }

        TarefaColetiva tarefaColetiva = DozerMapper.parseObject(tarefaColetivaVO, TarefaColetiva.class);
        TarefaColetiva tarefaColetivaDB = repository.save(tarefaColetiva);
        TarefaColetivaVO savedTarefaCol = DozerMapper.parseObject(tarefaColetivaDB, TarefaColetivaVO.class);
        savedTarefaCol.add(linkTo(methodOn(TarefaColetivaController.class).findById(savedTarefaCol.getCod_tarefa_col())).withSelfRel());
        return savedTarefaCol;
    }

    public TarefaColetivaVO update(TarefaColetivaVO tarefaColetivaVO) throws Exception {
        if(tarefaColetivaVO == null) throw new RequiredObjectIsNullException();

        var dbTarefaCol = repository.findById(tarefaColetivaVO.getCod_tarefa_col()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        TarefaColetiva tarefaColetiva = DozerMapper.parseObject(tarefaColetivaVO, TarefaColetiva.class);
        tarefaColetiva = repository.save(tarefaColetiva);
        tarefaColetivaVO = DozerMapper.parseObject(tarefaColetiva, TarefaColetivaVO.class);
        tarefaColetivaVO.add(linkTo(methodOn(TarefaColetivaController.class).findById(tarefaColetivaVO.getCod_tarefa_col())).withSelfRel());
        return tarefaColetivaVO;
    }

    public String delete(Long id) {
        var dbTarefaCol = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.deleteById(id);
        return "Tarefa Coletiva with id " + id + " has been deleted!";
    }

    public boolean verificarIdExistente(Long id) {
        return repository.existsById(id);
    }
}
