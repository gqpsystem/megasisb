package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Caja;

public interface ICajaService {

    void registrar (Caja caja) ;

    void modificar (Caja caja);

    void eleminar (int idCaja) ;

    Caja listarId(int idCaja);

    List<Caja> listar();

}