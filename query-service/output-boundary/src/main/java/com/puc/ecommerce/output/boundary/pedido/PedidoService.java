package com.puc.ecommerce.output.boundary.pedido;

import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;

import java.util.List;

public interface PedidoService {
    List<PedidoOutput> buscarPedidoPorNome(String nome);
    PedidoOutput buscarPedidoPorId(Long id);
}

