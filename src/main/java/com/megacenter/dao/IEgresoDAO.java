package com.megacenter.dao;

import com.megacenter.model.Egreso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEgresoDAO  extends JpaRepository  < Egreso , Integer  >  {

    
}