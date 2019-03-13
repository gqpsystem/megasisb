package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Dolencia;

public interface IDolenciaService {

    void registrar(Dolencia dolencia);

    void modificar(Dolencia dolencia);

    void eleminar(int idDolencia);

    Dolencia listarId(int idDolencia);

    List<Dolencia> listar();


}