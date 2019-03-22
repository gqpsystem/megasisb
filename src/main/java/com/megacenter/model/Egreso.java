
package com.megacenter.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table  (name  = "egreso")
public class Egreso {
    
    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    private int idEgreso ;
    
    @Column ( name = "monto" , precision = 11, scale = 2)
    private Double monto ;
    
    @Column ( name = "motivo" , length = 150)
    private String motivo ;
    
    @Column ( name = "fecha")
    private Date fecha ;
  
    @Column  (name = "estadoVenta")
    private String estadoVenta ;
    
    @JoinColumn ( name = "id_personal")
    @ManyToOne
    private Personal personal ;

    public Egreso() {
    }

    
    public int getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(int idEgreso) {
        this.idEgreso = idEgreso;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(String estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
    
    
    
}
