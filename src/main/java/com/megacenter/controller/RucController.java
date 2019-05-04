/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.controller;

import com.megacenter.model.Ruc;
import com.megacenter.service.impl.RucServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author reyme
 */
@RestController
@RequestMapping(value = "api/ruc")
public class RucController {

    String httpURL = "http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=random";
    String httpConsult = "http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias";

    @Autowired
    private RucServiceImpl service;

    @GetMapping(value = "/{numRuc}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Ruc> httpSearch(@PathVariable String numRuc) throws IOException {
        try {

            Ruc ruc = service.getRuc(numRuc);
            Resource<Ruc> resource = new Resource<Ruc>(ruc);
            return resource;

        } catch (Exception e) {
            return new Resource<Ruc>(new Ruc());

        }
    }

}
