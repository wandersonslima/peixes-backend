package com.galatico.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "clienteEntity", fetch = FetchType.LAZY)
    private Set<DebitosEntity> debitos = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "clienteEntity", fetch = FetchType.LAZY)
    private Set<PedidosEntity> pedidos = new HashSet<>();

}
