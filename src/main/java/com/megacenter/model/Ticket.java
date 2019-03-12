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
@Table ( name = "ticket")
public class Ticket {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idTicket")
    private int idTicket ;
    
    @Column (name = "fechaVenta")
    private Date fechaVenta ;
    
    @Column (name = "montoTotalVenta" , precision = 16 ,scale = 2)
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
    private TicketTipoComprobante Comprobante ;
    
    public Ticket() {
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

    public TicketTipoComprobante getComprobante() {
        return Comprobante;
    }

    public void setComprobante(TicketTipoComprobante Comprobante) {
        this.Comprobante = Comprobante;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
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
