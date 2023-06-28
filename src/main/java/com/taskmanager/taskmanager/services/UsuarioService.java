package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.controllers.UsuarioController;
import com.taskmanager.taskmanager.data.vo.UsuarioVO;
import com.taskmanager.taskmanager.exceptions.RequiredObjectIsNullException;
import com.taskmanager.taskmanager.exceptions.ResourceNotFoundException;
import com.taskmanager.taskmanager.mapper.DozerMapper;
import com.taskmanager.taskmanager.models.Usuario;
import com.taskmanager.taskmanager.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    public UsuarioVO save(UsuarioVO usuarioVO) throws Exception {
        if (usuarioVO == null) {
            throw new RequiredObjectIsNullException();
        }

        Usuario user = DozerMapper.parseObject(usuarioVO, Usuario.class);
        Usuario userDb = repository.save(user);
        UsuarioVO savedUsuarioVO = DozerMapper.parseObject(userDb, UsuarioVO.class);
        savedUsuarioVO.add(linkTo(methodOn(UsuarioController.class).findById(savedUsuarioVO.getCod_user())).withSelfRel());

        return savedUsuarioVO;
    }

    public UsuarioVO update(UsuarioVO userVO) throws Exception {
        if(userVO == null) throw new RequiredObjectIsNullException();

        var dbUser = repository.findById(userVO.getCod_user()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        Usuario user = DozerMapper.parseObject(userVO, Usuario.class);
        user = repository.save(user);
        userVO = DozerMapper.parseObject(user, UsuarioVO.class);
        userVO.add(linkTo(methodOn(UsuarioController.class).findById(userVO.getCod_user())).withSelfRel());
        return userVO;
    }

    public String delete(Long id) {
        var dbUser = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.deleteById(id);
        return "User with id " + id + " has been deleted!";
    }
}
