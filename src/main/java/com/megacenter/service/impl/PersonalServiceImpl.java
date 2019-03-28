package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IColaboradorDAO;
import com.megacenter.model.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.megacenter.service.IPersonalService;


@Service
public class PersonalServiceImpl implements IPersonalService {

    @Autowired
    private IColaboradorDAO dao;

    @Override
    public Personal registrar(Personal personal) {
        return dao.save(personal);
    }

    @Override
    public Personal modificar(Personal personal) {
        return dao.save(personal);
    }

    @Override
    public void eliminar(int idPersonal) {
        dao.deleteById(idPersonal);
    }

    @Override
    public Personal listarId(int idPersonal ){
        return dao.findById(idPersonal).get();
    }

    @Override
    public List<Personal> listar() {
        return dao.findAll();
    }

    
}