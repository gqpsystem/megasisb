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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Table  (name = "proveedor")
@Entity
public class Proveedor {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( name = "idProvedor")
    private int idProvedor;
    
    @Column ( name = "razonSocial" , length = 200, nullable = false)
    private String razonSocial ;
    
    @Column ( name = "laboratorio", length = 100)
    private String laboratorio ;
    
    @Column ( name = "ciudad" , length = 100)
    private String ciudad;
    
    @Column ( name = "email" , length = 150)
    private String email ;
    
    @Column ( name = "estado" , length = 10)
    private String estado ;
    
    @JoinColumn ( name = "persona")
    @OneToOne
    private Persona persona ;

    public Proveedor() {
    }

    public int getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(int idProvedor) {
        this.idProvedor = idProvedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
    
}
