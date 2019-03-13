
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
    @Column (name = "idTipoComprobante")
    private int idTipoComprobbante ;
    
    @Column ( name = "descripcionDoc" , length = 10)
    private String descripcionDoc ;

    public TipoComprobante() {
    }

    public int getIdTipoComprobbante() {
        return idTipoComprobbante;
    }

    public void setIdTipoComprobbante(int idTipoComprobbante) {
        this.idTipoComprobbante = idTipoComprobbante;
    }

    public String getDescripcionDoc() {
        return descripcionDoc;
    }

    public void setDescripcionDoc(String descripcionDoc) {
        this.descripcionDoc = descripcionDoc;
    }
    
    
}
