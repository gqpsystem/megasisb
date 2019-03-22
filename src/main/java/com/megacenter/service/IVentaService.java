package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Venta;

public interface IVentaService {

    void registrar(Venta venta);

    void modificar(Venta venta);

    void eliminar(int idVenta);

    Venta listarId(int idVenta);

    List<Venta> listar();
}