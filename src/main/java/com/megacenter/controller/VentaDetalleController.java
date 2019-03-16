package com.megacenter.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.megacenter.model.UnidadMedida;
import com.megacenter.model.VentaDetalle;
import com.megacenter.service.IVentaDetalleService;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * VentaDetalleController
 */
@RequestMapping(value = "/api/ventaDetalles")
@RestController
public class VentaDetalleController {

    @Autowired
    private IVentaDetalleService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VentaDetalle>> listar(){
        List<VentaDetalle> detalle = new ArrayList<>();
        try{
            detalle = service.listar();
        }catch(Exception e){
            return new ResponseEntity<List<VentaDetalle>>(detalle, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<VentaDetalle>>(detalle , HttpStatus.INTERNAL_SERVER_ERROR);
    }    

    @GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public Resource<VentaDetalle> listarId(@PathVariable Integer id) {
        VentaDetalle detalle = new VentaDetalle();
        detalle = service.listarId(id);
        if(detalle ==null){
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<VentaDetalle> resource = new Resource<VentaDetalle>(detalle);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_VentaDetalle"));

        return resource;
    }

    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody VentaDetalle detalle) {
        service.registrar(detalle);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                            .buildAndExpand(detalle.getIdVentaDetalle()).toUri();
        
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/actualizar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody VentaDetalle detalle) {
        service.registrar(detalle);

        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id){
        VentaDetalle detalle = service.listarId(id);
        if (detalle == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }

    }

    
}