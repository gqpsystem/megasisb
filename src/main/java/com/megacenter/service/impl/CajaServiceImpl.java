package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.ICajaDAO;
import com.megacenter.model.Caja;
import com.megacenter.service.ICajaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CajaServiceImpl implements ICajaService {

    @Autowired
    private ICajaDAO dao;


    @Override
    public void registrar(Caja caja) {
        dao.save(caja);
    }

    @Override
    public void modificar(Caja caja) {
        dao.save(caja);
    }

    @Override
    public void eleminar(int idCaja) {
        dao.deleteById(idCaja);
    }

    @Override
    public Caja listarId(int idCaja) {
        return dao.findById(idCaja).get();
    }

    @Override
    public List<Caja> listar() {
        return dao.findAll();
    }

    
}