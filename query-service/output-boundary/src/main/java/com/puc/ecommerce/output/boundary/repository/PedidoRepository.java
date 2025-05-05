package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.pedido.PedidoOutput;
import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository {
    List<PedidoOutput> buscarPedidoPorNome(String nome);
    Optional<PedidoOutput> buscarPedidoPorId(Long id);
}
