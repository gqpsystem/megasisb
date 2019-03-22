package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Producto;
import com.megacenter.service.IProductoService;

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



@RequestMapping (value = "/api/productos")
@RestController
public class ProductoController {

	private static final String ID = "/{id}";
	@Autowired
    private IProductoService service ;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = new ArrayList<>();
        try {
            productos = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Producto>>(productos , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Producto>>(productos , HttpStatus.OK);
    }
    
    @GetMapping(value =ID , produces = MediaType.APPLICATION_JSON_VALUE )
    public Resource<Producto> listarId(@PathVariable("id") Integer id) {
        Producto producto = new Producto();
        producto = service.listarId(id);
        if (producto == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Producto>  resource= new Resource<Producto>(producto);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("All_Producto"));
        return resource;
    }

    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody  Producto producto) {
        service.registrar(producto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(producto.getIdProducto()).toUri();
        
        return ResponseEntity.created(location).build();
    }
    
    @PutMapping(value="/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object>  actualizar(@RequestBody Producto producto) {
        service.modificar(producto);
        
        return new ResponseEntity<Object>(HttpStatus.OK)  ;
    }

    @DeleteMapping(value = "/eliminar/{id}" ,  produces = MediaType.APPLICATION_JSON_VALUE )
    public void eliminar(@PathVariable Integer id) {
        Producto pro = service.listarId(id);
        if (pro == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }  else {
            service.eliminar(id);
        }
    }
    

}