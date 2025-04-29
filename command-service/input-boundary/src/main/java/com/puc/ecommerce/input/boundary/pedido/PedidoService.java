package com.puc.ecommerce.input.boundary.pedido;

import com.puc.ecommerce.input.boundary.pedido.dto.PedidoInput;

public interface PedidoService {

    void criarPedido(PedidoInput pedidoInput);

    void cancelarPedido(Long id);

}
