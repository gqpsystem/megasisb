package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IPresentacionDAO;
import com.megacenter.model.Presentacion;
import com.megacenter.service.IPresentacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PresentacionServiceImpl implements IPresentacionService {

    @Autowired
    private IPresentacionDAO dao;

    @Override
    public void registrar(Presentacion presentacion) {
        dao.save(presentacion);
    }

    @Override
    public void modificar(Presentacion presentacion) {
        dao.save(presentacion);
    }

    @Override
    public void eleminar(int idPresentacion) {
        dao.deleteById(idPresentacion);
    }

    @Override
    public Presentacion listarId(int idPresentacion) {
        return dao.findById(idPresentacion).get();
    }

    @Override
    public List<Presentacion> listar() {
        return dao.findAll();
    }


}