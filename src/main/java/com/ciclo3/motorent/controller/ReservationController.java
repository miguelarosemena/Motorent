/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.controller;

import com.ciclo3.motorent.model.ReportClient;
import com.ciclo3.motorent.model.Reservation;
import com.ciclo3.motorent.model.Status;
import com.ciclo3.motorent.service.ReservationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation p){
        return reservationService.save(p);
    }
    
    @GetMapping("/(id)")
    public Optional<Reservation> getReservation(@PathVariable("id") int idReservation){
        return reservationService.getReservation(idReservation);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
      
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id){
        return reservationService.delete(id);
    }
    
    @GetMapping("/report-status")
    public Status getStatus(){
        return reservationService.getStatus();
    }
    
    @GetMapping("/report-clients")
    public List<ReportClient> getReportClient(){
        return reservationService.getReportClient();
    }
    
    @GetMapping("/report-dates/{startDate}/{devolutionDate}")
    public List<Reservation> getReportdate(@PathVariable String startDate, @PathVariable String devolutionDate) throws ParseException{
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(devolutionDate);
        return reservationService.getReportDates(date1,date2);
    }

}
