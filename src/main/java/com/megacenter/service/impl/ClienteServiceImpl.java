package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.IClienteDAO;
import com.megacenter.model.Cliente;
import com.megacenter.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDAO dao;

    @Override
    public Cliente registrar(Cliente cliente) {
       return dao.save(cliente);
    }

    @Override
    public Cliente modificar(Cliente cliente) {
       return dao.save(cliente);
    }

    @Override
    public void eliminar(int idCliente) {
        dao.deleteById(idCliente);
    }

    @Override
    public Cliente listarId(int idCliente) {
        return dao.findById(idCliente).get();
    }

    @Override
    public List<Cliente> listar() {
        return dao.findAll();
    }


}