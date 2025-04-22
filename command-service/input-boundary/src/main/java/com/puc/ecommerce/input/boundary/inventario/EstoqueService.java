package com.puc.ecommerce.input.boundary.inventario;

import java.util.Optional;

public interface EstoqueService {

    void adicionarProdutoEstoque(Long produtoId, Integer quantidade);

    void removerProdutoEstoque(Long produtoId, Integer quantidade);

}
