package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IColaboradorDAO;
import com.megacenter.model.Colaborador;
import com.megacenter.service.IColaboradorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ColaboradorServiceImpl implements IColaboradorService {

    @Autowired
    private IColaboradorDAO dao;

    @Override
    public void registrar(Colaborador colaborador) {
        dao.save(colaborador);
    }

    @Override
    public void modificar(Colaborador colaborador) {
        dao.save(colaborador);
    }

    @Override
    public void eleminar(int idColaborador) {
        dao.deleteById(idColaborador);
    }

    @Override
    public Colaborador listarId(int idColaborador) {
        return dao.findById(idColaborador).get();
    }

    @Override
    public List<Colaborador> listar() {
        return dao.findAll();
    }

    
}