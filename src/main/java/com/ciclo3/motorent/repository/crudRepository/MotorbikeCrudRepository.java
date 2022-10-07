/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.repository.crudRepository;

import com.ciclo3.motorent.model.Motorbike;
import org.springframework.data.repository.CrudRepository;

public interface MotorbikeCrudRepository extends CrudRepository<Motorbike,Integer> {
    
}
