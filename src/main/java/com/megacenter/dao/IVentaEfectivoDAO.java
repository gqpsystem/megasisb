package com.megacenter.dao;

import com.megacenter.model.VentaEfectivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaEfectivoDAO  extends JpaRepository < VentaEfectivo , Integer > {

    
}