package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Dolencia;
import com.megacenter.service.IDolenciaService;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping (value = "/api/dolencias")
public class DolenciaController {

    @Autowired
    private IDolenciaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dolencia>> listar() {
        List<Dolencia> dolencias = new ArrayList<>();
        try {
            dolencias = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Dolencia>>(dolencias , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Dolencia>>(dolencias , HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Dolencia> listarId(@PathVariable("id") Integer id) {
        Dolencia dolencia = new Dolencia();
        dolencia = service.listarId(id);
        if (dolencia == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Dolencia> resource = new Resource<Dolencia>(dolencia);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Dolencia"));

        return resource;
    }

    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Dolencia dolencia) {
        service.registrar(dolencia);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(dolencia.getIdDolencia()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @PutMapping(value="/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Dolencia dolencia) {
        service.modificar(dolencia);

        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public void eliminar(@PathVariable Integer id) {
        Dolencia dolencia = service.listarId(id);
        if (dolencia == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
            
        }
    }

}