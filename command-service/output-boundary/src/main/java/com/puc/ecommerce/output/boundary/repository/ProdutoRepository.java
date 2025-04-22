package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.produto.ProdutoDatabaseOutput;
import com.puc.ecommerce.output.boundary.produto.ProdutoOutput;

import java.util.Optional;

public interface ProdutoRepository {
    ProdutoDatabaseOutput criarProduto(ProdutoDatabaseOutput produtoOutput);

    void atualizarProduto(ProdutoDatabaseOutput produtoOutput) throws Exception;

    void deletarProduto(Long id) throws Exception;

    Boolean produtoExistente(Long id);

    Boolean produtoExistenteByNome(String nome);

    Optional<ProdutoDatabaseOutput> buscarProdutoPorId(Long id);
}
