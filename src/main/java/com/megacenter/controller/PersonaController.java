package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Persona;
import com.megacenter.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping ( value = "/api/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service ;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> listar() {
        List<Persona> personas = new ArrayList<>();
        try {
            personas = service.listar();
        } catch (Exception e) {
            new ResponseEntity<>(personas , HttpStatus.INTERNAL_SERVER_ERROR);  
        }
        return new ResponseEntity<List<Persona>>(personas , HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Persona> listarId(@PathVariable Integer id) {
        Persona persona = new Persona();
        persona = service.listarId(id);
        if (persona == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Persona> resource = new Resource<Persona>(persona);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Persona"));
        return resource;
    }
    
    @PostMapping(value="/registrar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Persona persona ) {
        service.registrar(persona);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(persona.getIdPersona()).toUri();
        return ResponseEntity.created(location).build();                
    }
    
    @PutMapping(value="/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Persona persona) {
        service.modificar(persona);        
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public void eliminar(@PathVariable Integer id) {
        Persona persona = service.listarId(id);
        if (persona == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }
}