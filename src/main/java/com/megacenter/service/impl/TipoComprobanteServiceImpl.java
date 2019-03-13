package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.ITipoComprobanteDAO;
import com.megacenter.model.TipoComprobante;
import com.megacenter.service.ITipoComprobanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TipoComprobanteServiceImpl implements ITipoComprobanteService {

    @Autowired
    private ITipoComprobanteDAO dao;


    @Override
    public void registrar(TipoComprobante comprobante) {
        dao.save(comprobante);
    }

    @Override
    public void modificar(TipoComprobante comprobante) {
        dao.save(comprobante);
    }

    @Override
    public void eleminar(int idComprobante) {
        dao.deleteById(idComprobante);
    }

    @Override
    public TipoComprobante listarId(int idComprobante) {
        return dao.findById(idComprobante).get();
    }

    @Override
    public List<TipoComprobante> listar() {
        return dao.findAll();
    }

    
}