package com.megacenter.dao;

import com.megacenter.model.DetalleCompra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDetalleCompraDAO extends JpaRepository  < DetalleCompra , Integer >   {

    
}