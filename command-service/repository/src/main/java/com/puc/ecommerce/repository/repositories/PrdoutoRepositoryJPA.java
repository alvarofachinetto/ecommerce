package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.produto.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrdoutoRepositoryJPA extends JpaRepository<ProdutoEntity, Long> {
    // Custom query methods can be defined here if needed
}
