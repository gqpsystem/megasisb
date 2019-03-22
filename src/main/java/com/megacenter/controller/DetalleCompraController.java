package com.megacenter.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.DetalleCompra;
import com.megacenter.service.IDetalleCompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;




@RequestMapping(value = "/api/detalleCompras")
@RestController
public class DetalleCompraController {

    @Autowired
    private IDetalleCompraService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DetalleCompra>> listar() {
        List<DetalleCompra> compras = new ArrayList<>();
        try {
            compras = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<DetalleCompra>>(compras ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<DetalleCompra>>(compras , HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Resource<DetalleCompra> listarId(@PathVariable Integer id) {
        DetalleCompra   compra = new DetalleCompra();
        compra = service.listarId(id);
        if (compra == null) {
            throw new ModeloNotFoundException("ID: "+ id);
        }
        Resource<DetalleCompra> resource = new Resource<DetalleCompra>(compra);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_DetalleCompra"));

        return resource;
    }
    
    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody DetalleCompra compra) {
        service.registrar(compra);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(compra.getIdDetalleCompra()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/actualizar" , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar( @RequestBody DetalleCompra compra) {
        service.modificar(compra);
        
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id){
        DetalleCompra compra = service.listarId(id);
        if ( compra == null) {
            throw new ModeloNotFoundException("ID: "+ id);
        } else{
            service.eliminar(id);
        }


    }
}
