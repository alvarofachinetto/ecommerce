package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.produto.ProdutoByIdOutput;
import com.puc.ecommerce.repository.produto.entities.ProdutoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoDataMapper {

    public static ProdutoEntity toEntity(ProdutoByIdOutput output) {
        return ProdutoEntity.builder()
                .nome(output.getNome())
                .descricao(output.getDescricao())
                .preco(output.getPreco())
                .build();
    }

    public static ProdutoEntity toEntityUpdate(ProdutoByIdOutput output) {
        return ProdutoEntity.builder()
                .nome(output.getNome())
                .descricao(output.getDescricao())
                .preco(output.getPreco())
                .build();
    }

    public static ProdutoByIdOutput toOutput(ProdutoEntity entity) {
        return ProdutoByIdOutput.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .build();
    }

}