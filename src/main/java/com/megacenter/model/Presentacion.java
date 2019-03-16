
package com.megacenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "presentacion")
public class Presentacion {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPresentacion;
    
   @Column ( name = "Presentacion" , length = 100  )
   private String presentacion;
   
   @Column (name = "Descripcion" , length = 400)
   private String descripcion;

    public Presentacion(){
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
   
   
    
}
