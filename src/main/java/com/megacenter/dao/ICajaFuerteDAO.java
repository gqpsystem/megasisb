package com.megacenter.dao;

import com.megacenter.model.CajaFuerte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICajaFuerteDAO  extends JpaRepository<CajaFuerte , Integer>{

    
}