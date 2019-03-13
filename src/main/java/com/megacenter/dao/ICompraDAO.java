package com.megacenter.dao;

import com.megacenter.model.Compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICompraDAO  extends JpaRepository < Compra , Integer  >  { 

    
}