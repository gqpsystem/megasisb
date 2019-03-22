<<<<<<< HEAD
package com.megacenter.controller;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Company;
import com.megacenter.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private ICompanyService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> getById(@PathVariable("id") Integer id) {
        try {
            Company model = service.getById(id);
            if (model == null) {
                throw new ModeloNotFoundException("ID: " + id);
            }
            return new ResponseEntity<>(model, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Company>> getAll(Pageable pageable) {
        try {
            Page<Company> model = service.getAll(pageable);
            return new ResponseEntity<>(model, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/razonSocial", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Company>> searchByRazonSocial(@RequestParam(value = "razonSocial") String razonSocial, Pageable pageable) {
        try {
            Page<Company> model = service.findByRazonSocialContains(razonSocial, pageable);
            return new ResponseEntity<>(model, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/ruc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> searchByRuc(@RequestParam(value = "ruc") String ruc) {
        try {
            Company model = service.findByRuc(ruc);
            if (model == null) {
                throw new ModeloNotFoundException("RUC: " + ruc);
            }
            return new ResponseEntity<>(model, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> search(@RequestParam(value = "razonSocial") Optional<String> razonSocial, @RequestParam(value = "ruc") Optional<String> ruc) {
        try {
            System.out.printf(ruc.get());
            List<Company> models = service.getCompaniesByRucOrRazonSocial(razonSocial.get(), ruc.get());
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
=======
package com.megacenter.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.model.Company;
import com.megacenter.service.ICompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping(value = "/api/companies")
@RestController
public class CompanyController {

    @Autowired
    private ICompanyService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> listar() {
        List<Company> companies = new ArrayList<>();
        try {
            companies = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Company>>(companies, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Company> listarId(@PathVariable("id") Integer id) {
        Company company = new Company();
        company = service.listarId(id);
        if (company == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Company> resource = new Resource<Company>(company);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_companies"));
        return resource;
    }

    @PostMapping(value = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Company company) {
        service.registrar(company);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(company.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Company company) {
        service.modificar(company);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        Company und = service.listarId(id);
        if (und == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }
}
>>>>>>> origin/master
