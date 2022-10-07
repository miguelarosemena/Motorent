/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.controller;

import com.ciclo3.motorent.model.Lib;
import com.ciclo3.motorent.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Lib")
public class LibController {
    @Autowired
    private LibService libService;

    @GetMapping("/all")
    public List<Lib> getAll(){
        return libService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Lib save(@RequestBody  Lib p){
        return libService.save(p);
    }
    
    @GetMapping("/(id)")
    public Optional<Lib> getLib(@PathVariable("id") int idLib){
        return libService.getLib(idLib);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Lib update(@RequestBody Lib lib){
        return libService.update(lib);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return libService.delete(id);
    }
}
