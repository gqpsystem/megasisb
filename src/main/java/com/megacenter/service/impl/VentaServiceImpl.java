package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IVentaDAO;
import com.megacenter.model.Venta;
import com.megacenter.service.IVentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    private IVentaDAO dao;

    @Override
    public void registrar(Venta venta) {
        dao.save(venta);
    }   

    @Override
    public void modificar(Venta venta) {
        dao.save(venta);
    }

    @Override
    public void eleminar(int idVenta) {
        dao.deleteById(idVenta);
    }

    @Override
    public Venta listarId(int idVenta) {
        return dao.findById(idVenta).get();
    }

    @Override
    public List<Venta> listar() {
        return dao.findAll();
    }

    
}