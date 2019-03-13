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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table ( name = "proforma")
public class Proforma {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column  (name = "idProforma")
    private int idProforma ;
    
    @Column ( name = "cantidad")
    private int cantidad ;
    
    @Column ( name = "precioUnitario" , precision = 16, scale = 2)
    private Double precioUnitario ;
    
    @Column ( name = "importe" , precision = 16 ,scale = 2)
    private Double importe ;
    
    @Column ( name = "serieProf" , length = 60)
    private String serieProf ;
    
    @JoinColumn ( name = "producto")
    @ManyToOne 
    private Producto producto ;
    
    @JoinColumn ( name = "proveedor")
    @ManyToOne
    private Proveedor proveedor ;

    public Proforma() {
    }

    public int getIdProforma() {
        return idProforma;
    }

    public void setIdProforma(int idProforma) {
        this.idProforma = idProforma;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getSerieProf() {
        return serieProf;
    }

    public void setSerieProf(String serieProf) {
        this.serieProf = serieProf;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
}
