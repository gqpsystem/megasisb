/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author reyme
 */

@Entity
@Table(name = "parent")
public class Parent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParent ;

    @OneToMany( mappedBy = "parent",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Child> childs  = new ArrayList<>();

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }
    
    public void addChild(Child child){
        childs.add(child);
        child.setParent(this);
        
    }
    
    public void removeChild(Child child){
        childs.remove(child);
        child.setParent(null);
    }

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }
    
}
