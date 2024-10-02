package com.galatico.api.service;

import com.galatico.api.entity.ClienteEntity;
import com.galatico.api.entity.PedidosEntity;
import com.galatico.api.repositories.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ClienteService clienteService;

    public PedidosEntity save(PedidosEntity pedido) {
        pedido.setData_pedido(LocalDate.now());
        Optional<ClienteEntity> optionalClienteEntity = clienteService.findByID(pedido.getClienteEntity().getId());
        if (!optionalClienteEntity.isPresent()) {
            //criar Exceção
            return null;
        }
        pedido.setClienteEntity(optionalClienteEntity.get());

        return pedidosRepository.save(pedido);
    }

    public List<PedidosEntity> findAll() {
        return pedidosRepository.findAll();
    }

    public Optional<PedidosEntity> findByID(Integer id) {
        return pedidosRepository.findById(id);
    }

    public PedidosEntity atualizar (PedidosEntity pedidosEntity){
        return pedidosRepository.save(pedidosEntity);
    }

    public void delete(PedidosEntity pedidosEntity){
        pedidosRepository.delete(pedidosEntity);
    }

}
