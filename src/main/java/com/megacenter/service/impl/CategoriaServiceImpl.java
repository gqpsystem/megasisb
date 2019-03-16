package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.ICategoriaDAO;
import com.megacenter.model.Categoria;
import com.megacenter.service.ICategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoriaServiceImpl implements ICategoriaService {


    @Autowired
    private ICategoriaDAO dao;

    @Override
    public void registrar(Categoria categoria) {
        dao.save(categoria);
    }

    @Override
    public void modificar(Categoria categoria) {
        dao.save(categoria);
    }

    @Override
    public void eliminar(int idCategoria) {
        dao.deleteById(idCategoria);
    }

    @Override
    public Categoria listarId(int idCategoria) {
        return dao.findById(idCategoria).get();
    }

    @Override
    public List<Categoria> listar() {
        return dao.findAll();
    }

    
}