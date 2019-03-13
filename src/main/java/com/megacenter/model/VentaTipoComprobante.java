
package com.megacenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "ventatipocomprobnte")
public class VentaTipoComprobante {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column ( name = "idTipoComprobante")
    private int idTipoComprobante ;

    @Column (name = "descripcionDoc" , length = 100)
    private String descripcionDoc ;
    
    @Column (name = "codigoCompro" , length = 50)
    private String codigoCompro ;

    public VentaTipoComprobante() {
    }

    public int getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(int idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public String getDescripcionDoc() {
        return descripcionDoc;
    }

    public void setDescripcionDoc(String descripcionDoc) {
        this.descripcionDoc = descripcionDoc;
    }

    public String getCodigoCompro() {
        return codigoCompro;
    }

    public void setCodigoCompro(String codigoCompro) {
        this.codigoCompro = codigoCompro;
    }
    
    
    
    
}
