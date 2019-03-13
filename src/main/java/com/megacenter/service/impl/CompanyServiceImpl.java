package com.megacenter.service.impl;

import java.util.List;

import com.megacenter.dao.ICompanyDAO;
import com.megacenter.model.Company;
import com.megacenter.service.ICompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyDAO dao;

    @Override
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
    }
}