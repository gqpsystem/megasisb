package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Categoria;


public interface ICategoriaService {

    void registrar(Categoria categoria);

    void modificar ( Categoria categoria);

    void eliminar ( int idCategoria);

    Categoria listarId(int idCategoria);

    List<Categoria> listar();
    
}