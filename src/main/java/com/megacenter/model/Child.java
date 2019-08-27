/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author reyme
 */

@Entity
@Table(name = "child")
public class Child {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idchild ;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parend_id")
    private Parent parent;
    
    private String nombre ;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    public int getIdchild() {
        return idchild;
    }

    public void setIdchild(int idchild) {
        this.idchild = idchild;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
    
}
