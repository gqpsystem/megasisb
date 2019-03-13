package com.megacenter.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table( name= "anulacioncomprobante")
@Entity
public class AnulacionComprobante  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnulacion;
    
    @Column(name = "fechaEmision")
    private Date fechaEmision;
    
    @Column( name = "tipoComprobante" , length = 50 , nullable = false )
    private String tipoComprobante ;

    @Column ( name  = "numComprobante" , length = 50, nullable = false)
    private String numComprobante ; 
    
    @Column (name = "importeTotal" , scale = 11, precision = 2)
    private Double ImporteTotal ;
    
    @Column(name ="fechaAnulacion")
    private Date fechaAnulacion ; 
    
    @Column (name = "estado" , length = 20 )
    private String estado ; 
    
    @Column(name = "motivo" , length = 300)
    private String motivo ;
    
    @JoinColumn ( name  = "venta")
    @ManyToOne
    private Venta venta; // la variable se llama venta en tabla
    
    public AnulacionComprobante() {
    
    
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    
    public int getIdAnulacion() {
        return idAnulacion;
    }

    public void setIdAnulacion(int idAnulacion) {
        this.idAnulacion = idAnulacion;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Double getImporteTotal() {
        return ImporteTotal;
    }

    public void setImporteTotal(Double ImporteTotal) {
        this.ImporteTotal = ImporteTotal;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
}