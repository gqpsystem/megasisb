
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
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompra;

    @Column(name = "fechaCompra")
    private Date fechaCompra;

    @Column(name = "codigoCompra", length = 100, nullable = false)
    private String codigoCompra;

    @Column(name = "montoTotalCompra", precision = 16, scale = 2)
    private Double montoTotalCompra;

    @Column(name = "numComprobante", length = 30, nullable = false)
    private String numComprobante;

    @ManyToOne
    @JoinColumn(name = "id_personal")
    private Personal personal;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_comprobante")
    private TipoComprobante comprobante;

    public int getIdCompra() {
        return idCompra;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public Double getMontoTotalCompra() {
        return montoTotalCompra;
    }

    public void setMontoTotalCompra(Double montoTotalCompra) {
        this.montoTotalCompra = montoTotalCompra;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   

    public TipoComprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(TipoComprobante comprobante) {
        this.comprobante = comprobante;
    }

}
