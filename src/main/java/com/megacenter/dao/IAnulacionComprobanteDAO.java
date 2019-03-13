package com.megacenter.dao;

import com.megacenter.model.AnulacionComprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnulacionComprobanteDAO extends JpaRepository<AnulacionComprobante, Integer> {

    
}