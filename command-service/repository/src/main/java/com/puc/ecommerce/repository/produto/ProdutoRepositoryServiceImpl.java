package com.puc.ecommerce.repository.produto;

import com.puc.ecommerce.output.boundary.exception.DatabaseOperationException;
import com.puc.ecommerce.output.boundary.produto.ProdutoDatabaseOutput;
import com.puc.ecommerce.output.boundary.repository.ProdutoRepository;
import com.puc.ecommerce.repository.mapper.ProdutoDataMapper;
import com.puc.ecommerce.repository.repositories.ProdutoRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProdutoRepositoryServiceImpl implements ProdutoRepository {

    private ProdutoRepositoryJPA produtoRepositoryJPA;

    @Override
    public ProdutoDatabaseOutput criarProduto(ProdutoDatabaseOutput produto) {
        try {
            return ProdutoDataMapper.toOutput(
                    produtoRepositoryJPA.save(ProdutoDataMapper.toEntity(produto))
            );
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseOperationException("Criar produto " + e.getMessage(), e);
        } catch (JpaSystemException e) {
            throw new DatabaseOperationException("acessar banco de dados " + e.getMessage(), e);
        }
    }

    @Override
    public Boolean produtoExistente(Long id) {
        return produtoRepositoryJPA.existsById(id);
    }

    @Override
    public Boolean produtoExistenteByNome(String nome) {
        return produtoRepositoryJPA.existsByNome(nome);
    }

    @Override
    public Optional<ProdutoDatabaseOutput> buscarProdutoPorId(Long id) {
        return produtoRepositoryJPA.findById(id)
                .map(ProdutoDataMapper::toFindOutput);
    }

    @Override
    @Transactional
    public void atualizarProduto(ProdutoDatabaseOutput produto) {
        try {
            produtoRepositoryJPA.save(ProdutoDataMapper.toEntityUpdate(produto));
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseOperationException("atualizar produto " + e.getMessage(), e);
        } catch (JpaSystemException e) {
            throw new DatabaseOperationException("acessar banco de dados " + e.getMessage(), e);
        }
    }

    @Override
    public void deletarProduto(Long id) throws Exception {
        produtoRepositoryJPA.deleteById(id);
    }
}