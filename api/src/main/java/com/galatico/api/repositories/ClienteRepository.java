package com.galatico.api.repositories;

import com.galatico.api.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    Optional<ClienteEntity> findByNome(String nome);

    boolean existsByNome(String nome);

    /*
    @Query(" select * from tb-clientes where upper (nome) like upper ('%:nome%') ")
    List<ClienteEntity> findByNome (@Param("nome") String nome);*/


}
