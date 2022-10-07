/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.repository;

import com.ciclo3.motorent.model.Category;
import com.ciclo3.motorent.model.Lib;
import com.ciclo3.motorent.repository.crudRepository.LibCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LibRepository {
    @Autowired
    private LibCrudRepository libCrudRepository;

    public List<Lib> getAll(){
        return (List<Lib>) libCrudRepository.findAll();
    }

    public Optional<Lib> getLib(int id){
        return libCrudRepository.findById(id);
    }
    public Lib save(Lib c){
        return libCrudRepository.save(c);
    }
    public void delete(Lib c){
        libCrudRepository.delete(c);
    }

}
