/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "motorbike")
public class Motorbike implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true,nullable=false)
    private Integer id;
    @Column(length=45,unique=false,nullable=false)
    private String name;
    @Column(length=45,unique=false,nullable=false)
    private String brand;
    @Column(name="`year`",length=4,unique=false,nullable=false)
    private Integer year;
    @Column(length=250,unique=false,nullable=false)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("motorbikes")
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike","client"})
    private List<Message> messages;
    

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "motorbike")
    @JsonIgnoreProperties({"motorbike","messages"})
    public List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }


}
