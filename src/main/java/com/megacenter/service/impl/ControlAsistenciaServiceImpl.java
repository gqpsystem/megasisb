package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IControlAsistenciaDAO;
import com.megacenter.model.ControlAsistencia;
import com.megacenter.service.IControlAsistenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ControlAsistenciaServiceImpl implements IControlAsistenciaService {

    @Autowired
    private IControlAsistenciaDAO dao;

    @Override
    public void registrar(ControlAsistencia asistencia) {
        dao.save(asistencia);
    }

    @Override
    public void modificar(ControlAsistencia asistencia) {
        dao.save(asistencia);
    }

    @Override
    public void eliminar(int idAsistencia) {
        dao.deleteById(idAsistencia);
    }

    @Override
    public ControlAsistencia listarId(int idAsistencia) {
        return dao.findById(idAsistencia).get();
    }

    @Override
    public List<ControlAsistencia> listar() {
        return dao.findAll();
    }
    
}