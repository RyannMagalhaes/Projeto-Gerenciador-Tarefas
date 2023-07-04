package com.taskmanager.taskmanager.controllers;

import com.taskmanager.taskmanager.data.vo.UsuarioVO;
import com.taskmanager.taskmanager.exceptions.RequiredObjectIsNullException;
import com.taskmanager.taskmanager.models.Usuario;
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
    @RequestMapping("api/v1/usuario")
@Tag(name = "Usuario", description = "Endpoint for managing Users")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping("/{id}")
    @Operation(
            summary = "Find a user", description = "Find a user by it's id", tags = {"Usuario"},
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
    public UsuarioVO  findById(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/findAll")
    @Operation(
            summary = "Find All", description = "Returns all Users", tags = {"Usuario"},
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
    public List<UsuarioVO> findAll(){
        return service.findAll();
    }

    @PostMapping(name = "{/save}",consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
            produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(
            summary = "Create a user.", description = "Create a user.", tags = {"Usuario"},
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
    public ResponseEntity<UsuarioVO> save(@RequestBody UsuarioVO userVO) {
        try {
            UsuarioVO savedUserVO = service.save(userVO);
            return ResponseEntity.ok(savedUserVO);
        } catch (RequiredObjectIsNullException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        }

    @PutMapping(name = "/update" ,produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML },
            consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
    @Operation(
            summary = "Update a user.", description = "Update a user.", tags = {"Usuario"},
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
    public UsuarioVO update(@RequestBody UsuarioVO userVO) throws Exception {
        return service.update(userVO);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletes a User by ID.", description = "Deletes a User by ID.", tags = {"Usuario"},
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

    }

