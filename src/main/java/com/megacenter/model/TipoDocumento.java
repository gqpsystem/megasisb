
package com.megacenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table ( name = "tipodocumento")
public class TipoDocumento {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idTipoDocumento;
    
    @Column ( name = "abreviatura" , length = 20)
    private String abreviatura ;
    
    @Column ( name = "denominacionDoc", length = 200)
    private String denominacionDoc ;

    public TipoDocumento() {
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDenominacionDoc() {
        return denominacionDoc;
    }

    public void setDenominacionDoc(String denominacionDoc) {
        this.denominacionDoc = denominacionDoc;
    }
    
    
    
    
}
