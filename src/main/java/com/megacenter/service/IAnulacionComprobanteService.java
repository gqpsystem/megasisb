package com.megacenter.service;

import java.util.List;

import com.megacenter.model.AnulacionComprobante;

public interface IAnulacionComprobanteService {

    void registrar(AnulacionComprobante anulacionComprobante);

    void modificar(AnulacionComprobante anulacionComprobante);

    void eleminar(int idanulacionComprobante);
    
    AnulacionComprobante listarId(int idanulacionComprobante);

    List<AnulacionComprobante> listar();

}