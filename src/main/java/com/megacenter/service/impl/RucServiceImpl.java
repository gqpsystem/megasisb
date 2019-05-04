/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.service.impl;

import com.megacenter.model.Ruc;
import com.megacenter.service.IRuc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author reyme
 */
@Service
public class RucServiceImpl implements IRuc {

    String httpURL = "http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/captcha?accion=random";
    String httpConsult = "http://e-consultaruc.sunat.gob.pe/cl-ti-itmrconsruc/jcrS00Alias";

    @Override
    public Ruc getRuc(String numRuc) {
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(httpURL);
        try {

            HttpResponse response = client.execute(request);
            Header[] allHeaders = response.getAllHeaders();

            Map<String, String> map = new HashMap<String, String>();

            for (Header dato : allHeaders) {
                map.put(dato.getName(), dato.getValue());
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            String line = "";
            String numRandom = "";
            while ((line = rd.readLine()) != null) {
                numRandom = line;
            }
            HttpClient cliente = HttpClientBuilder.create().build();

            HttpGet requestConsult = new HttpGet(httpConsult + "?accion=consPorRuc&nroRuc=" +numRuc +"&numRnd=" + numRandom + "&tipdoc=");
            requestConsult.setHeader("Cookie", map.get("Set-Cookie"));
            HttpResponse responseSearch = cliente.execute(requestConsult);

            String responseString = EntityUtils.toString(responseSearch.getEntity(), "UTF-8");

            Document parse = Jsoup.parse(responseString);
            Elements element = parse.getElementsByTag("table");
            Element tbody = element.first();
            Ruc ruc = new Ruc();
            Elements filaDato = tbody.getElementsByTag("td");
            ruc.separadorRucRazonSocial(filaDato.get(1).html());
            ruc.setTipo(filaDato.get(3).html());
            ruc.setNombreComercial(filaDato.get(5).html());
            ruc.setFechaInscripcion(filaDato.get(7).html());
            ruc.setFechaInicioActividades(filaDato.get(9).html());
            ruc.setEstado(filaDato.get(11).html());
            ruc.setCondicion(filaDato.get(14).html());
            ruc.setLugar(filaDato.get(16).html());
            ruc.setSistEmision(filaDato.get(18).html());
            ruc.setActExterior(filaDato.get(20).html());
            ruc.setSisContabilidad(filaDato.get(22).html());
            ruc.setActividades(filaDato.get(24).getElementsByTag("select").get(0).getElementsByTag("option").eachText());
            
            ruc.setComprobantePago(filaDato.get(26).getElementsByTag("select").get(0).getElementsByTag("option").eachText());
            if (filaDato.get(28).getElementsByTag("select").size()>0) {
                ruc.setSisEmisionElectronica(filaDato.get(28).getElementsByTag("select").get(0).getElementsByTag("option").eachText());
            }
            
            ruc.setEmisorElectronico(filaDato.get(30).html());
            ruc.setComprobanteElectronicos(filaDato.get(32).html());
            ruc.setPLE(filaDato.get(34).html());
            if (filaDato.get(36).getElementsByTag("select").size()>0) {
                ruc.setPadrones(filaDato.get(36).getElementsByTag("select").get(0).getElementsByTag("option").eachText());
            }
            
            return ruc;
        } catch (IOException  | UnsupportedOperationException | ParseException  e) {
            System.out.println(e + "qweqweqwe");
            
            return null;
        }

    }

}
