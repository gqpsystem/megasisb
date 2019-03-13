package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Compra;

public interface ICompraService {

    void registrar(Compra compra);

    void modificar (Compra compra);

    void eleminar(int idCompra);

    Compra listarId(int idCompra);

    List<Compra> listar();
    
}