package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Caja;
import com.megacenter.service.ICajaService;
import com.megacenter.service.impl.CajaServiceImpl;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api/cajas")
public class CajaController {

    @Autowired
    private ICajaService service;
  
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Caja>> listar() {
        List<Caja> cajas = new ArrayList<>();

        try {
            cajas = service.listar();
        } catch (Exception e) {

            return new ResponseEntity<List<Caja>>(cajas , HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Caja>>(cajas, HttpStatus.OK);
    }
    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Caja> listarId(@PathVariable Integer id) {
        Caja caja = new Caja();
        caja = service.listarId(id);
        if (caja == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Caja> resource = new Resource<Caja>(caja);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Caja"));
        return resource;
    }
    
    @PostMapping(value="/registrar" , consumes = MediaType.APPLICATION_JSON_VALUE  , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Caja caja) {
        service.registrar(caja);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(caja.getIdCaja()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @PutMapping(value = "/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar( @RequestBody Caja caja) {
        service.modificar(caja);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        Caja caja = service.listarId(id);
        if (caja == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }

    }
    
}