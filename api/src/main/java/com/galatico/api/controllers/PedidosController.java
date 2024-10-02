package com.galatico.api.controllers;

import com.galatico.api.entity.PedidosEntity;
import com.galatico.api.entity.ProdutosEntity;
import com.galatico.api.service.PedidosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/pedidos")
@RequiredArgsConstructor
public class PedidosController {

    private final PedidosService pedidosService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody PedidosEntity pedidosEntity) {
        pedidosService.save(pedidosEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidosEntity);
    }

    @GetMapping
    public ResponseEntity<List<PedidosEntity>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pedidosService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findByID(@PathVariable(value = "id") Integer id) {
        Optional<PedidosEntity> pedidosEntityOptional = pedidosService.findByID(id);
        if (!pedidosEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidosEntityOptional.get());
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
                                            @RequestBody PedidosEntity pedidosEntity) {
        Optional<PedidosEntity> pedidosEntityOptional = pedidosService.findByID(id);
        if (!pedidosEntityOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }
        var pedidoAtualizado = new PedidosEntity();
        BeanUtils.copyProperties(pedidosEntity, pedidoAtualizado);
        pedidoAtualizado.setId(pedidosEntityOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pedidosService.atualizar(pedidoAtualizado));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletar( @PathVariable(value = "id") Integer id){
        Optional<PedidosEntity> pedidosEntityOptional = pedidosService.findByID(id);
        if (!pedidosEntityOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }
        pedidosService.delete(pedidosEntityOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pedido deletado com sucesso!");
    }


}
