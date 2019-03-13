package com.megacenter.dao;

import com.megacenter.model.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICompanyDAO  extends JpaRepository < Company , Integer > {

    
}