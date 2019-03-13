package com.megacenter.dao;

import com.megacenter.model.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaDAO extends JpaRepository <Venta ,Integer >   {

    
}