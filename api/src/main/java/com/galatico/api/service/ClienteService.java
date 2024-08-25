package com.galatico.api.service;

import com.galatico.api.entity.ClienteEntity;
import com.galatico.api.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteEntity save (ClienteEntity clienteEntity){
        boolean exists = clienteRepository.existsByNome(clienteEntity.getNome());
        if (!exists){
            return clienteRepository.save(clienteEntity);
        };
        return null;
    }

    public Optional<ClienteEntity> findByID(Integer id){
        return  clienteRepository.findById(id);
    }

    public List<ClienteEntity> findAll(){
        return clienteRepository.findAll();
    }

    public List<ClienteEntity> findByNome(String nome){
       return clienteRepository.findByNome(nome);
    }

}
