package com.megacenter.service;

import java.util.List;

import com.megacenter.model.VentaDetalle;


public interface IVentaDetalleService {

    void registrar(VentaDetalle detalle);

    void modificar(VentaDetalle detalle);

    void eliminar (int idDetalle);

    VentaDetalle listarId(int idVentaDetalle);

    List<VentaDetalle> listar();

}