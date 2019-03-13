package com.megacenter.dao;

import com.megacenter.model.Colaborador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColaboradorDAO  extends JpaRepository<Colaborador , Integer> {

    
}