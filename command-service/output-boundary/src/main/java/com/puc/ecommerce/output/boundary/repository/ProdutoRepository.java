package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.produto.ProdutoByIdOutput;

public interface ProdutoRepository {
    void criarProduto(ProdutoByIdOutput produtoOutput);

    void atualizarProduto(Long id, ProdutoByIdOutput produtoOutput) throws Exception;

    void deletarProduto(Long id) throws Exception;

    Boolean produtoExistente(Long id);

    ProdutoByIdOutput buscarProdutoPorId(Long id);
}
