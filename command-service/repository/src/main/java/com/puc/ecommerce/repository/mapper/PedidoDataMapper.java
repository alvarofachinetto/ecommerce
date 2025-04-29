package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.pedido.ClientePedidoOutput;
import com.puc.ecommerce.output.boundary.pedido.ItemPedidoOutput;
import com.puc.ecommerce.output.boundary.pedido.PedidoOutput;
import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;
import com.puc.ecommerce.repository.pedido.entities.ItemPedidoEntity;
import com.puc.ecommerce.repository.pedido.entities.PedidoEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoDataMapper {

    public static PedidoEntity toEntity(PedidoOutput output) {
        return PedidoEntity.builder()
                .cliente(toClientePedidoEntity(output.getCliente()))
                .itens(mapItens(output))
                .endereco(EnderecoDataMapper.toEntity(output.getEndereco()))
                .status(output.getStatus())
                .dataPedido(output.getDataPedido())
                .formaPagamento(output.getFormaPagamento())
                .valorTotal(output.getValorTotal())
                .build();
    }

    public static PedidoOutput toOutput(PedidoEntity entity) {
        return PedidoOutput.builder()
                .cliente(toClientePedidoOutput(entity.getCliente()))
                .itens(mapItensToOutput(entity))
                .endereco(EnderecoDataMapper.toOutput(entity.getEndereco()))
                .status(entity.getStatus())
                .dataPedido(entity.getDataPedido())
                .build();
    }

    private static List<ItemPedidoEntity> mapItens(PedidoOutput output) {
        return output.getItens().stream()
                .map(item -> ItemPedidoEntity.builder()
                        .produtoId(item.getProdutoId())
                        .quantidade(item.getQuantidade())
                        .precoTotalItem(item.getPrecoTotalItem())
                        .build())
                .collect(Collectors.toList());
    }

    private static List<ItemPedidoOutput> mapItensToOutput(PedidoEntity entity) {
        return entity.getItens().stream()
                .map(item -> ItemPedidoOutput.builder()
                        .produtoId(item.getProdutoId())
                        .quantidade(item.getQuantidade())
                        .precoTotalItem(item.getPrecoTotalItem())
                        .build())
                .collect(Collectors.toList());
    }

    public static ClienteEntity toClientePedidoEntity(ClientePedidoOutput clientePedidoOutput) {
        return ClienteEntity.builder()
                .id(clientePedidoOutput.getId())
                .nome(clientePedidoOutput.getNome())
                .email(clientePedidoOutput.getEmail())
                .documento(clientePedidoOutput.getDocumento())
                .telefone(clientePedidoOutput.getTelefone())
                .build();
    }

    public static ClientePedidoOutput toClientePedidoOutput(ClienteEntity entity) {
        return ClientePedidoOutput.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .documento(entity.getDocumento())
                .telefone(entity.getTelefone())
                .build();
    }
}