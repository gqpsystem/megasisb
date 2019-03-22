package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IAnulacionComprobanteDAO;
import com.megacenter.model.AnulacionComprobante;
import com.megacenter.service.IAnulacionComprobanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnulacionComprobanteServiceImpl implements IAnulacionComprobanteService {

    @Autowired
    private IAnulacionComprobanteDAO dao;

    @Override
    public void registrar(AnulacionComprobante anulacionComprobante) {
        dao.save(anulacionComprobante);
    }

    @Override
    public void modificar(AnulacionComprobante anulacionComprobante) {
        dao.save(anulacionComprobante); 
    }

    @Override
    public void eliminar(int idanulacionComprobante) {
        dao.deleteById(idanulacionComprobante);
    }

    @Override
    public AnulacionComprobante listarId(int idanulacionComprobante) {
        return dao.findById(idanulacionComprobante).get();
    }

    @Override
    public List<AnulacionComprobante> listar() {
        return dao.findAll();
    }
    
}