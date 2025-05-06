package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository {
    List<ProdutoOutput> buscarProdutosPorNome(String nome);
    Optional<ProdutoOutput> buscarProdutoPorId(Long id);
}
