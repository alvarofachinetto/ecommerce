package com.puc.ecommerce.input.boundary.pedido.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemPedidoInput {
    private Long produtoId;
    private Integer quantidade;
    private BigDecimal precoUnitario;
}
