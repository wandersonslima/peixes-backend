package com.galatico.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientesDto {

    private Integer id;

    private String nome;

    private String endereco;

    private String telefone;
}
