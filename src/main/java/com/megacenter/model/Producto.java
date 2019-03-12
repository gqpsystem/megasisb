/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.model;

import java.sql.Date;
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
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private int idProducto ;
    
    @Column(name = "codigo" , length = 100 , unique = true )
    private String codigo ; 
    
    @Column ( name = "numProducto" , length =200)
    private String numProducto ;
    
    @Column (name = "precioCompra" , precision = 16 , scale = 2)
    private Double precioCompra ; 
    
    @Column ( name = "precioVenta" , precision = 16 , scale = 2)
    private Double precioVenta ;
    
    @Column(name = "stock" , length = 11)
    private int stock ;
    
    @Column (name = "fechaVencimiento" )
    private Date fechaVencimiento;
    
    @Column (name = "numLote" , length = 30)
    private String numLote ;
    
    @Column (name = "estado" , length = 10)
    private String estado ;
    
    @Column (name = "area" , length = 10)
    private String area ;
    
    @Column ( name  = "laboratorio" , length = 50)
    private String laboratorio;
    
    @ManyToOne
    @JoinColumn (name = "categoria")
    private Categoria Categoria ;
    
    @ManyToOne
    @JoinColumn ( name = "presentacion")
    private Presentacion Presentacion ;
    
    @ManyToOne
    @JoinColumn (name = "dolencia")
    private Dolencia dolencia ;
    
    @ManyToOne
    @JoinColumn (name = "unidadMedida")
    private UnidadMedida unidadMedida ;

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(String numProducto) {
        this.numProducto = numProducto;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNumLote() {
        return numLote;
    }

    public void setNumLote(String numLote) {
        this.numLote = numLote;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Categoria Categoria) {
        this.Categoria = Categoria;
    }


    public Presentacion getPresentacion() {
        return Presentacion;
    }

    public void setPresentacion(Presentacion Presentacion) {
        this.Presentacion = Presentacion;
    }

    public Dolencia getDolencia() {
        return dolencia;
    }

    public void setDolencia(Dolencia dolencia) {
        this.dolencia = dolencia;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    
}
