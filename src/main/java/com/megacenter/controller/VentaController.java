package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Venta;
import com.megacenter.service.IVentaService;

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



@RestController
@RequestMapping(value = "/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService service ;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Venta>> listar() {
        List<Venta>  ventas = new ArrayList<>();
        try{
            ventas = service.listar();
        } catch(Exception e) {
            return new ResponseEntity<List<Venta>>(ventas , HttpStatus.INTERNAL_SERVER_ERROR) ; 
        }
        return new ResponseEntity<List<Venta>>(ventas , HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Venta> listarId(@PathVariable Integer id) {
        Venta venta = new Venta()  ;
        venta = service.listarId(id);
        if (venta == null) {
            throw new ModeloNotFoundException("ID + " + id ) ;
        }
        Resource<Venta> resource = new Resource<Venta>(venta) ;
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Venta"));
        return resource;
    }
    

    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE ,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Venta venta) {
        service.registrar(venta);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(venta.getIdVenta()).toUri() ;
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/actualizar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Venta venta){
        service.modificar(venta);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value ="/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        Venta venta = service.listarId(id);
        if (venta == null) {
            throw new ModeloNotFoundException("ID: "+ id);
        } else {
            service.eliminar(id);
        }
    }


}