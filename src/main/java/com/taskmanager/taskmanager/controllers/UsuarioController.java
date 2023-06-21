package com.taskmanager.taskmanager.controllers;

import com.taskmanager.taskmanager.data.vo.UsuarioVO;
import com.taskmanager.taskmanager.models.Usuario;
import com.taskmanager.taskmanager.services.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
@Tag(name = "Usuario", description = "Endpoint for managing Users")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    public UsuarioVO  findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    public List<UsuarioVO> findAll(){
        return service.findAll();
    }
}
