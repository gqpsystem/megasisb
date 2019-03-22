package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Compra;
import com.megacenter.service.ICompraService;

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




@RestController
@RequestMapping(value = "/api/compras")
public class CompraController {

    @Autowired
    private ICompraService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Compra>> listar() {
        List<Compra> compras = new ArrayList<>();
        try {
            compras = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Compra>>(compras ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
         return new ResponseEntity<List<Compra>>(compras , HttpStatus.OK);
    }

    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Compra> listarId(@PathVariable Integer id) {
        Compra compra = new Compra();
        compra = service.listarId(id);
        if (compra == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Compra> resource = new Resource<Compra>(compra);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        
        resource.add(linkTo.withRel("all_Compra"));

        return resource;
    }
    
    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Compra compra) {
       service.registrar(compra);
       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}") 
                            .buildAndExpand(compra.getIdCompra()).toUri();   
       return ResponseEntity.created(location).build();
    }
    
    @PutMapping(value="/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Compra compra) {
        service.modificar(compra);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public void eliminar(@PathVariable Integer id) {
        Compra compra = service.listarId(id);
        if (compra == null) {
            throw new ModeloNotFoundException("ID: "+ id);
        } else {
            service.eliminar(id);
        }
    }
    
}