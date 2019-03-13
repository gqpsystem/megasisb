package com.megacenter.dao;

import com.megacenter.model.ControlAsistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IControlAsistenciaDAO  extends JpaRepository < ControlAsistencia , Integer > {

    
}