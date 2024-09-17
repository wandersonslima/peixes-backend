package com.galatico.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutosDto {

    private Integer id;

    private String nome;

    private String descricao;

    private Float preco;

    private LocalDate data_cadastro;
}
