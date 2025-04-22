package com.puc.ecommerce.input.boundary.produto;

import com.puc.ecommerce.input.boundary.produto.dto.ProdutoInput;
import com.puc.ecommerce.input.boundary.produto.dto.ProdutoUpdateInput;

public interface ProdutoService {
    void criarProduto(ProdutoInput produtoInput);

    void atualizarProduto(Long id, ProdutoUpdateInput produtoInput);

    void deletarProduto(Long id);
}
