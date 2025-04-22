package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.produto.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositoryJPA extends JpaRepository<ProdutoEntity, Long> {
    Boolean existsByNome(String nome);
}
