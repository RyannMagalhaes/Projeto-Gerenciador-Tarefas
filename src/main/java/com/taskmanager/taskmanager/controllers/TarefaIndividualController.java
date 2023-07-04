package com.taskmanager.taskmanager.controllers;

import com.taskmanager.taskmanager.data.vo.TarefaColetivaVO;
import com.taskmanager.taskmanager.data.vo.TarefaIndividualVO;
import com.taskmanager.taskmanager.data.vo.UsuarioVO;
import com.taskmanager.taskmanager.exceptions.RequiredObjectIsNullException;
import com.taskmanager.taskmanager.exceptions.ResourceNotFoundException;
import com.taskmanager.taskmanager.services.TarefaIndividualService;
import com.taskmanager.taskmanager.services.UsuarioService;
import com.taskmanager.taskmanager.utils.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tarefa_individual")
@Tag(name = "TarefaIndividual", description = "Endpoint for managing Tarefas individuais")
public class TarefaIndividualController {

    @Autowired
    private TarefaIndividualService service;

    @GetMapping("/{id}")
    @Operation(
            summary = "Find by Id", description = "Finds a individual task by ID", tags = {"TarefaIndividual"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = UsuarioVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public TarefaIndividualVO findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    @Operation(
            summary = "FindAll", description = "Returns all individual tasks", tags = {"TarefaIndividual"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = UsuarioVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<TarefaIndividualVO> findAll(){
        return service.findAll();
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
            summary = "Save tarefa individual.", description = "Creates a individual task", tags = {"TarefaIndividual"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = TarefaIndividualVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<TarefaIndividualVO> save(@RequestBody TarefaIndividualVO tarefaIndividualVO) {
        try {
            TarefaIndividualVO savedTarefaInd = service.save(tarefaIndividualVO);
            return ResponseEntity.ok(savedTarefaInd);
        } catch (RequiredObjectIsNullException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
            consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Update Tarefa Individual.", description = "Updates a individual task", tags = {"TarefaIndividual"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(
                                    schema = @Schema(implementation = UsuarioVO.class)
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public TarefaIndividualVO update(@RequestBody TarefaIndividualVO tarefaIndividualVO) throws Exception {
        return service.update(tarefaIndividualVO);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete individual task", description = "Deletes a individual task by its ID.", tags = {"TarefaIndividual"},
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
            summary = "marcar tarefa individual como concluída", description = "Define a individual task as completed", tags = {"TarefaIndividual"},
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
            return ResponseEntity.ok("Tarefa individual concluída com sucesso.");
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/filtro")
    @Operation(
            summary = "Find Tarefa Individual by Status and Category", description = "Finds Individual Tasks by they status and/or category", tags = {"TarefaIndividual"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<TarefaIndividualVO> findByStatusAndCategoria(@RequestParam("status") boolean status, @RequestParam("categoria") String categoria) {
        return service.findByStatusAndCategoria(status, categoria);
    }

    @GetMapping("/filtro-por-nome")
    @Operation(
            summary = "Find Tarefa Individual by Nome", description = "Finds Individual Tasks by their name", tags = {"TarefaIndividual"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    public List<TarefaIndividualVO> findByNome(@RequestParam("nome") String nome) {
        return service.findByNome(nome);
    }
}


// Para testar
// {
//  "cod_tarefa_ind": 0,
//  "descricao": "trabalho camillo",
//  "categoria": "faculdade",
//  "status": false,
//  "data_inicio": "2022-02-04T00:20:04.717Z",
//  "data_fim": "2024-06-28T00:20:04.717Z",
//  "prioriadade": 2,
//  "_links": {
//    "additionalProp1": {
//      "href": "string",
//      "hreflang": "string",
//      "title": "string",
//      "type": "string",
//      "deprecation": "string",
//      "profile": "string",
//      "name": "string",
//      "templated": true
//    },
//    "additionalProp2": {
//      "href": "string",
//      "hreflang": "string",
//      "title": "string",
//      "type": "string",
//      "deprecation": "string",
//      "profile": "string",
//      "name": "string",
//      "templated": true
//    },
//    "additionalProp3": {
//      "href": "string",
//      "hreflang": "string",
//      "title": "string",
//      "type": "string",
//      "deprecation": "string",
//      "profile": "string",
//      "name": "string",
//      "templated": true
//    }
//  }
//}
