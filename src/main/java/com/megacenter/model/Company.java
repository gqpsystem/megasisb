package com.megacenter.model;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ruc", nullable = false, length = 11)
    private String ruc;

    @Column(name = "razonSocial", nullable = false, length = 11)
    private String razonSocial;

    @Column(name = "estado", nullable = false, length = 11)
    private String estado;

    @Column(name = "condicion", nullable = false, length = 11)
    private String condicion;

    @Column(name = "ubigeo", nullable = false, length = 11)
    private String ubigeo;

    @Column(name = "tipoVia", nullable = false, length = 11)
    private String tipoVia;

    @Column(name = "nombreVia", nullable = false, length = 11)
    private String nombreVia;

    @Column(name = "codigoZona", nullable = false, length = 11)
    private String codigoZona;

    @Column(name = "tipoZona", nullable = false, length = 11)
    private String tipoZona;

    @Column(name = "numero", nullable = false, length = 11)
    private String numero;

    @Column(name = "interior", nullable = false, length = 11)
    private String interior;

    @Column(name = "lote", nullable = false, length = 11)
    private String lote;

    @Column(name = "departamento", nullable = false, length = 11)
    private String departamento;

    @Column(name = "manzana", nullable = false, length = 11)
    private String manzana;

    @Column(name = "kilometro", nullable = false, length = 11)
    private String kilometro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    public void setTipoZona(String tipoZona) {
        this.tipoZona = tipoZona;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public String getKilometro() {
        return kilometro;
    }

    public void setKilometro(String kilometro) {
        this.kilometro = kilometro;
    }
}
