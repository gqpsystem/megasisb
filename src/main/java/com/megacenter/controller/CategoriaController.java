package com.megacenter.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Categoria;
import com.megacenter.service.ICategoriaService;

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
@RequestMapping(value = "/api/categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService service ;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Categoria>> listar() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            categorias = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Categoria>>(categorias , HttpStatus.OK);
        }
        return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Categoria> listarId(@PathVariable Integer id) {
        Categoria categoria = new Categoria();
        categoria = service.listarId(id);
        if (categoria == null) {
            throw new ModeloNotFoundException("ID: " + id );
        }
        Resource<Categoria> resource = new Resource<Categoria>(categoria);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Categoria"));  
        return resource;
    }
    
    @PostMapping(value = "/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Categoria categoria ) {
        service.registrar(categoria);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(categoria.getIdCategoria()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @PutMapping(value= "/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Categoria categoria) {
        service.modificar(categoria);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    private void eliminar(@PathVariable Integer id) {
        Categoria cat = service.listarId(id);
        if (cat == null) {
            throw new ModeloNotFoundException("ID " + id);
        } else {
            service.eliminar(id);
        }

    }

}