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
@Table ( name  =" controlasistencia")
public class ControlAsistencia {
    
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column ( name = "control")
    private int idControl ;
    
    
    @Column ( name = "fechaAsistencia")
    private Date fechaAsistencia ;
    
    @Column ( name = "horaEntrada")
    private Time horaEntrada ;
    
    @Column ( name = "horaSalida")
    private Time horaSalida ;
    
    @Column ( name = "estadoEntrada" , length = 20)
    private String estadoEntrada ;
    
    @ManyToOne
    @JoinColumn ( name = "personal")
    private Colaborador personal; 

    public ControlAsistencia() {
    }

    public int getIdControl() {
        return idControl;
    }

    public void setIdControl(int idControl) {
        this.idControl = idControl;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getEstadoEntrada() {
        return estadoEntrada;
    }

    public void setEstadoEntrada(String estadoEntrada) {
        this.estadoEntrada = estadoEntrada;
    }

    public Colaborador getPersonal() {
        return personal;
    }

    public void setPersonal(Colaborador personal) {
        this.personal = personal;
    }
    
    
    
    
}
