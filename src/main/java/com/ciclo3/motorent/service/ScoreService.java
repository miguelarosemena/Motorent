/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.service;

import com.ciclo3.motorent.model.Score;
import com.ciclo3.motorent.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score p){
        if(p.getIdEvaluation()==null){
            return scoreRepository.save(p);
        }else{
            Optional<Score> e = scoreRepository.getScore(p.getIdEvaluation());
            if(e.isPresent()){

                return p;
            }else{
                return scoreRepository.save(p);
            }
        }
    }
    public Score update(Score p){
        if(p.getIdEvaluation()!=null){
            Optional<Score> q = scoreRepository.getScore(p.getIdEvaluation());
            if(q.isPresent()){
                if(p.getTextEvaluation()!=null){
                    q.get().setTextEvaluation(p.getTextEvaluation());
                }
                if(p.getScoreGrade()!=null){
                    q.get().setScoreGrade(p.getScoreGrade());
                }
                scoreRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Score>p= scoreRepository.getScore(id);
        if(p.isPresent()){
            scoreRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }
}
