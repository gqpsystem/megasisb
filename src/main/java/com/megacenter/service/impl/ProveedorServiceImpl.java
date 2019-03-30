package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IProveedorDAO;
import com.megacenter.model.Proveedor;
import com.megacenter.service.IProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorDAO dao;

    @Override
    public Proveedor registrar(Proveedor proveedor) {
        return dao.save(proveedor);
    }

    @Override
    public Proveedor modificar(Proveedor proveedor) {
        return dao.save(proveedor) ;
    }

    @Override
    public void eliminar(int idProveedor) {
        dao.deleteById(idProveedor);
    }

    @Override
    public Proveedor listarId(int idProveedor) {
        return dao.findById(idProveedor).get();
    }

    @Override
    public List<Proveedor> listar() {
        return dao.findAll();
    }

    
}