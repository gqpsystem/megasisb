package com.megacenter.dao;

import com.megacenter.model.TipoComprobante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITipoComprobanteDAO extends JpaRepository <TipoComprobante , Integer> {

    
}