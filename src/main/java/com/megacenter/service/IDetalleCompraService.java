package com.megacenter.service;

import java.util.List;

import com.megacenter.model.DetalleCompra;

public interface IDetalleCompraService {

    void registrar(DetalleCompra DetalleCompra);

    void modificar(DetalleCompra detalleCompra);

    void eliminar (int idDetalleCompra);

    DetalleCompra listarId( int idDetalleCompra);

    List<DetalleCompra> listar();
}