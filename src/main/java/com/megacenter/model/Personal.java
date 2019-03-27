
package com.megacenter.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPersonal;
    
    @Column(name = "foto" , length = 150 , nullable = false) 
    private String foto;

    @Column(name = "fechaIngreso")
    private Date fechaIngreso;

    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Column(name = "sueldo", precision = 16, scale = 2)
    private Double sueldo;

    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @Column(name = " estado", length = 10)
    private String estado;

    @JoinColumn(name = "id_persona")
    @OneToOne
    private Persona persona;

    public Personal() {
    }

    public String getFoto() {
    	return foto;
    }
    
    public void setFoto(String foto) {
    	this.foto = foto ;
    }
    
    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }


    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    


}
