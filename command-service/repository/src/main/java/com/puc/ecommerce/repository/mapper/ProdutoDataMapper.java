package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.produto.ProdutoDatabaseOutput;
import com.puc.ecommerce.repository.produto.entities.ProdutoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoDataMapper {

    public static ProdutoEntity toEntity(ProdutoDatabaseOutput output) {
        return ProdutoEntity.builder()
                .nome(output.getNome())
                .descricao(output.getDescricao())
                .preco(output.getPreco())
                .dataHoraCriacao(LocalDateTime.now())
                .dataHoraAtualizacao(LocalDateTime.now())
                .build();
    }

    public static ProdutoEntity toEntityUpdate(ProdutoDatabaseOutput output) {
        return ProdutoEntity.builder()
                .id(output.getId())
                .nome(output.getNome())
                .descricao(output.getDescricao())
                .preco(output.getPreco())
                .dataHoraCriacao(output.getDataHoraCriacao())
                .dataHoraAtualizacao(LocalDateTime.now())
                .build();
    }

    public static ProdutoDatabaseOutput toOutput(ProdutoEntity entity) {
        return ProdutoDatabaseOutput.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .build();
    }

    public static ProdutoDatabaseOutput toFindOutput(ProdutoEntity entity) {
        return ProdutoDatabaseOutput.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .dataHoraCriacao(entity.getDataHoraCriacao())
                .build();
    }
}