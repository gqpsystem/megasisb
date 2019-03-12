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
@Table (name = "ticketdetalle")
@Entity
public class TicketDetalle {
    
    @Id
    @GeneratedValue  (strategy = GenerationType.IDENTITY)
    @Column (name = "idTicketDetalle")
    private int idTicketDetalle ;
    
    @Column (name  = "precioVentaUnitario" , precision = 16 ,scale = 2)
    private Double precioVentaUnitario ;
    
    @Column (name = "cantidadVenta" , length = 11)
    private int cantidadVenta ;
    
    @Column (name = "costoTotalVenta", precision = 16 , scale = 2)
    private Double costoTotalVenta ;
    
    @Column (name = "estado" , length = 20)
    private String estado ;
    
    @JoinColumn (name  = "Producto" )
    @ManyToOne
    private Producto producto ;
    
    @JoinColumn ( name = "ticket")
    @ManyToOne  
    private Ticket ticket ;

    public TicketDetalle() {
    }

    public int getIdTicketDetalle() {
        return idTicketDetalle;
    }

    public void setIdTicketDetalle(int idTicketDetalle) {
        this.idTicketDetalle = idTicketDetalle;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    
    
}
