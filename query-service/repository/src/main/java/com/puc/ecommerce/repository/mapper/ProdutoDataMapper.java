package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;
import com.puc.ecommerce.repository.produto.entities.ProdutoEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProdutoDataMapper {

    public static ProdutoOutput toOutputDTO(ProdutoEntity entity) {
        if (entity == null) return null;

        return ProdutoOutput.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .dataHoraCriacao(entity.getDataHoraCriacao())
                .dataHoraAtualizacao(entity.getDataHoraAtualizacao())
                .build();
    }

    public static List<ProdutoOutput> toOutputDTOList(List<ProdutoEntity> entities) {
        return entities.stream()
                .map(ProdutoDataMapper::toOutputDTO)
                .collect(Collectors.toList());
    }
}
