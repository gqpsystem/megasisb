package com.megacenter.representation;

import com.megacenter.model.Persona;
import com.megacenter.model.Personal;

public class PersonalRepresentation {
    private Persona persona;
    private Personal personal;

    public PersonalRepresentation() {
    }

    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
