
package com.megacenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tipocomprobante")
public class TipoComprobante {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idTipoComprobante ;
    
    @Column ( name = "descripcionDoc" , length = 10)
    private String descripcionDoc ;

    public TipoComprobante() {
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
    
    
}
