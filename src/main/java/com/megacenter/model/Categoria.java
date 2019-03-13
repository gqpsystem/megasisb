
package com.megacenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria ;
    
    @Column ( name = "categoria" , length = 100 )
    private String categoria ; 
    
    @Column (name = "estado" , length = 10)
    private String estado ;

    public Categoria(String categoria, String estado) {
        this.categoria = categoria;
        this.estado = estado;
    }

    public Categoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria() {
    }

    public Categoria(int idCategoria, String categoria, String estado) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.estado = estado;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
