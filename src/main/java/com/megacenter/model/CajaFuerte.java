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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Table (name =  "cajafuerte")
@Entity
public class CajaFuerte {
    
    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    @Column ( name =  "idCajaFuerte")
    private int idCajaFuerte ;
    
    
    @Column ( name = "fechaCierreCajaFuerte")
    private Date fechaCierreCajafuerte  ;
    
    @Column ( name = "fechaInicioTurno")
    private Date fechaInicioTurno ;
    
    @Column  ( name = "montoTotalDia" , precision = 11 , scale = 2 )
    private Double montoTotalDia ; 
    
    @Column ( name  = "montoInicioTurno" , precision = 11 , scale = 2)
    private Double montoInicioTurno ;
    
    @Column ( name =  "montoTotalCaja", precision = 11 , scale = 2)
    private Double montoTotalCaja ;
    
    @JoinColumn ( name = "Caja")
    @OneToOne
    private Caja caja ;
    
    @JoinColumn ( name = "responsable")
    @OneToOne
    private Colaborador responsable ; // este en la tabla esta responsable

    public CajaFuerte() {
    }

    public int getIdCajaFuerte() {
        return idCajaFuerte;
    }

    public void setIdCajaFuerte(int idCajaFuerte) {
        this.idCajaFuerte = idCajaFuerte;
    }

    public Date getFechaCierreCajafuerte() {
        return fechaCierreCajafuerte;
    }

    public void setFechaCierreCajafuerte(Date fechaCierreCajafuerte) {
        this.fechaCierreCajafuerte = fechaCierreCajafuerte;
    }

    public Date getFechaInicioTurno() {
        return fechaInicioTurno;
    }

    public void setFechaInicioTurno(Date fechaInicioTurno) {
        this.fechaInicioTurno = fechaInicioTurno;
    }

    public Double getMontoTotalDia() {
        return montoTotalDia;
    }

    public void setMontoTotalDia(Double montoTotalDia) {
        this.montoTotalDia = montoTotalDia;
    }

    public Double getMontoInicioTurno() {
        return montoInicioTurno;
    }

    public void setMontoInicioTurno(Double montoInicioTurno) {
        this.montoInicioTurno = montoInicioTurno;
    }

    public Double getMontoTotalCaja() {
        return montoTotalCaja;
    }

    public void setMontoTotalCaja(Double montoTotalCaja) {
        this.montoTotalCaja = montoTotalCaja;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Colaborador getResponsable() {
        return responsable;
    }

    public void setResponsable(Colaborador responsable) {
        this.responsable = responsable;
    }

    
    
    
    
    
}
