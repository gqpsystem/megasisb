package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.ITipoDocumentoDAO;
import com.megacenter.model.TipoDocumento;
import com.megacenter.service.ITipoDocumentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

    @Autowired
    private ITipoDocumentoDAO dao;


    @Override
    public void registrar(TipoDocumento documento) {
        dao.save(documento);
    }

    @Override
    public void modificar(TipoDocumento documento) {
        dao.save(documento);
    }

    @Override
    public void eleminar(int idDocumento) {
        dao.deleteById(idDocumento);
    }

    @Override
    public TipoDocumento listarId(int idDocumento) {
        return dao.findById(idDocumento).get();
    }

    @Override
    public List<TipoDocumento> listar() {
        return dao.findAll();
    }

    
}