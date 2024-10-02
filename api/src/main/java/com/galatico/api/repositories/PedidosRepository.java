package com.galatico.api.repositories;

import com.galatico.api.entity.PedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<PedidosEntity, Integer> {
}
