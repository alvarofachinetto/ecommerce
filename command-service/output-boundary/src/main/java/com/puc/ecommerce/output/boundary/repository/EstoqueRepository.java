package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.inventario.EstoqueOutput;
import com.puc.ecommerce.output.boundary.produto.ProdutoDatabaseOutput;

import java.util.Optional;

public interface EstoqueRepository {
    void criarEstoque(ProdutoDatabaseOutput produto, Integer quantidade) ;

    void atualizarProdutoEstoqueQuantidade(Long produtoId, Integer quantidade) ;

    Integer existeQuantidadeProdutoEstoque(Long produtoId) ;

    Optional<EstoqueOutput> buscarProdutoEstoque(Long id) ;

    void removerProdutoEstoque(Long produtoId);
}
