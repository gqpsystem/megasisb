package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IDetalleCompraDAO;
import com.megacenter.model.DetalleCompra;
import com.megacenter.service.IDetalleCompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleCompraServiceImpl implements IDetalleCompraService {

    @Autowired
    private IDetalleCompraDAO dao;

    @Override
    public void registrar(DetalleCompra DetalleCompra) {
        dao.save(DetalleCompra);
    }

    @Override
    public void modificar(DetalleCompra detalleCompra) {
        dao.save(detalleCompra);
    }

    @Override
    public void eliminar(int idDetalleCompra) {
        dao.deleteById(idDetalleCompra);
    }

    @Override
    public DetalleCompra listarId(int idDetalleCompra) {
        return dao.findById(idDetalleCompra).get();
    }

    @Override
    public List<DetalleCompra> listar() {
        return dao.findAll();
    }
    
}