package com.megacenter.dao;

import com.megacenter.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoDAO  extends JpaRepository  <  Producto , Integer > {

    
}