
package com.megacenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table ( name = "detallecompra")
@Entity
public class DetalleCompra {
    
    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    @Column  ( name = "idDetalleCompra")
    private int idDetalleCompra;
    
    @Column ( name = "cantidad" , length = 11)
    private int cantidad ;
    
    @Column (name = "cantidadAgredada")
    private int cantidadAgregada ;
    
    @Column ( name = "cantidadAnterior")
    private int cantidadAnterior ;
    
    @Column (name = "precioUnitario" , precision = 16 , scale = 2)
    private Double precioUnitario ;
    
    @Column ( name = "precioTotal" , precision = 16 ,scale = 2)
    private Double precioTotal ;
    
    @JoinColumn (name = "compra")
    @ManyToOne
    private Compra compra ;
    
    @JoinColumn ( name = "producto")
    @ManyToOne
    private Producto producto ;

    public DetalleCompra() {
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadAgregada() {
        return cantidadAgregada;
    }

    public void setCantidadAgregada(int cantidadAgregada) {
        this.cantidadAgregada = cantidadAgregada;
    }

    public int getCantidadAnterior() {
        return cantidadAnterior;
    }

    public void setCantidadAnterior(int cantidadAnterior) {
        this.cantidadAnterior = cantidadAnterior;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    
    
}
