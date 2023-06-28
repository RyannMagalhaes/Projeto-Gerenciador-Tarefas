package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.controllers.TarefaIndividualController;
import com.taskmanager.taskmanager.data.vo.TarefaIndividualVO;
import com.taskmanager.taskmanager.exceptions.RequiredObjectIsNullException;
import com.taskmanager.taskmanager.exceptions.ResourceNotFoundException;
import com.taskmanager.taskmanager.mapper.DozerMapper;
import com.taskmanager.taskmanager.models.TarefaIndividual;
import com.taskmanager.taskmanager.repositories.TarefaIndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class TarefaIndividualService {
    @Autowired
    private TarefaIndividualRepository repository;

    public List<TarefaIndividualVO> findAll() {
        var tarefaColDbList = repository.findAll();
        return DozerMapper.parseListObject(tarefaColDbList, TarefaIndividualVO.class);
    }

    public TarefaIndividualVO findById(Long id) throws Exception {
        var usuarioDbList = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        return DozerMapper.parseObject(usuarioDbList, TarefaIndividualVO.class);
    }

    public TarefaIndividualVO save(TarefaIndividualVO tarefaIndividualVO) throws Exception {
        if (tarefaIndividualVO == null) {
            throw new RequiredObjectIsNullException();
        }


        TarefaIndividual tarefaIndividual = DozerMapper.parseObject(tarefaIndividualVO, TarefaIndividual.class);
        TarefaIndividual tarefaIndividualDB = repository.save(tarefaIndividual);
        TarefaIndividualVO savedTarefaInd = DozerMapper.parseObject(tarefaIndividualDB, TarefaIndividualVO.class);
        savedTarefaInd.add(linkTo(methodOn(TarefaIndividualController.class).findById(savedTarefaInd.getCod_tarefa_ind())).withSelfRel());
        return savedTarefaInd;

    }

//    public TarefaIndividualVO save(TarefaIndividualVO tarefaIndividualVO) throws Exception {
//        if (tarefaIndividualVO == null) {
//            throw new RequiredObjectIsNullException();
//        }
//
//        try {
//            TarefaIndividualVO savedTarefaInd = null;
//            if (savedTarefaInd.getPrioriadade() > 5 || savedTarefaInd.getPrioriadade() < 1) {
//                throw new IllegalArgumentException();
//            } else {
//
//                TarefaIndividual tarefaIndividual = DozerMapper.parseObject(tarefaIndividualVO, TarefaIndividual.class);
//                TarefaIndividual tarefaIndividualDB = repository.save(tarefaIndividual);
//                savedTarefaInd = DozerMapper.parseObject(tarefaIndividualDB, TarefaIndividualVO.class);
//                savedTarefaInd.add(linkTo(methodOn(TarefaIndividualController.class).findById(savedTarefaInd.getCod_tarefa_ind())).withSelfRel());
//                return savedTarefaInd;
//            }
//        } catch (IllegalArgumentException e) {
//            throw new IllegalArgumentException("Invalid priority value");
//        }
//    }

    public TarefaIndividualVO update(TarefaIndividualVO tarefaIndividualVO) throws Exception {
        if(tarefaIndividualVO == null) throw new RequiredObjectIsNullException();

        var dbTarefaInd = repository.findById(tarefaIndividualVO.getCod_tarefa_ind()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        TarefaIndividual tarefaIndividual = DozerMapper.parseObject(tarefaIndividualVO, TarefaIndividual.class);
        tarefaIndividual = repository.save(tarefaIndividual);
        tarefaIndividualVO = DozerMapper.parseObject(tarefaIndividual, TarefaIndividualVO.class);
        tarefaIndividualVO.add(linkTo(methodOn(TarefaIndividualController.class).findById(tarefaIndividualVO.getCod_tarefa_ind())).withSelfRel());
        return tarefaIndividualVO;
    }

    public String delete(Long id) {
        var dbTarefaInd = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.deleteById(id);
        return "Tarefa Individual with id " + id + " has been deleted!";
    }

    public void marcarComoConcluida(Long id) throws ResourceNotFoundException {
        TarefaIndividual tarefaIndividual = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TarefaIndividual not found for id: " + id));

        tarefaIndividual.setStatus(true);
        repository.save(tarefaIndividual);
    }

    public List<TarefaIndividualVO> findByStatusAndCategoria(boolean status, String categoria) {
        List<TarefaIndividual> tarefas = repository.findByStatusAndCategoria(status, categoria);
        return DozerMapper.parseListObject(tarefas, TarefaIndividualVO.class);
    }
    public List<TarefaIndividualVO> findByNome(String nome) {
        List<TarefaIndividual> tarefas = repository.findByNome(nome);
        return DozerMapper.parseListObject(tarefas, TarefaIndividualVO.class);
    }

}
