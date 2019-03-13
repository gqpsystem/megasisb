package com.megacenter.service;

import java.util.List;

import com.megacenter.model.VentaEfectivo;

public interface IVentaEfectivoService {

    void registrar(VentaEfectivo ventaEfectivo);

    void modificar(VentaEfectivo ventaEfectivo);

    void eleminar(int idVentaEfectivo);

    VentaEfectivo listarId(int idVentaEfectivo);

    List<VentaEfectivo> listar();
}