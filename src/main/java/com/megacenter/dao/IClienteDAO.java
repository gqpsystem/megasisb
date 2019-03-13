package com.megacenter.dao;

import com.megacenter.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDAO  extends JpaRepository < Cliente , Integer > {

    
}