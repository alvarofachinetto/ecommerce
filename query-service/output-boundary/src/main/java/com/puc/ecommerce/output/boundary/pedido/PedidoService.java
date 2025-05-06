package com.puc.ecommerce.output.boundary.pedido;

import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;

import java.util.List;
import java.util.UUID;

public interface PedidoService {
    List<PedidoOutput> buscarPedidoPorCliente(Long idCliente);
    PedidoOutput buscarPedidoPorId(Long id);
}

