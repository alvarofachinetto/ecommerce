package com.puc.ecommerce.input.boundary.produto;

import com.puc.ecommerce.input.boundary.produto.dto.ProdutoInput;

public interface ProdutoService {
    void criarProduto(ProdutoInput produtoInput);

    void atualizarProduto(Long id, ProdutoInput produtoInput) throws Exception;

    void deletarProduto(Long id) throws Exception;
}
