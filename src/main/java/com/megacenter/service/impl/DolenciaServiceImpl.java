package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IDolenciaDAO;
import com.megacenter.model.Dolencia;
import com.megacenter.service.IDolenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DolenciaServiceImpl implements IDolenciaService {

    @Autowired
    private IDolenciaDAO dao;

    @Override
    public void registrar(Dolencia dolencia) {
        dao.save(dolencia);
    }

    @Override
    public void modificar(Dolencia dolencia) {
        dao.save(dolencia);
    }

    @Override
    public void eliminar(int idDolencia) {
        dao.deleteById(idDolencia);
    }

    @Override
    public Dolencia listarId(int idDolencia) {
        return dao.findById(idDolencia).get();
    }

    @Override
    public List<Dolencia> listar() {
        return dao.findAll();
    }
}