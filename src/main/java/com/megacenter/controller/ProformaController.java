package com.megacenter.controller;


import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Proforma;
import com.megacenter.service.IProformaService;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(value = "/api/proformas")
@RestController
public class ProformaController {

    @Autowired
    private IProformaService service;
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Proforma>> listar() {
        List<Proforma>  proforma = new ArrayList<>();
        try{
            proforma = service.listar();
        } catch(Exception e) {
            return new ResponseEntity<List<Proforma>>(proforma , HttpStatus.INTERNAL_SERVER_ERROR) ; 
        }
        return new ResponseEntity<List<Proforma>>(proforma , HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Proforma> listarId(@PathVariable Integer id) {
        Proforma proforma = new Proforma()  ;
        proforma = service.listarId(id);
        if (proforma == null) {
            throw new ModeloNotFoundException("ID + " + id ) ;
        }
        Resource<Proforma> resource = new Resource<Proforma>(proforma) ;
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Proforma"));
        return resource;
    }
    

    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE ,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Proforma proforma) {
        service.registrar(proforma);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(proforma.getIdProforma()).toUri() ;
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/actualizar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Proforma proforma){
        service.modificar(proforma);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value ="/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        Proforma proforma = service.listarId(id);
        if (proforma == null) {
            throw new ModeloNotFoundException("ID: "+ id);
        } else {
            service.eliminar(id);
        }
    }


}