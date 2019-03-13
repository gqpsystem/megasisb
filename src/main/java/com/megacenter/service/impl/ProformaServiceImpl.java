package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IProformaDAO;
import com.megacenter.model.Proforma;
import com.megacenter.service.IProformaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProformaServiceImpl implements IProformaService {


    @Autowired
    private IProformaDAO dao;

    @Override
    public void registrar(Proforma proforma) {
        dao.save(proforma);
    }       

    @Override
    public void modificar(Proforma proforma) {
        dao.save(proforma);
    }

    @Override
    public void eleminar(int idProforma) {
        dao.deleteById(idProforma);
    }

    @Override
    public Proforma listarId(int idProforma) {
        return dao.findById(idProforma).get();
    }

    @Override
    public List<Proforma> listar() {
        return dao.findAll();
    }

    
}