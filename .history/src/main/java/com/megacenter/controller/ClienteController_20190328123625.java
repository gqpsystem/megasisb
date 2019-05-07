package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Cliente;
import com.megacenter.model.Persona;
import com.megacenter.representation.ClienteReprestentation;
import com.megacenter.service.IClienteService;
import com.megacenter.service.IPersonaService;

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

import com.megacenter.service.IPersonalService;



@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @Autowired
    private IPersonaService personaService;


    @Autowired
    private IClienteService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes = service.listar();
        } catch (Exception e) {
            new ResponseEntity<List<Cliente>>(clientes , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Cliente>>(clientes , HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Cliente> listarId(@PathVariable Integer id) {
        Cliente cliente = new Cliente();
        cliente = service.listarId(id);
        if (cliente == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Cliente> resource = new Resource<Cliente>(cliente);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());

        resource.add(linkTo.withRel("all_Cliente"));
        return resource;
        
    }

    @PostMapping(value="/registrar")
    public ResponseEntity<Object> registrar(@Valid @RequestBody ClienteReprestentation rp) {
        Persona persona = personaService.registrar(rp.getPersona());
        rp.getCliente().setPersona(persona);
        Cliente cliente = service.registrar(rp.getCliente());
        service.registrar(rp);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(rp.getIdCliente()).toUri();

        return ResponseEntity.created(location).build();
    }
    

    @PutMapping(value="/actualizar" , consumes = MediaType.APPLICATION_JSON_VALUE ,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Cliente cliente) {
        service.modificar(cliente);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping (value = "/eliminar/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        Cliente cliente = service.listarId(id);
        if (cliente == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }
}