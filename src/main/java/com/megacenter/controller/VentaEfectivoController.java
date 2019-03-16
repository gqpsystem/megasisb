package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.VentaEfectivo;
import com.megacenter.service.IVentaEfectivoService;

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
@RequestMapping(value = "/api/ventaEfectivos")
public class VentaEfectivoController {

    @Autowired
    private IVentaEfectivoService service ;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VentaEfectivo>> listar() {
        List<VentaEfectivo> efectivos = new ArrayList<>();
        try {
            efectivos = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<VentaEfectivo>>(efectivos , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<VentaEfectivo>>( efectivos ,HttpStatus.OK);
    }
    

    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<VentaEfectivo> listarID(@PathVariable Integer id) {
        VentaEfectivo efectivo = new VentaEfectivo();
        efectivo = service.listarId(id);
        if (efectivo == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<VentaEfectivo> resource = new Resource<VentaEfectivo>(efectivo);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_VentaEfectivo"));
        return resource;
    }
    
    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VentaEfectivo> registrar(@Valid @RequestBody VentaEfectivo efectivo ) {
        service.registrar(efectivo);
        URI location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(efectivo.getIdVentaEfectivo()).toUri();
        return ResponseEntity.created(location).build();
    }


    @PutMapping(value="/actualizar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody VentaEfectivo efectivo) {
        service.registrar(efectivo);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        VentaEfectivo efectivo = service.listarId(id);
        if (efectivo == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }

    }

    
}