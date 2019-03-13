package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Persona;

public interface IPersonaService {

    void registrar(Persona persona);

    void modificar(Persona persona);

    void eleminar(int idPersona);

    Persona listarId(int idPersona);

    List<Persona> listar();

}