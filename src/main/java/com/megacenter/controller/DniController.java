/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.controller;

import com.megacenter.model.Dni;
import com.megacenter.model.Ruc;
import com.megacenter.service.impl.DniServiceImpl;
import com.megacenter.service.impl.RucServiceImpl;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author reyme
 */
@RequestMapping ( value = "api/dni")
@RestController
public class DniController {
    
    
    String httpURL = "http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=random";
    String httpConsult = "http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias";

    @Autowired
    private DniServiceImpl service;

    @GetMapping(value = "/{numdni}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Dni> httpSearch(@PathVariable String numdni) throws IOException {
        try {

            Dni dni = service.getDni(numdni);
            Resource<Dni> resource = new Resource<Dni>(dni);
            return resource;

        } catch (Exception e) {
            return new Resource<Dni>(new Dni());

        }
    }
    
}
