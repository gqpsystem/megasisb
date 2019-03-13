package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Producto;

public interface IProductoService {

    void registrar(Producto producto);
    
    void modificar(Producto producto);

    void eleminar(int idProducto);

    Producto listarId(int idProducto);

    List<Producto> listar();
}