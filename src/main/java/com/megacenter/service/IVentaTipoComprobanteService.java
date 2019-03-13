package com.megacenter.service;

import java.util.List;

import com.megacenter.model.VentaTipoComprobante;

public interface IVentaTipoComprobanteService {

    void registrar(VentaTipoComprobante ventaTipoComprobante );

    void modificar(VentaTipoComprobante ventaTipoComprobante);

    void eleminar(int idVentaTipoComprobante);

    VentaTipoComprobante listarId(int idVentaTipoComprobante);

    List<VentaTipoComprobante> listar();

}