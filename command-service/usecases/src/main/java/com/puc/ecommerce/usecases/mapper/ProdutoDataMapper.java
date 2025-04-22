package com.puc.ecommerce.usecases.mapper;

import com.puc.ecommerce.input.boundary.produto.dto.ProdutoInput;
import com.puc.ecommerce.input.boundary.produto.dto.ProdutoUpdateInput;
import com.puc.ecommerce.output.boundary.produto.ProdutoDatabaseOutput;

import java.time.LocalDateTime;

public class ProdutoDataMapper {

    public static ProdutoDatabaseOutput toOutput(ProdutoInput produtoInput) {
        return ProdutoDatabaseOutput.builder()
                .nome(produtoInput.getNome())
                .descricao(produtoInput.getDescricao())
                .preco(produtoInput.getPreco())
                .build();
    }

    public static ProdutoDatabaseOutput toUpdateOutput(ProdutoUpdateInput produtoInput, LocalDateTime dataHoraCriacao, Long id) {
        return ProdutoDatabaseOutput.builder()
                .id(id)
                .nome(produtoInput.getNome())
                .descricao(produtoInput.getDescricao())
                .preco(produtoInput.getPreco())
                .dataHoraCriacao(dataHoraCriacao)
                .dataHoraAtualizacao(LocalDateTime.now())
                .build();
    }

}
