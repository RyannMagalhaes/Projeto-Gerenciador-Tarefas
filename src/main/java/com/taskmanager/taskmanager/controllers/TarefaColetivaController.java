package com.taskmanager.taskmanager.controllers;

import com.taskmanager.taskmanager.data.vo.TarefaColetivaVO;
import com.taskmanager.taskmanager.data.vo.TarefaIndividualVO;
import com.taskmanager.taskmanager.exceptions.RequiredObjectIsNullException;
import com.taskmanager.taskmanager.exceptions.ResourceNotFoundException;
import com.taskmanager.taskmanager.services.TarefaColetivaService;
import com.taskmanager.taskmanager.utils.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(
            summary = "Find Tarefa Coletiva by Id", description = "Finds Group Task by its name", tags = {"TarefaColetiva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public TarefaColetivaVO findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    @Operation(
            summary = "Find All Tarefa Coletiva", description = "Returns all group tasks", tags = {"TarefaColetiva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<TarefaColetivaVO> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
            summary = "Save Tarefa Coletiva", description = "Creates a Group Task", tags = {"TarefaColetiva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public TarefaColetivaVO save(@RequestBody TarefaColetivaVO tarefaColetivaVO) throws Exception {
        TarefaColetivaVO savedTarefaCol = service.save(tarefaColetivaVO);
        return savedTarefaCol;

    }

    @PutMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
            summary = "Update Tarefa Coletiva", description = "Updates a Group Task", tags = {"TarefaColetiva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public TarefaColetivaVO update(@RequestBody TarefaColetivaVO tarefaColetivaVO) throws Exception {
        return service.update(tarefaColetivaVO);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Tarefa Coletiva", description = "Deletes a Group Task", tags = {"TarefaColetiva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public String delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @PutMapping("/{id}/concluir")
    @Operation(
            summary = "Marcar Tarefa Coletiva Como Concluída", description = "Define a individual task as completed", tags = {"TarefaColetiva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<String> marcarComoConcluida(@PathVariable("id") Long id) throws ResourceNotFoundException {
        try {
            service.marcarComoConcluida(id);
            return ResponseEntity.ok("Tarefa Coletiva concluída com sucesso.");
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }


    @GetMapping("/filtro-coletiva")
    @Operation(
            summary = "Find Tarefa Coletiva by Status and Category", description = "Finds Group Tasks by they status and/or category", tags = {"TarefaColetiva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<TarefaColetivaVO> findByStatusAndCategoria(@RequestParam("status") boolean status, @RequestParam("categoria") String categoria) {
        return service.findByStatusAndCategoria(status, categoria);
    }

    @GetMapping("/filtro-por-nome-coletiva")
    @Operation(
            summary = "Find Tarefa Coletiva by Nome", description = "Finds Group Tasks by their name", tags = {"TarefaColetiva"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<TarefaColetivaVO> findByNome(@RequestParam("nome") String nome) {
        return service.findByNome(nome);
    }
}
