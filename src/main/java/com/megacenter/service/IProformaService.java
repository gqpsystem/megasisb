package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Proforma;

public interface IProformaService {

    void registrar(Proforma proforma);

    void modificar(Proforma proforma);

    void eliminar(int idProforma);

    Proforma listarId(int idProforma);

    List<Proforma> listar();
}