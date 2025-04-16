package com.puc.ecommerce.usecases.mapper;

import com.puc.ecommerce.input.boundary.produto.dto.ProdutoInput;
import com.puc.ecommerce.output.boundary.produto.ProdutoByIdOutput;

public class ProdutoDataMapper {

    public static ProdutoByIdOutput toOutput(ProdutoInput produtoInput) {
        return ProdutoByIdOutput.builder()
                .nome(produtoInput.getNome())
                .descricao(produtoInput.getDescricao())
                .preco(produtoInput.getPreco())
                .build();
    }

}
