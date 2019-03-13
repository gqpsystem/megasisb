package com.megacenter.dao;

import com.megacenter.model.VentaDetalle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IVentaDetalleDAO extends JpaRepository<VentaDetalle , Integer>  {

    
}