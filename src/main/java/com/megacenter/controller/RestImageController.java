package com.megacenter.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/image")
public class RestImageController {

    @Autowired
    private ServletContext context;

    @GetMapping(value = "/perfil/{imagen}")
    public HttpEntity<byte[]> Image(@PathVariable String imagen) throws FileNotFoundException, IOException {
        String filePath = context.getRealPath("/images/");

        File getFile = FileUtils.getFile(filePath, imagen);
        if (!getFile.isDirectory()) {

            String extension = FilenameUtils.getExtension(getFile.getName());
            FileInputStream fileInputStream = new FileInputStream(getFile);
            byte[] bytes = new byte[(int) getFile.length()];
            fileInputStream.read(bytes);
            HttpHeaders headers = new HttpHeaders();
            if (extension.toLowerCase().equalsIgnoreCase("png"))  {
                headers.setContentType(MediaType.IMAGE_PNG);
            }else{
                headers.setContentType(MediaType.IMAGE_JPEG);
            }
            headers.setContentLength(bytes.length);

            return new HttpEntity<byte[]>(bytes, headers);
        }

        return null;
    }

    @GetMapping(value = "/producto/{imagen}")
    public HttpEntity<byte[]> ImageProduto(@PathVariable String imagen) throws FileNotFoundException, IOException {
        String filePath = context.getRealPath("/producto/");

        File getFile = FileUtils.getFile(filePath, imagen);
        if (!getFile.isDirectory()) {

            String extension = FilenameUtils.getExtension(getFile.getName());
            FileInputStream fileInputStream = new FileInputStream(getFile);
            byte[] bytes = new byte[(int) getFile.length()];
            fileInputStream.read(bytes);
            HttpHeaders headers = new HttpHeaders();
            if (extension.toLowerCase().equalsIgnoreCase("png"))  {
                headers.setContentType(MediaType.IMAGE_PNG);
            }else{
                headers.setContentType(MediaType.IMAGE_JPEG);
            }
            headers.setContentLength(bytes.length);

            return new HttpEntity<byte[]>(bytes, headers);
        }

        return null;
    }

}
