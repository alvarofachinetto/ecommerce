package com.puc.ecommerce.output.boundary.pedido;

import com.puc.ecommerce.output.boundary.cliente.EnderecoOutput;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PedidoOutput {
    private ClientePedidoOutput cliente;
    private List<ItemPedidoOutput> itens;
    private String formaPagamento;
    private BigDecimal valorTotal;
    private EnderecoOutput endereco;
    private LocalDateTime dataPedido;
    private StatusPedido status;
}