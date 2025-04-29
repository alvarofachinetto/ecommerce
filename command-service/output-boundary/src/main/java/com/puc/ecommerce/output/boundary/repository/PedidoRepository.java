package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.pedido.PedidoOutput;

public interface PedidoRepository {

    PedidoOutput confirmarPedido(PedidoOutput pedidoOutput);

    void cancelarPedido(Long id);
}
