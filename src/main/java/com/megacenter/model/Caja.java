/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.model;

import java.sql.Date;
import java.sql.Time;
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
@Table ( name  = "caja")
public class Caja {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int idCaja;
    
    @Column (name = "fechaCierre")
    private Date fechaCierre;
    
    @Column (name  = "Hora")
    private Time hora;
    
    @Column (name = "montoTotalRegistrado" , precision = 11 ,scale = 2)
    private Double montoTotalRegistrado ; 
    
    @Column ( name = "montoInicioTurno" , precision = 11 , scale = 2)
    private Double montoInicioTurno ;
    
    @Column (name = "conteoFinTurno" , precision = 11 , scale = 2)
    private  Double ConteoFinTurno;
    
    @Column (name = "montoTotalDia" , precision = 11 ,scale = 2)
    private Double montoTotalDia;
    
    @Column ( name = "estadoCaja" , length = 50)
    private String estadoCaja; 
    
    @JoinColumn ( name = "venta")
    @ManyToOne
    private Venta venta ; //esto en la tabla esta venta

    public Caja() {
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Double getMontoTotalRegistrado() {
        return montoTotalRegistrado;
    }

    public void setMontoTotalRegistrado(Double montoTotalRegistrado) {
        this.montoTotalRegistrado = montoTotalRegistrado;
    }

    public Double getMontoInicioTurno() {
        return montoInicioTurno;
    }

    public void setMontoInicioTurno(Double montoInicioTurno) {
        this.montoInicioTurno = montoInicioTurno;
    }

    public Double getConteoFinTurno() {
        return ConteoFinTurno;
    }

    public void setConteoFinTurno(Double ConteoFinTurno) {
        this.ConteoFinTurno = ConteoFinTurno;
    }

    public Double getMontoTotalDia() {
        return montoTotalDia;
    }

    public void setMontoTotalDia(Double montoTotalDia) {
        this.montoTotalDia = montoTotalDia;
    }

    public String getEstadoCaja() {
        return estadoCaja;
    }

    public void setEstadoCaja(String estadoCaja) {
        this.estadoCaja = estadoCaja;
    }
    
    
    
}
