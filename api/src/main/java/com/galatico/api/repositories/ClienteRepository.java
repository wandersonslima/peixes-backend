package com.galatico.api.repositories;

import com.galatico.api.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    boolean existsByNome(String nome);

   @Query(" select c from ClienteEntity c where (c.nome) ilike %:nome% ")
    List<ClienteEntity> findByNome (@Param("nome") String nome);


}
