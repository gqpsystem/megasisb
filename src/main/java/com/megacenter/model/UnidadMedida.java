package com.megacenter.model;

import javax.persistence.*;


@Entity
@Table(name = "unidadmedida")
public class UnidadMedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidadmedida;

    @Column(name = "codUnidadmedida", nullable = false, length = 20)
    private String codUnidadmedida;

    @Column(name = "descripcion", nullable = true, length = 50)
    private String descripcion;

    public int getIdUnidadmedida() {
        return idUnidadmedida;
    }

    public void setIdUnidadmedida(int idUnidadmedida) {
        this.idUnidadmedida = idUnidadmedida;
    }

    public String getCodUnidadmedida() {
        return codUnidadmedida;
    }

    public void setCodUnidadmedida(String codUnidadmedida) {
        this.codUnidadmedida = codUnidadmedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
