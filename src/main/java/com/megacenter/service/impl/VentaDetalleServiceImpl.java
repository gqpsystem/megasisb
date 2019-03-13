package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IVentaDetalleDAO;
import com.megacenter.model.VentaDetalle;
import com.megacenter.service.IVentaDetalleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaDetalleServiceImpl implements IVentaDetalleService {

    @Autowired
    private IVentaDetalleDAO dao;

    @Override
    public void registrar(VentaDetalle detalle) {
        dao.save(detalle);
    }

    @Override
    public void modificar(VentaDetalle detalle) {
        dao.save(detalle);
    }

    @Override
    public void eleminar(int idDetalle) {
        dao.deleteById(idDetalle);
    }

    @Override
    public VentaDetalle listarId(int idVentaDetalle) {
        return dao.findById(idVentaDetalle).get();
    }

    @Override
    public List<VentaDetalle> listar() {
        return dao.findAll();
    }


    
}