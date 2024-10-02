package com.galatico.api.controllers;

import com.galatico.api.dtos.ClientesDto;
import com.galatico.api.dtos.ProdutosDto;
import com.galatico.api.entity.ClienteEntity;
import com.galatico.api.entity.ProdutosEntity;
import com.galatico.api.service.ProdutosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/produtos")
@RequiredArgsConstructor
public class ProdutosController {

    private final ProdutosService produtosService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ProdutosEntity produtosEntity)
    {
        produtosService.save(produtosEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtosEntity);
    }

    @GetMapping
    public ResponseEntity<List<ProdutosEntity>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(produtosService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findByID(@PathVariable(value = "id") Integer id){
        Optional<ProdutosEntity> clienteEntityOptional = produtosService.findByID(id);
        if(!clienteEntityOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteEntityOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
                                            @RequestBody @Valid ProdutosDto produtosDto) {
        System.out.println(produtosDto);
        Optional<ProdutosEntity> produtosEntityOptional = produtosService.findByID(id);
        if (!produtosEntityOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
        var produtosEntity = new ProdutosEntity();
        BeanUtils.copyProperties(produtosDto, produtosEntity);
        produtosEntity.setId(produtosEntityOptional.get().getId());
        produtosEntity.setData_cadastro(produtosEntityOptional.get().getData_cadastro());
        return ResponseEntity.status(HttpStatus.OK).body(produtosService.atualizar(produtosEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id){
        Optional<ProdutosEntity> produtosEntityOptional = produtosService.findByID(id);
        if(!produtosEntityOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }
        produtosService.delete(produtosEntityOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produto Deletado com sucesso!");
    }
}
