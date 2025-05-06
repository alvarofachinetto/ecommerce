package com.puc.ecommerce.output.boundary.produtos;




import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProdutoService {
    List<ProdutoOutput> buscarProdutosPorNome(String nome);
    ProdutoOutput buscarProdutoPorId(Long id);
}

