package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.inventario.EstoqueOutput;
import com.puc.ecommerce.output.boundary.produto.ProdutoDatabaseOutput;
import com.puc.ecommerce.repository.invetario.entities.EstoqueEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EstoqueDataMapper {

    public static EstoqueOutput toOutput(EstoqueEntity entity) {
        EstoqueOutput output = new EstoqueOutput();
        output.setId(entity.getId());
        output.setProduto(ProdutoDataMapper.toOutput(entity.getProduto()));
        output.setQuantidade(entity.getQuantidade());
        return output;
    }

    public static EstoqueEntity toEntity(ProdutoDatabaseOutput produto, Integer quantidade) {

        return EstoqueEntity.builder()
                .quantidade(quantidade)
                .produto(ProdutoDataMapper.toEntity(produto))
                .dataHoraAtualizacao(LocalDateTime.now())
                .dataHoraCriacao(LocalDateTime.now())
                .version(0L)
                .build();
    }
}
