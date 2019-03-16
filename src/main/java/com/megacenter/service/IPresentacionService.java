package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Presentacion;

public interface IPresentacionService {

    void registrar(Presentacion presentacion);

    void modificar(Presentacion presentacion);

    void eliminar(int idPresentacion);

    Presentacion listarId(int idPresentacion);

    List<Presentacion> listar();
}