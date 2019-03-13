package com.megacenter.dao;

import com.megacenter.model.UnidadMedida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnidadMedidaDAO extends JpaRepository<UnidadMedida, Integer> {

}
