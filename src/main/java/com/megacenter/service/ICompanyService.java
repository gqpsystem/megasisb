package com.megacenter.service;

import java.util.List;

import com.megacenter.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICompanyService {

    /*void registrar(Company company);

    void modificar (Company company);

    void eliminar(int idCompany);

    Company listarId(int idCompany);

    List<Company> listar();*/

    Company findByRazonSocialOrRuc(String razonSocial, String ruc);

    Page<Company> getAll(Pageable pageable);

    Company getById(int id);

    Page<Company> findByRazonSocialContains(String razonSocial, Pageable pageable);

    Company findByRazonSocialIgnoreCase(String razonSocial);

    Company findByRuc(String ruc);

    List<Company> getCompaniesByRucOrRazonSocial(String razonSocial, String ruc);
    
}