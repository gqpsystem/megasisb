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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table (name = "ticketefectivo")
public class TicketEfectivo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idTicketEfectivo")
    private int idTicketEfectivo ;

    @Column (name  = "estadoPago" , length = 60)
    private String estadoPago ;
    
    @Column (name = "montoPagado" , precision = 16 , scale = 2)
    private Double montoPagado ;
    
    @JoinColumn  (name = "ticket")
    @OneToOne 
    private Ticket ticket ;

    public TicketEfectivo() {
    }

    public int getIdTicketEfectivo() {
        return idTicketEfectivo;
    }

    public void setIdTicketEfectivo(int idTicketEfectivo) {
        this.idTicketEfectivo = idTicketEfectivo;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(Double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    
}
