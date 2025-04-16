package com.puc.ecommerce.repository.produto;

import com.puc.ecommerce.output.boundary.produto.ProdutoByIdOutput;
import com.puc.ecommerce.output.boundary.repository.ProdutoRepository;
import com.puc.ecommerce.repository.mapper.ProdutoDataMapper;
import com.puc.ecommerce.repository.repositories.PrdoutoRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class ProdutoRepositoryServiceImpl implements ProdutoRepository {

    private PrdoutoRepositoryJPA produtoRepositoryJPA;

    @Override
    @Transactional
    public void criarProduto(ProdutoByIdOutput produto) {
        produtoRepositoryJPA.save(ProdutoDataMapper.toEntity(produto));
    }

    public Boolean produtoExistente(Long id) {
        return produtoRepositoryJPA.existsById(id);
    }

    public ProdutoByIdOutput buscarProdutoPorId(Long id) {
        return produtoRepositoryJPA.findById(id)
                .map(ProdutoDataMapper::toOutput)
                .orElse(null);
    }

    @Override
    @Transactional
    public void atualizarProduto(Long id, ProdutoByIdOutput produto) throws Exception {
        produtoRepositoryJPA.save(ProdutoDataMapper.toEntityUpdate(produto));
    }

    @Override
    public void deletarProduto(Long id) throws Exception {
        produtoRepositoryJPA.deleteById(id);
    }
}