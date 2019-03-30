
package com.megacenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table (name = "ventadetalle")
@Entity
public class VentaDetalle {
    
    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    private int idVentaDetalle ;
    
    @Column (name  = "precioVentaUnitario" , precision = 16 ,scale = 2)
    private Double precioVentaUnitario ;
    
    @Column (name = "cantidadVenta" , length = 11)
    private int cantidadVenta ;
    
    @Column (name = "costoTotalVenta", precision = 16 , scale = 2)
    private Double costoTotalVenta ;
    
    @Column (name = "estado" , length = 20)
    private String estado ;
    
    @JoinColumn (name  = "idProducto" )
    @ManyToOne
    private Producto producto ;
    
    @JoinColumn ( name = "idVenta")
    @ManyToOne  
    private Venta venta ;

    public VentaDetalle() {
    }

    public int getIdVentaDetalle() {
        return idVentaDetalle;
    }

    public void setIdVentaDetalle(int idVentaDetalle) {
        this.idVentaDetalle = idVentaDetalle;
    }

    
    
    public Double getPrecioVentaUnitario() {
        return precioVentaUnitario;
    }

    public void setPrecioVentaUnitario(Double precioVentaUnitario) {
        this.precioVentaUnitario = precioVentaUnitario;
    }

    public int getCantidadVenta() {
        return cantidadVenta;
    }

    public void setCantidadVenta(int cantidadVenta) {
        this.cantidadVenta = cantidadVenta;
    }

    public Double getCostoTotalVenta() {
        return costoTotalVenta;
    }

    public void setCostoTotalVenta(Double costoTotalVenta) {
        this.costoTotalVenta = costoTotalVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    
    
}
