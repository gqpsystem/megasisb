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


}
