package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.invetario.entities.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepositoryJPA extends JpaRepository<EstoqueEntity, Long> {

    Optional<EstoqueEntity> findByProdutoId(Long produtoId);

    //existe um estoque para o produto
    @Query("SELECT e.quantidade FROM EstoqueEntity e WHERE e.produto.id = :produtoId")
    Integer findQuantidadeByProdutoId(Long produtoId);

    @Modifying
    @Query("UPDATE EstoqueEntity e SET e.quantidade = :quantidade WHERE e.id = :estoqueId")
    void updateQuantidade(@Param("estoqueId") Long estoqueId, @Param("quantidade") Integer quantidade);

    @Modifying
    @Query("DELETE FROM EstoqueEntity e WHERE e.produto.id = :produtoId")
    void deleteByProdutoId(@Param("produtoId") Long produtoId);
}
