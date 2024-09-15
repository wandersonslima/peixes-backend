package com.galatico.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity()
@Table(name = "tb_debitos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitosEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "data_debito", nullable = false)
    private LocalDate data_debito;

    @Column(name = "valor_total", nullable = false)
    private Float valor_total;

    @Column(name = "valor_abatido", nullable = false)
    private Float valor_abatido;

    @Column(name = "valor_final", nullable = false)
    private Float valor_final;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate data_criacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntity;

    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private PedidosEntity pedidosEntity;


}
