package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IProductoDAO;
import com.megacenter.model.Producto;
import com.megacenter.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoDAO dao;

    @Override
    public void registrar(Producto producto) {
        dao.save(producto);
    }

    @Override
    public void modificar(Producto producto) {
        dao.save(producto);
    }

    @Override
    public void eleminar(int idProducto) {
        dao.deleteById(idProducto);
    }

    @Override
    public Producto listarId(int idProducto) {
        return dao.findById(idProducto).get();
    }

    @Override
    public List<Producto> listar() {
        return dao.findAll();
    }

}