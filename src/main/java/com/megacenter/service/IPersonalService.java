package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Personal;

public interface IPersonalService {

    void registrar(Personal personal);

    void modificar(Personal personal);

    void eliminar(int idPersonal);

    Personal listarId(int idPersonal);

    List<Personal> listar();
    
}