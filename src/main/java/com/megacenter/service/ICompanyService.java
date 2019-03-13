package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Company;

public interface ICompanyService {

    void registrar(Company company);

    void modificar (Company company);

    void eleminar(int idCompany);

    Company listarId(int idCompany);

    List<Company> listar();
    
}