package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.data.vo.UsuarioVO;
import com.taskmanager.taskmanager.exceptions.ResourceNotFoundException;
import com.taskmanager.taskmanager.mapper.DozerMapper;
import com.taskmanager.taskmanager.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioVO> findAll() {
        var usuarioDbList = repository.findAll();
        return DozerMapper.parseListObject(usuarioDbList, UsuarioVO.class);
    }

    public UsuarioVO findById(Long id) throws Exception {
        var usuarioDbList = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        return DozerMapper.parseObject(usuarioDbList, UsuarioVO.class);
    }
}
