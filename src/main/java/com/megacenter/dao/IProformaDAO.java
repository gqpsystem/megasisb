package com.megacenter.dao;

import com.megacenter.model.Proforma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProformaDAO  extends JpaRepository <Proforma , Integer> {

    
}