package com.megacenter.service;

import java.util.List;

import com.megacenter.model.CajaFuerte;

public interface ICajaFuerteService {

    void registrar(CajaFuerte cajaFuerte);

    void modificar(CajaFuerte cajaFuerte);

    void eliminar(int idCajaFuerte);

    CajaFuerte listarId(int idCajaFuerte);

    List<CajaFuerte> listar();

}