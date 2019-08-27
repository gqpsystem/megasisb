/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megacenter.dao;

import com.megacenter.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author reyme
 */
@Repository
public interface IParentDAO  extends JpaRepository<Parent, Integer> {
    
}
