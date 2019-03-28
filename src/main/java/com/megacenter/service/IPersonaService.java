package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Persona;

public interface IPersonaService {

    Persona registrar(Persona persona);

    Persona modificar(Persona persona);

    void eliminar(int idPersona);

    Persona listarId(int idPersona);

    List<Persona> listar();

}