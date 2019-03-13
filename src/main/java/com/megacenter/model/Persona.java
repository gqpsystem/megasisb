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
@Table (name = "persona")
public class Persona {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( name = "idPersona")
    private int idPersona ;
    
    @Column ( name = "nombre" , length = 150 , nullable = false)
    private String nombre ;
    
    @Column (name = "apellido" , length = 100)
    private String apellido ;
    
    @Column (name = "tipoDocumento" , length = 300, nullable = false)
    private String tipoDocumento ;
    
    @Column (name = "numDocumento" , length = 20 , unique = true, nullable = false)
    private String numDocumento ;
    
    @Column (name = "telefono" , length = 20) 
    private String telefono ;
    
    @Column ( name = "direccion" , length = 150)
    private String direccion ;

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
