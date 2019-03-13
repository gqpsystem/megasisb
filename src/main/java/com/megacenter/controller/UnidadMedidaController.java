package com.megacenter.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.megacenter.model.UnidadMedida;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.service.IUnidadMedidaService;

@RestController
@RequestMapping(value = "/api/unidadMedidas")
public class UnidadMedidaController {

    @Autowired
    private IUnidadMedidaService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UnidadMedida>> listar() {
        List<UnidadMedida> unidadMedidas = new ArrayList<>();
        try {
            unidadMedidas = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<UnidadMedida>>(unidadMedidas, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<UnidadMedida>>(unidadMedidas, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<UnidadMedida> listarId(@PathVariable("id") Integer id) {
        UnidadMedida unidadMedida = new UnidadMedida();
        unidadMedida = service.listarId(id);
        if (unidadMedida == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<UnidadMedida> resource = new Resource<UnidadMedida>(unidadMedida);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_UnidadMedidas"));
        return resource;
    }

    @PostMapping(value="/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody UnidadMedida unidadMedida) {
        service.registrar(unidadMedida);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(unidadMedida.getIdUnidadmedida()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping(value="/actualizar" ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody UnidadMedida unidadMedida) {
        service.modificar(unidadMedida);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        UnidadMedida und = service.listarId(id);
        if (und == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }
}