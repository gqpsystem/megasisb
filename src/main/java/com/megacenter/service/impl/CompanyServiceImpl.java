package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.ICompanyDAO;
import com.megacenter.model.Company;
import com.megacenter.service.ICompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyDAO dao;

    @Override
    public Company findByRazonSocialOrRuc(String razonSocial, String ruc) {
        return dao.findByRazonSocialOrRuc(razonSocial,ruc);
    }

    @Override
    public Page<Company> getAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public Company getById(int id) {
        return dao.getOne(id);
    }

    @Override
    public Page<Company> findByRazonSocialContains(String razonSocial, Pageable pageable) {
        return dao.findByRazonSocialContains(razonSocial,pageable);
    }

    @Override
    public Company findByRazonSocialIgnoreCase(String razonSocial) {
        return dao.findByRazonSocialIgnoreCase(razonSocial);
    }

    @Override
    public Company findByRuc(String ruc) {
        return dao.findByRuc(ruc);
    }

    @Override
    public List<Company> getCompaniesByRucOrRazonSocial(String razonSocial, String ruc) {
        return null;
    }

    /*@Override
    public void registrar(Company company) {
        dao.save(company);
    }

    @Override
    public void modificar(Company company) {
        dao.save(company);
    }

    @Override
    public void eleminar(int idCompany) {
        dao.deleteById(idCompany);
    }

    @Override
    public Company listarId(int idCompany) {
        return dao.findById(idCompany).get();
    }

    @Override
    public List<Company> listar() {
        return dao.findAll();
    }*/
}