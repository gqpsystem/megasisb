package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Persona;
import com.megacenter.model.Personal;

import com.megacenter.representation.PersonalRepresentation;
import com.megacenter.service.IPersonaService;
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
import org.springframework.web.bind.annotation.RequestBody;
import com.megacenter.service.IPersonalService;



@RestController
@RequestMapping(value = "/api/personales")
public class PersonalController {

    @Autowired
    private IPersonalService service ;

    @Autowired
    private IPersonaService personaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Personal>> listar() {
        List<Personal> colaborador = new ArrayList<>();
        try {
            colaborador = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Personal>>(colaborador , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Personal>>(colaborador , HttpStatus.OK);
    }

    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Personal> listarId(@PathVariable Integer id){
        Personal colaborador = new Personal();
        colaborador = service.listarId(id);
        if (colaborador == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Personal> resource = new Resource<Personal>(colaborador);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Personal"));

        return resource;
    }

    @PostMapping(value="/registrar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody PersonalRepresentation rep) {
        Persona persona = personaService.registrar(rep.getPersona());
        rep.getPersonal().setPersona(persona);
        Personal personal = service.registrar(rep.getPersonal());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(personal.getIdPersonal()).toUri();
        return ResponseEntity.created(location).build();
        
    }

    @PutMapping(value="/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody PersonalRepresentation rep) {
        Persona persona = personaService.modificar(rep.getPersona());
        rep.getPersonal().setPersona(persona);
        Personal personal = service.modificar(rep.getPersonal());
        return new ResponseEntity<Object>(HttpStatus.OK);

    }

    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id){
        Personal colaborador = service.listarId(id);
        if (colaborador == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }
}
