package com.galatico.api.controllers;

import com.galatico.api.entity.ClienteEntity;
import com.galatico.api.repositories.ClienteRepository;
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

    /*
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ClienteEntity clienteEntity){
        boolean exists = clienteRepository.existsByNome(clienteEntity.getNome());
        if (!exists){
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteEntity));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Cliente já cadastrado !");
    }*/
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
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteEntityOptional.get());
    }

    /*@GetMapping("/nome/{nome}")
    public ResponseEntity<Object> findByNome(@PathVariable(value = "nome") String nome)
    {
        Optional<Object> clienteEntityOptional = clienteService.findByNome(nome);
        if(!clienteEntityOptional.isPresent())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteEntityOptional.get());
    }
    */
}
