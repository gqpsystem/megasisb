package com.megacenter.dao;

import com.megacenter.model.Dolencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface IDolenciaDAO  extends  JpaRepository < Dolencia , Integer  >  {

    
}