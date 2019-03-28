package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IPersonaDAO;
import com.megacenter.model.Persona;
import com.megacenter.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDAO dao;

    @Override
    public Persona registrar(Persona persona) {
        return dao.save(persona);
    }

    @Override
    public Persona modificar(Persona persona) {
        return dao.save(persona);
    }

    @Override
    public void eliminar(int idPersona) {
        dao.deleteById(idPersona);
    }

    @Override
    public Persona listarId(int idPersona) {
        return dao.findById(idPersona).get();
    }

    @Override
    public List<Persona> listar() {
        return dao.findAll();
    }

    
}