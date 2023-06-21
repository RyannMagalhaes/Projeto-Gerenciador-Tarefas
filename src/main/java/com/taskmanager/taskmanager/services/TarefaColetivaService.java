package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.data.vo.TarefaColetivaVO;
import com.taskmanager.taskmanager.data.vo.TarefaIndividualVO;
import com.taskmanager.taskmanager.exceptions.ResourceNotFoundException;
import com.taskmanager.taskmanager.mapper.DozerMapper;
import com.taskmanager.taskmanager.repositories.TarefaColetivaRepository;
import com.taskmanager.taskmanager.repositories.TarefaIndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
