package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IVentaEfectivoDAO;
import com.megacenter.model.VentaEfectivo;
import com.megacenter.service.IVentaEfectivoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentaEfectivoServiceImpl implements IVentaEfectivoService {

    @Autowired
    private IVentaEfectivoDAO dao;

    @Override
    public void registrar(VentaEfectivo ventaEfectivo) {
        dao.save(ventaEfectivo);
    }

    @Override
    public void modificar(VentaEfectivo ventaEfectivo) {
        dao.save(ventaEfectivo);
    }

    @Override
    public void eleminar(int idVentaEfectivo) {
        dao.deleteById(idVentaEfectivo);
    }

    @Override
    public VentaEfectivo listarId(int idVentaEfectivo) {
        return dao.findById(idVentaEfectivo).get();
    }

    @Override
    public List<VentaEfectivo> listar() {
        return dao.findAll();
    }

    
}