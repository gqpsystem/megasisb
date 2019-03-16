
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


@Entity
@Table ( name = "venta")
public class Venta {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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

    @JoinColumn (name = "id_cliente")
    @ManyToOne
    private Cliente cliente;
    
    @JoinColumn (name = "id_personal")
    @ManyToOne 
    private Personal personal ;
    
    @JoinColumn ( name = "id_tipo_comprobante")
    @ManyToOne
    private VentaTipoComprobante comprobante ;
    
    public Venta() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

   
    public VentaTipoComprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(VentaTipoComprobante comprobante) {
        this.comprobante = comprobante;
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
