package com.galatico.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "tb_pedidos_tb_produtos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidosProdutosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "preco_unitario")
    private Float preco_unitario;

    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private PedidosEntity pedidosEntity;

    @ManyToOne
    @JoinColumn(name = "produtos_id")
    private ProdutosEntity produtosEntity;

}
