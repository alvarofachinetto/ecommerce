package com.puc.ecommerce.output.boundary.produtos;




import java.util.List;

public interface ProdutoService {
    List<ProdutoOutput> buscarProdutosPorNome(String nome);
    ProdutoOutput buscarProdutoPorId(Long id);
}

