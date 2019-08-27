/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author reyme
 */
@Entity
@Table(name = "detalle_dolencia_producto")
public class DetalleDolenciaProducto {
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleDolencia;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto",nullable = false )
    private Producto producto;
    
    @ManyToOne()
    @JoinColumn(name = "id_dolencia", nullable = false)
    private Dolencia idDolencia ;
   
    
    public int getIdDetalleDolencia() {
        return idDetalleDolencia;
    }

    public void setIdDetalleDolencia(int idDetalleDolencia) {
        this.idDetalleDolencia = idDetalleDolencia;
    }

    public Producto getProducto() {
        return producto;
    }

    public Dolencia getIdDolencia() {
        return idDolencia;
    }

    public void setIdDolencia(Dolencia idDolencia) {
        this.idDolencia = idDolencia;
    }
    

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
   
    
}
