package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.VentaTipoComprobante;
import com.megacenter.service.IVentaTipoComprobanteService;

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



@RequestMapping(value = "/api/ventaTipoComprobantes")
@RestController
public class VentaTipoComprobanteController {

    @Autowired
    private IVentaTipoComprobanteService service ;
    
    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VentaTipoComprobante>> listar() {
        List<VentaTipoComprobante> comprobantes = new ArrayList<>();
        try {
            comprobantes  = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<VentaTipoComprobante>>(comprobantes , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<VentaTipoComprobante>>(comprobantes ,HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<VentaTipoComprobante> listarId(@PathVariable Integer id) {
        VentaTipoComprobante comprobante = new VentaTipoComprobante() ;
        comprobante = service.listarId(id);
        if (comprobante == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<VentaTipoComprobante> resource = new Resource<VentaTipoComprobante>(comprobante);
        ControllerLinkBuilder  linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_VentaTipoComprobante"));
        return resource;
    }
    
    @PostMapping(value="/registrar" , produces = MediaType.APPLICATION_JSON_VALUE , consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody VentaTipoComprobante comprobante ) {
        service.registrar(comprobante);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(comprobante.getIdTipoComprobante()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @PutMapping(value="/actualizar" , produces = MediaType.APPLICATION_JSON_VALUE ,consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Object> actualizar(@RequestBody VentaTipoComprobante comprobante) {
        service.modificar(comprobante);

        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        VentaTipoComprobante comprobante = service.listarId(id);
        if (comprobante == null) {
            throw new ModeloNotFoundException("ID: " + id); 
        } else {
            service.eliminar(id);
        }
    }


}