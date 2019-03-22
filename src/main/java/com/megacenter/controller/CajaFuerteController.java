package com.megacenter.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.CajaFuerte;
import com.megacenter.service.ICajaFuerteService;

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




@RequestMapping(value = "/api/cajaFuertes")
@RestController
public class CajaFuerteController {

    @Autowired
    private ICajaFuerteService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CajaFuerte>> listar() {
        List<CajaFuerte>  cajaFuertes = new ArrayList<>();
        try {
            cajaFuertes = service.listar();
        } catch (Exception e) {
            new ResponseEntity<List<CajaFuerte>>(cajaFuertes ,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<CajaFuerte>>(cajaFuertes , HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<CajaFuerte> listarId(@PathVariable Integer id) {
        CajaFuerte cajaFuerte = new CajaFuerte();
        cajaFuerte = service.listarId(id);
        if (cajaFuerte == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<CajaFuerte> resource = new Resource<CajaFuerte>(cajaFuerte);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_CajaFuerte"));
        return resource;
    }

    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object> registrar(@Valid @RequestBody CajaFuerte   cajaFuerte) {
        service.registrar(cajaFuerte);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(cajaFuerte.getIdCajaFuerte()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/actualizar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody CajaFuerte cajaFuerte) {
        service.modificar(cajaFuerte);
        
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        CajaFuerte cajafuerte = service.listarId(id);
        if (cajafuerte == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }
    
    

    
}