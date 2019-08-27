
package com.megacenter.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;


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
    private Double montoTotal;

    @Column(name = "numComprobante", length = 30, nullable = false)
    private String numComprobante;

    @ManyToOne
    @JoinColumn(name = "personal")
    private Personal personal;

    @ManyToOne
    @JoinColumn(name = "provedor")
    private Proveedor proveedor;      

    @ManyToOne
    @JoinColumn(name = "tipoComprobante")
    private TipoComprobante tipocomprobante;
    
    
    
    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL }, orphanRemoval = true)
    private List<DetalleCompra> detalleCompra=new ArrayList<>();
    
    public int getIdCompra() {
        return idCompra;
    }
    
    
    
    public Personal getPersonal() {
        return personal;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public TipoComprobante getTipocomprobante() {
        return tipocomprobante;
    }

    public void setTipocomprobante(TipoComprobante tipocomprobante) {
        this.tipocomprobante = tipocomprobante;
    }

    public List<DetalleCompra> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
        this.detalleCompra = detalleCompra;
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
        return montoTotal;
    }

    public void setMontoTotalCompra(Double montoTotalCompra) {
        this.montoTotal = montoTotalCompra;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

   

   

    public TipoComprobante getComprobante() {
        return tipocomprobante;
    }

    public void setComprobante(TipoComprobante comprobante) {
        this.tipocomprobante = comprobante;
    }

}
