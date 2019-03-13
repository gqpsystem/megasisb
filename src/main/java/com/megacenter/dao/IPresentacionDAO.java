package com.megacenter.dao;

import com.megacenter.model.Presentacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPresentacionDAO  extends JpaRepository < Presentacion , Integer >  {

    
}