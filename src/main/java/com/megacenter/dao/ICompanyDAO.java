package com.megacenter.dao;

import com.megacenter.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICompanyDAO  extends JpaRepository < Company , Integer > {

    Company findByRazonSocialOrRuc(String razonSocial, String ruc);

    Page<Company> findAll(Pageable pageable);

    Page<Company> findByRazonSocialContains(String razonSocial, Pageable pageable);

    Company findByRuc(String ruc);

    Company findByRazonSocialIgnoreCase(String razonSocial);
}