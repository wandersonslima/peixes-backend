package com.galatico.api.service;

import com.galatico.api.entity.ProdutosEntity;
import com.galatico.api.repositories.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    ProdutosRepository produtosRepository;

    public ProdutosEntity save (ProdutosEntity produtosEntity){

        //LocalDate data = LocalDate.now();
        produtosEntity.setData_cadastro(LocalDate.now());
        return produtosRepository.save(produtosEntity);
    }

    public ProdutosEntity atualizar (ProdutosEntity produtosEntity) {
        return produtosRepository.save(produtosEntity);
    }

    public List<ProdutosEntity> findAll(){
        return produtosRepository.findAll();
    }

    public Optional<ProdutosEntity> findByID(Integer id){
        return  produtosRepository.findById(id);
    }

    public void delete(ProdutosEntity produtosEntity){
        produtosRepository.delete(produtosEntity);
    }

}
