
package com.megacenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "dolencia")
public class Dolencia {
    
    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    private int idDolencia ; 
    
    @Column (name = "dolencia" , length = 100)
    private String dolencia ;
    
    @Column (name = "recomendacion" , length = 400)
    private String recomendacion ;

    public Dolencia() {
    }

    public int getIdDolencia() {
        return idDolencia;
    }

    public void setIdDolencia(int idDolencia) {
        this.idDolencia = idDolencia;
    }

    public String getDolencia() {
        return dolencia;
    }

    public void setDolencia(String dolencia) {
        this.dolencia = dolencia;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    
    
}
