package com.puc.ecommerce.usecases.mapper;

import com.puc.ecommerce.input.boundary.pedido.dto.PedidoInput;
import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.output.boundary.pedido.ClientePedidoOutput;
import com.puc.ecommerce.output.boundary.pedido.ItemPedidoOutput;
import com.puc.ecommerce.output.boundary.pedido.PedidoOutput;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.puc.ecommerce.output.boundary.pedido.StatusPedido.SOLICITADO;

public class PedidoDataMapper {

    public static PedidoOutput toOutput(PedidoInput input, ClienteOutput cliente) {
        return PedidoOutput.builder()
                .cliente(toClientePedidoOutput(cliente))
                .itens(mapItems(input))
                .formaPagamento(input.getFormaPagamento().getTipoPagamento())
                .endereco(cliente.getEndereco())
                .valorTotal(input.getItens().stream()
                        .map(item -> item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .status(SOLICITADO)
                .dataPedido(LocalDateTime.now())
                .build();
    }

    private static List<ItemPedidoOutput> mapItems(PedidoInput input) {
        return input.getItens().stream()
                .map(item -> ItemPedidoOutput.builder()
                        .produtoId(item.getProdutoId())
                        .quantidade(item.getQuantidade())
                        .precoTotalItem(item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade())))
                        .build())
                .collect(Collectors.toList());
    }

    public static ClientePedidoOutput toClientePedidoOutput(ClienteOutput clienteOutput) {
        return ClientePedidoOutput.builder()
                .id(clienteOutput.getId())
                .build();
    }

}