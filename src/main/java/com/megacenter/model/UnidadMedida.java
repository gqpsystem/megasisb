/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table (name = "unidadmedida")
public class UnidadMedida {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( name = "idUnidad")
    private int idUnidad ;
    
    @Column (name = "abreviatura" , length = 20)
    private String abreviatura ; 
    
    @Column (name = "denominacion" , length = 50)
    private String denominacion ;

    public UnidadMedida() {
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    

    
}
