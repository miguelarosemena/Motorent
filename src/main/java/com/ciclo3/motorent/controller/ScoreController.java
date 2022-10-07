/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.controller;

import com.ciclo3.motorent.model.Score;
import com.ciclo3.motorent.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody  Score c){
        return scoreService.save(c);
    }
    
    @GetMapping("/(id)")
    public Optional<Score> getScore(@PathVariable("id") int idScore){
        return scoreService.getScore(idScore);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return scoreService.update(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return scoreService.delete(id);
    }

}
