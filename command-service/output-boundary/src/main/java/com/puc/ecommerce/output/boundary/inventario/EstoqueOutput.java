package com.puc.ecommerce.output.boundary.inventario;

import com.puc.ecommerce.output.boundary.produto.ProdutoDatabaseOutput;
import lombok.Data;

@Data
public class EstoqueOutput {
    private Long id;
    private ProdutoDatabaseOutput produto;
    private Integer quantidade;

    public Boolean quantidadeSuficiente(Integer quantidade) {
        return this.quantidade >= quantidade;
    }

    public Integer decrementarQuantidade(Integer quantidade) {
        return this.quantidade -= quantidade;
    }

    public Integer incrementarQuantidade(Integer quantidade) {
        return this.quantidade += quantidade;
    }

}
