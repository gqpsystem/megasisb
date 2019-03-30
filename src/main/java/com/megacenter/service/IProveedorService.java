package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Proveedor;

public interface IProveedorService {

    Proveedor registrar(Proveedor proveedor);

    Proveedor modificar(Proveedor proveedor);

    void eliminar(int idProveedor);

    Proveedor listarId(int idProveedor);

    List<Proveedor> listar();

}