package com.megacenter.dao;

import com.megacenter.model.Caja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICajaDAO extends JpaRepository<Caja, Integer> {

}