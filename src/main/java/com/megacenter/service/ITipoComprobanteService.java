package com.megacenter.service;

import java.util.List;

import com.megacenter.model.TipoComprobante;


public interface ITipoComprobanteService {

    void registrar(TipoComprobante comprobante);

    void modificar(TipoComprobante comprobante);

    void eleminar(int idComprobante);

    TipoComprobante listarId(int idComprobante);

    List<TipoComprobante> listar();
}