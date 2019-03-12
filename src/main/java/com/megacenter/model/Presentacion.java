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
@Table(name = "presentacion")
public class Presentacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "IdPresentacion")
    private int idPresentacion;
    
   @Column ( name = "Presentacion" , length = 100  )
   private String presentacion;
   
   @Column (name = "Descripcion" , length = 400)
   private String descripcion;

    public Presentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Presentacion(String presentacion, String descripcion) {
        this.presentacion = presentacion;
        this.descripcion = descripcion;
    }

   
   
    public Presentacion(int idPresentacion, String presentacion, String descripcion) {
        this.idPresentacion = idPresentacion;
        this.presentacion = presentacion;
        this.descripcion = descripcion;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
   
   
    
}
