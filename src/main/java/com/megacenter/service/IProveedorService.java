package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Proveedor;

public interface IProveedorService {

    void registrar(Proveedor proveedor);

    void modificar(Proveedor proveedor);

    void eleminar(int idProveedor);

    Proveedor listarId(int idProveedor);

    List<Proveedor> listar();

}