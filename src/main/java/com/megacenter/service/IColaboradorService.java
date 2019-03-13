package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Colaborador;

public interface IColaboradorService {

    void registrar(Colaborador colaborador);

    void modificar(Colaborador colaborador);

    void eleminar(int idColaborador);

    Colaborador listarId(int idColaborador);

    List<Colaborador> listar();
    
}