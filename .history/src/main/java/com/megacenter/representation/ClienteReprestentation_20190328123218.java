package com.megacenter.representation;

import com.megacenter.model.Cliente;
import com.megacenter.model.Persona;

public class ClienteReprestentation {
    private Persona persona;
    private Cliente cliente ;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}