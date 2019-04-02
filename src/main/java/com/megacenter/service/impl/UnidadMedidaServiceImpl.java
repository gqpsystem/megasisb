package com.megacenter.service.impl;

import com.megacenter.dao.IUnidadMedidaDAO;
import com.megacenter.model.UnidadMedida;
import com.megacenter.service.IUnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadMedidaServiceImpl implements IUnidadMedidaService {

    @Autowired
    private IUnidadMedidaDAO dao;

    @Override
    public void registrar(UnidadMedida unidadMedida) {
        dao.save(unidadMedida);

    }

    @Override
    public void modificar(UnidadMedida unidadMedida) {
        dao.save(unidadMedida);

    }

    @Override
    public void eliminar(int idUnidadMedida) {
        dao.deleteById(idUnidadMedida);

    }

    @Override
    public UnidadMedida listarId(int idUnidadMedida) {
        return dao.findById(idUnidadMedida).get();
    }

    @Override
    public List<UnidadMedida> listar() {
        return dao.findAll();
    }

}
