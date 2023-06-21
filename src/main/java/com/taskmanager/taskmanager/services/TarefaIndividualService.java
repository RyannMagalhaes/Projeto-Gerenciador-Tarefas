package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.data.vo.TarefaIndividualVO;
import com.taskmanager.taskmanager.data.vo.UsuarioVO;
import com.taskmanager.taskmanager.exceptions.ResourceNotFoundException;
import com.taskmanager.taskmanager.mapper.DozerMapper;
import com.taskmanager.taskmanager.repositories.TarefaIndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
