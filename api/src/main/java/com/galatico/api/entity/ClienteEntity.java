package com.galatico.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "tb_clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    @NotEmpty(message = "Campo nome é obrigatório!")
    private String nome;

    @Column(name = "endereco", nullable = false)
    @NotBlank
    private String endereco;

    @Column(name = "telefone", nullable = false)
    private String telefone;


}
