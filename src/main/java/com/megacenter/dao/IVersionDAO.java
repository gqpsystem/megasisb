package com.megacenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IVersionDAO extends JpaRepository<Version,Integer> {

    List<Version> getAllByCompleteOrderByNumberDesc(boolean complete);

    List<Version> getAllByDateLessThan(Date date);
}
