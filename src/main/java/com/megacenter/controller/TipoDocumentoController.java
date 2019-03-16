package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.TipoDocumento;
import com.megacenter.service.ITipoDocumentoService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping(value = "/api/tipoDocumentos")
public class TipoDocumentoController {

    @Autowired
    private ITipoDocumentoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipoDocumento>> listar() {
        List<TipoDocumento> documentos = new ArrayList<>();
        try {
            documentos = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<TipoDocumento>>(documentos , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<TipoDocumento>>(documentos , HttpStatus.OK);
    }

    @GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<TipoDocumento> listarId(@PathVariable("id"  ) Integer id) {
        TipoDocumento documento = new TipoDocumento();
        documento = service.listarId(id);
        if (documento == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<TipoDocumento> resource = new Resource<TipoDocumento>(documento);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_TipoDocumento"));
        return resource;
    }

    @PostMapping(value= "/registrar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE    )
    public ResponseEntity<Object> registrar(@Valid @RequestBody TipoDocumento documento) {
        service.registrar(documento);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(documento.getIdTipoDocumento()).toUri();

        return ResponseEntity.created(location).build();
    }
    
    
    @PutMapping(value = "/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar( @RequestBody TipoDocumento documento) {
        service.modificar(documento);
        return new ResponseEntity<Object>(HttpStatus.OK); 
    }

    @DeleteMapping(value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        TipoDocumento documento =service.listarId(id);
        if (documento == null) {
            throw new ModeloNotFoundException("ID: "+ id);
        } else {
            service.eleminar(id);
        }

    }
    


}