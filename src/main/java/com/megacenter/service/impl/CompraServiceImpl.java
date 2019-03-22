package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.ICompraDAO;
import com.megacenter.model.Compra;
import com.megacenter.service.ICompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    private ICompraDAO dao;

    @Override
    public void registrar(Compra compra) {
        dao.save(compra);
    }

    @Override
    public void modificar(Compra compra) {
        dao.save(compra);
    }

    @Override
    public void eliminar(int idCompra) {
        dao.deleteById(idCompra);
    }

    @Override
    public Compra listarId(int idCompra) {
        return dao.findById(idCompra).get();
    }

    @Override
    public List<Compra> listar() {
        return dao.findAll();
    }

    
}