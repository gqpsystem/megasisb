package com.megacenter.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
import com.megacenter.model.TipoComprobante;
import com.megacenter.service.ITipoComprobanteService;



@RestController
@RequestMapping(value = "/api/tipoComprobantes")
public class TipoComprobanteController {

    @Autowired
    private ITipoComprobanteService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoComprobante>> listar() {
        List<TipoComprobante> comprobante = new ArrayList<>();
        try {
            comprobante = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<TipoComprobante>>(comprobante, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<TipoComprobante>>(comprobante, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<TipoComprobante> listarId(@PathVariable("id") Integer id) {
        TipoComprobante comprobante = new TipoComprobante();
        comprobante = service.listarId(id);
        if (comprobante == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<TipoComprobante> resource = new Resource<TipoComprobante>(comprobante);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_TipoComprobante"));
        return resource;
    }

    @PostMapping(value="/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody TipoComprobante comprobante) {
        service.registrar(comprobante);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(comprobante.getIdTipoComprobante()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody TipoComprobante comprobante) {
        service.modificar(comprobante);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        TipoComprobante und = service.listarId(id);
        if (und == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }
    
}