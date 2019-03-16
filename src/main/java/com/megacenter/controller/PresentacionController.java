package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Presentacion;
import com.megacenter.service.IPresentacionService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping (value = "/api/presentaciones")
public class PresentacionController {

    @Autowired
    private IPresentacionService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Presentacion>> listar() {
        List<Presentacion> presentacion = new ArrayList<>();
        try {
            presentacion = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Presentacion>>(presentacion , HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Presentacion>>(presentacion , HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Presentacion> listarId(@PathVariable Integer id) {
        Presentacion presentacion = new Presentacion();
        presentacion = service.listarId(id);
        if (presentacion == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Presentacion> resource = new Resource<Presentacion>(presentacion);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Presentacion"));
        return resource;
    }

    @PostMapping(value= "/registrar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Presentacion presentacion) {
        service.registrar(presentacion);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(presentacion.getIdPresentacion()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Presentacion presentacion) {
        service.modificar(presentacion);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
    
    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        Presentacion pre = service.listarId(id);
        if (pre == null) {
            throw new ModeloNotFoundException("ID: " + id );
        } else {
            service.eliminar(id);
        }
    }


}