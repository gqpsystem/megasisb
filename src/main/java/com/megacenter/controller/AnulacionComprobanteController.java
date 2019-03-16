package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.AnulacionComprobante;
import com.megacenter.service.IAnulacionComprobanteService;

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


@RestController
@RequestMapping(value = "/api/anulacionComprobantes")
public class AnulacionComprobanteController {

    @Autowired
    private IAnulacionComprobanteService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AnulacionComprobante>> listar() {
        List<AnulacionComprobante> anulacionComprobantes = new ArrayList<>();
        try {
            anulacionComprobantes = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<AnulacionComprobante>>(anulacionComprobantes,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<AnulacionComprobante>>(anulacionComprobantes, HttpStatus.OK);
    }

    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<AnulacionComprobante> listarId(@PathVariable("id") Integer id) {
        AnulacionComprobante anulacionComprobante = new AnulacionComprobante();

        anulacionComprobante = service.listarId(id);
        if (anulacionComprobante == null) {
            throw new ModeloNotFoundException("ID:" + id );
        }

        Resource<AnulacionComprobante> resource = new Resource<AnulacionComprobante>(anulacionComprobante);
        ControllerLinkBuilder linkto =linkTo(methodOn(this.getClass()).listar());
        resource.add(linkto.withRel("all_AnulacionComprobante"));


        return resource;
    }

    @PostMapping(value="/registrar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object> registrar(@Valid @RequestBody AnulacionComprobante anulacionComprobante) {
        service.registrar(anulacionComprobante);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(anulacionComprobante.getIdAnulacion()).toUri();
        ;
        
        return ResponseEntity.created(location).build();
    }


    @PutMapping(value="/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar( @RequestBody AnulacionComprobante anulacionComprobante) {
        service.modificar(anulacionComprobante);
        
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        AnulacionComprobante comprobante = service.listarId(id);
        if (comprobante==null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }


}