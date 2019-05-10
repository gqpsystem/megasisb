/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.service.impl;

import com.megacenter.model.Dni;
import com.megacenter.service.IDniService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

/**
 *
 * @author reyme
 */
@Service
public class DniServiceImpl implements IDniService {

    String dniUrl = "http://aplicaciones007.jne.gob.pe/srop_publico/Consulta/Afiliado/GetNombresCiudadano?DNI=";

    @Override
    public Dni getDni(String dni) {
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet(dniUrl + dni);
        try {
            HttpResponse response = client.execute(get);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            String contextGet = "";
            while ((line = rd.readLine()) != null) {
                contextGet += line;
            }
            
            String[] datos = contextGet.replace("|", "-").split("-");
            if (datos.length!=3) {
                return new Dni("" , "" ,"");
            }
            Dni dniEntity = new Dni();
            dniEntity.setPrimerApellido(datos[0]);
            dniEntity.setSegundoApellido(datos[1]);
            dniEntity.setNombre(datos[2]);

            return dniEntity;
        } catch (Exception e) {
            return new Dni();
        }

    }

}
