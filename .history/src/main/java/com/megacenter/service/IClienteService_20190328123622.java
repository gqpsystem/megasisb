package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Cliente;

public interface IClienteService {

    Cliente registrar(Cliente cliente);

    void modificar(Cliente cliente);

    void eliminar(int idCliente);

    Cliente listarId(int idCliente);

    List<Cliente> listar();
    
}