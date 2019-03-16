package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.ICajaFuerteDAO;
import com.megacenter.model.CajaFuerte;
import com.megacenter.service.ICajaFuerteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CajaFuerteServiceImpl implements ICajaFuerteService {


    @Autowired
    private ICajaFuerteDAO dao;

    @Override
    public void registrar(CajaFuerte cajaFuerte) {
        dao.save(cajaFuerte);
    }

    @Override
    public void modificar(CajaFuerte cajaFuerte) {
        dao.save(cajaFuerte);
    }

    @Override
    public void eliminar(int idCajaFuerte) {
        dao.deleteById(idCajaFuerte);
    }

    @Override
    public CajaFuerte listarId(int idCajaFuerte) {
        return dao.findById(idCajaFuerte).get();
    }

    @Override
    public List<CajaFuerte> listar() {
        return dao.findAll();
    }

    
}