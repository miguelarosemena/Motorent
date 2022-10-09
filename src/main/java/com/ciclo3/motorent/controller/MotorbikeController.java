/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.controller;

import com.ciclo3.motorent.model.Motorbike;
import com.ciclo3.motorent.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Motorbike")
public class MotorbikeController {
    @Autowired
    private MotorbikeService motorbikeService;

    @GetMapping("/all")
    public List<Motorbike> getAll(){
        return motorbikeService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody  Motorbike c){
        return motorbikeService.save(c);
    }
    
    
    @GetMapping("/(id)")
    public Optional<Motorbike> getMotorbike(@PathVariable("id") int idMoto){
        return motorbikeService.getMotorbike(idMoto);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike update(@RequestBody Motorbike motorbike){
        return motorbikeService.update(motorbike);
    }
        
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return motorbikeService.delete(id);
    }

}
