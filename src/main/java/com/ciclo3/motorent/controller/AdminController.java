/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.controller;

import com.ciclo3.motorent.model.Admin;
import com.ciclo3.motorent.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody  Admin c){
        return adminService.save(c);
    }
    
    @GetMapping("/(id)")
    public Optional<Admin> getAdmin(@PathVariable("id") int idAdmin){
        return adminService.getAdmin(idAdmin);
    }
    

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin c){
        return adminService.update(c);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return adminService.delete(id);
    }
}
