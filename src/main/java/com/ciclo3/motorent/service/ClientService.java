/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo3.motorent.service;

import com.ciclo3.motorent.model.Category;
import com.ciclo3.motorent.model.Client;
import com.ciclo3.motorent.repository.CategoryRepository;
import com.ciclo3.motorent.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getProduct(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client p){
        if(p.getIdClient()==null){
            return clientRepository.save(p);
        }else{
            Optional<Client> e = clientRepository.getClient(p.getIdClient());
            if(e.isPresent()){

                return p;
            }else{
                return clientRepository.save(p);
            }
        }
    }
    public Client update(Client p){
        if(p.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(p.getIdClient());
            if(q.isPresent()){
                if(p.getName()!=null){
                    q.get().setName(p.getName());
                }
                if(p.getAge()!=null){
                    q.get().setAge(p.getAge());
                }
                if(p.getEmail()!=null){
                    q.get().setEmail(p.getEmail());
                }
                if(p.getPassword()!=null){
                    q.get().setPassword(p.getPassword());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int idClient){
        boolean flag=false;
        Optional<Client>p= clientRepository.getClient(idClient);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }

    public Optional<Client> getClient(int clientId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
