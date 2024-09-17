package com.galatico.api.repositories;

import com.galatico.api.entity.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Integer> {
}
