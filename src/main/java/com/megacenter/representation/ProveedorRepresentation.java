/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.representation;

import com.megacenter.model.Persona;
import com.megacenter.model.Proveedor;

/**
 *
 * @author USER
 */
public class ProveedorRepresentation {
    
    private Persona persona ;
    
    private Proveedor proveedor ;

    public ProveedorRepresentation() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
}
