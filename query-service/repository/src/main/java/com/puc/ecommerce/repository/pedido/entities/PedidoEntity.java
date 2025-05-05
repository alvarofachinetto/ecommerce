package com.puc.ecommerce.repository.pedido.entities;

import com.puc.ecommerce.output.boundary.pedido.StatusPedido;
import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;
import com.puc.ecommerce.repository.cliente.entities.EnderecoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<ItemPedidoEntity> itens;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @Embedded
    private EnderecoEntity endereco;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    @Column(name = "forma_pagamento")
    private String formaPagamento;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;
}