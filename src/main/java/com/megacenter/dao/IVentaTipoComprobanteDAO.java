package com.megacenter.dao;

import com.megacenter.model.VentaTipoComprobante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IVentaTipoComprobanteDAO  extends JpaRepository  < VentaTipoComprobante , Integer > {

    
}