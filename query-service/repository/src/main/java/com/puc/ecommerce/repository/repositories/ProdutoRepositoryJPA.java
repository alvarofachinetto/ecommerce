package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.produto.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepositoryJPA extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findByNome(String nome);

}
