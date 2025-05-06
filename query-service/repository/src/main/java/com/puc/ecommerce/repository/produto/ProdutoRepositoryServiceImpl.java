package com.puc.ecommerce.repository.produto;

import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;
import com.puc.ecommerce.output.boundary.repository.ProdutoRepository;
import com.puc.ecommerce.repository.produto.entities.ProdutoEntity;
import com.puc.ecommerce.repository.repositories.ProdutoRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.puc.ecommerce.repository.mapper.ProdutoDataMapper.toOutputDTO;
import static com.puc.ecommerce.repository.mapper.ProdutoDataMapper.toOutputDTOList;

@Component
@AllArgsConstructor
public class ProdutoRepositoryServiceImpl implements ProdutoRepository {

    private final ProdutoRepositoryJPA produtoRepositoryJPA;

    @Override
    public List<ProdutoOutput> buscarProdutosPorNome(String nome) {
        return toOutputDTOList(produtoRepositoryJPA.findByNome(nome));
    }

    @Override
    public Optional<ProdutoOutput> buscarProdutoPorId(Long id) {
        return Optional.of(toOutputDTO(produtoRepositoryJPA.findById(id).get()));
    }
}

