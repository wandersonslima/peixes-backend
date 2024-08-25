package com.galatico.api.controllers;

import com.galatico.api.entity.ClienteEntity;
import com.galatico.api.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ClienteEntity clienteEntity)
    {
       Optional<ClienteEntity> clientEntityOptinal = Optional.ofNullable(clienteService.save(clienteEntity));

       if (clientEntityOptinal.isPresent()){
           clienteService.save(clienteEntity);
           return ResponseEntity.status(HttpStatus.CREATED).body(clienteEntity);
       }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Cliente já cadastrado !");
    }

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findByID(@PathVariable(value = "id") Integer id){
        Optional<ClienteEntity> clienteEntityOptional = clienteService.findByID(id);
        if(!clienteEntityOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteEntityOptional.get());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Object> findByNome(@PathVariable(value = "nome") String nome)
    {
        List<ClienteEntity> clienteEntity = clienteService.findByNome(nome);

        if(!clienteEntity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(clienteEntity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id){
        Optional<ClienteEntity> clienteEnityOptional = clienteService.findByID(id);
        if(!clienteEnityOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        clienteService.delete(clienteEnityOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente Deletado com sucesso!");
    }

}
