package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Egreso;

public interface IEgresoService {

    void registrar(Egreso egreso);

    void modificar(Egreso egreso);

    void eliminar(int idEgreso);

    Egreso listarId(int idEgreso);

    List<Egreso> listar();


}