package com.puc.ecommerce.output.boundary.pedido;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ItemPedidoOutput {
    private Long produtoId;
    private Integer quantidade;
    private BigDecimal precoTotalItem;
}