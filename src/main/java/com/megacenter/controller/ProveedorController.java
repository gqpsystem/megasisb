package com.megacenter.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import com.megacenter.service.IProveedorService;

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
import com.megacenter.model.Proveedor;

@RestController
@RequestMapping(value = "/api/proveedores")
public class ProveedorController {

    @Autowired
    private IProveedorService service;

    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Proveedor>> listar() {
        List<Proveedor> proveedor = new ArrayList<>();
        try {
            proveedor = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Proveedor>>(proveedor, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Proveedor>>(proveedor, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Proveedor> listarId(@PathVariable("id") Integer id) {
        Proveedor proveedor = new Proveedor();
        proveedor = service.listarId(id);
        if (proveedor == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Proveedor> resource = new Resource<Proveedor>(proveedor);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Proveedor"));
        return resource;
    }

    @PostMapping(value="/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Proveedor proveedor) {
        service.registrar(proveedor);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(proveedor.getIdProveedor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value="/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Proveedor proveedor) {
        service.modificar(proveedor);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        Proveedor und = service.listarId(id);
        if (und == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }
}