/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.service;

import com.ciclo3.motorent.model.Category;
import com.ciclo3.motorent.model.Lib;
import com.ciclo3.motorent.repository.LibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibService {
    @Autowired
    private LibRepository libRepository;

    public List<Lib> getAll(){
        return libRepository.getAll();
    }
    public Optional<Lib> getLib(int idLib){
        return libRepository.getLib(idLib);
    }
    public Lib save(Lib p){
        if(p.getIdLib()==null){
            return libRepository.save(p);
        }else{
            Optional<Lib> e = libRepository.getLib(p.getIdLib());
            if(e.isPresent()){
                return p;
            }else{
                return libRepository.save(p);
            }
        }
    }
    public Lib update(Lib p){
        if(p.getIdLib()!=null){
            Optional<Lib> q = libRepository.getLib(p.getIdLib());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getDescription()!=null){
                    q.get().setDescription(p.getDescription());
                }
                if(p.getTarget()!=null){
                    q.get().setTarget(p.getTarget());
                }
                if(p.getCategory()!=null){
                    q.get().setCategory(p.getCategory());
                }

                libRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int idLib){
        boolean flag=false;
        Optional<Lib>p= libRepository.getLib(idLib);
        if(p.isPresent()){
            libRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }
}
