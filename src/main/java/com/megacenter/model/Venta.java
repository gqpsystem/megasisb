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
@Table ( name = "venta")
public class Venta {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idVenta")
    private int idVenta ;
    
    @Column (name = "fechaVenta", nullable = false)
    private Date fechaVenta ;
    
    @Column (name = "montoTotalVenta" , precision = 16 ,scale = 2, nullable = false)
    private Double montoTotalVenta ;
    
    @Column ( name = "estadoPago" , length = 20)
    private String estadoPago;
    
    @Column (name = "formaPago" , length = 20)
    private String formaPago ; 
    
    @Column ( name = "estadoVenta" , length = 20)
    private String estadoVenta ;

    @JoinColumn (name = "cliente")
    @ManyToOne
    private Cliente Cliente;
    
    @JoinColumn (name = "colaborador")
    @ManyToOne 
    private Colaborador Colaborador ;
    
    @JoinColumn ( name = "tipoComprobante")
    @ManyToOne
    private VentaTipoComprobante Comprobante ;
    
    public Venta() {
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public Colaborador getColaborador() {
        return Colaborador;
    }

    public void setColaborador(Colaborador Colaborador) {
        this.Colaborador = Colaborador;
    }

    public VentaTipoComprobante getComprobante() {
        return Comprobante;
    }

    public void setComprobante(VentaTipoComprobante Comprobante) {
        this.Comprobante = Comprobante;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }


    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getMontoTotalVenta() {
        return montoTotalVenta;
    }

    public void setMontoTotalVenta(Double montoTotalVenta) {
        this.montoTotalVenta = montoTotalVenta;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(String estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
    
    
    
}
