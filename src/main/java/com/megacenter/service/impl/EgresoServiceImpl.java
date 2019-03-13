package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IEgresoDAO;
import com.megacenter.model.Egreso;
import com.megacenter.service.IEgresoService;

import org.springframework.beans.factory.annotation.Autowired;


public class EgresoServiceImpl implements IEgresoService {

    @Autowired
    private IEgresoDAO dao;

    @Override
    public void registrar(Egreso egreso) {
        dao.save(egreso);
    }

    @Override
    public void modificar(Egreso egreso) {
        dao.save(egreso);
    }

    @Override
    public void eleminar(int idEgreso) {
        dao.deleteById(idEgreso);
    }

    @Override
    public Egreso listarId(int idEgreso) {
        return dao.findById(idEgreso).get();
    }

    @Override
    public List<Egreso> listar() {
        return dao.findAll();
    }


}