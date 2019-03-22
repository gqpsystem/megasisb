package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.ControlAsistencia;
import com.megacenter.service.IControlAsistenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequestMapping(value = "/api/controlAsistencias")
@RestController
public class ControlAsitenciaController {

    @Autowired
    private IControlAsistenciaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ControlAsistencia>> listar() {
        List<ControlAsistencia> asistencias = new ArrayList<>();
        try {
            asistencias = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<ControlAsistencia>>(asistencias , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<ControlAsistencia>>(asistencias , HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<ControlAsistencia> listarId(@PathVariable Integer id) {
        ControlAsistencia asistencia = new ControlAsistencia();
        asistencia = service.listarId(id);
        if (asistencia == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<ControlAsistencia> resource = new Resource<ControlAsistencia>(asistencia);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        
        resource.add(linkTo.withRel("all_Controller"));
        return resource;
    }
    

    @PostMapping(value = "/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody ControlAsistencia asistencia) {
        service.registrar(asistencia);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(asistencia.getIdControl()).toUri();
                        
        return ResponseEntity.created(location).build();
    }
    
    @PutMapping(value="/actualizar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody ControlAsistencia asistencia){
        service.modificar(asistencia);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping ( value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        ControlAsistencia asistencia = service.listarId(id);
        if (asistencia == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }

    
}