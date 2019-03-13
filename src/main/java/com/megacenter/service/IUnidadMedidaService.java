package com.megacenter.service;


import com.megacenter.model.UnidadMedida;

import java.util.List;

public interface IUnidadMedidaService {

    void registrar(UnidadMedida unidadMedida);

    void modificar(UnidadMedida unidadMedida);

    void eliminar(int idUnidadMedida);

    UnidadMedida listarId(int idUnidadMedida);

    List<UnidadMedida> listar();
}
