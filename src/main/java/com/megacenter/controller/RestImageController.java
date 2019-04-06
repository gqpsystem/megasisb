package com.megacenter.controller;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/image")
public class RestImageController {

    @GetMapping(value = "")
    public ResponseEntity<InputStreamResource> getImage() throws IOException {

        ClassPathResource imgFile = new ClassPathResource("image/4_1553904801963.png");

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(imgFile.getInputStream()));
    }

    @GetMapping(value = "/image")
    public @ResponseBody byte[] getImagen() throws IOException {
        InputStream in = getClass().getResourceAsStream("/com/main/webapp/images/1.jpg");
        return IOUtils.toByteArray(in);
    }
}
