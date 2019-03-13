package com.megacenter.dao;

import com.megacenter.model.Proveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IProveedorDAO  extends  JpaRepository <Proveedor , Integer> {

    
}