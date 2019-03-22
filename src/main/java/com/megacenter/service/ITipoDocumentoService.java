package com.megacenter.service;

import java.util.List;

import com.megacenter.model.TipoDocumento;

public interface ITipoDocumentoService {

    void registrar(TipoDocumento documento);

    void modificar(TipoDocumento documento);

    void eleminar(int idDocumento);

    TipoDocumento listarId(int idDocumento);

    List<TipoDocumento> listar();


}