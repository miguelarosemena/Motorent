/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.repository;

import com.ciclo3.motorent.model.Motorbike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.ciclo3.motorent.repository.crudRepository.MotorbikeCrudRepository;

@Repository
public class MotorbikeRepository {
    @Autowired
    private MotorbikeCrudRepository MotoCrudRepository;
    public List<Motorbike> getAll(){
        return (List<Motorbike>) MotoCrudRepository.findAll();
    }
    public Optional<Motorbike> getMotorbike(int id){
        return MotoCrudRepository.findById(id);
    }
    public Motorbike save(Motorbike p){
        return MotoCrudRepository.save(p);
    }
    public void delete(Motorbike p){
        MotoCrudRepository.delete(p);
    }
}
