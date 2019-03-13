package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IVentaTipoComprobanteDAO;
import com.megacenter.model.VentaTipoComprobante;
import com.megacenter.service.IVentaTipoComprobanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaTipoComprobanteServiceImpl implements IVentaTipoComprobanteService {

    @Autowired
    private IVentaTipoComprobanteDAO dao;


    @Override
    public void registrar(VentaTipoComprobante ventaTipoComprobante) {
        dao.save(ventaTipoComprobante);
    }       

    @Override
    public void modificar(VentaTipoComprobante ventaTipoComprobante) {
        dao.save(ventaTipoComprobante);
    }

    @Override
    public void eleminar(int idVentaTipoComprobante) {
        dao.deleteById(idVentaTipoComprobante);
    }

    @Override
    public VentaTipoComprobante listarId(int idVentaTipoComprobante) {
        return dao.findById(idVentaTipoComprobante).get();
    }

    @Override
    public List<VentaTipoComprobante> listar() {
        return dao.findAll();
    }

    
}