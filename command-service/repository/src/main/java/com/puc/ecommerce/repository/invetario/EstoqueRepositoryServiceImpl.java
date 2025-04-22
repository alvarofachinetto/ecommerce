package com.puc.ecommerce.repository.invetario;

import com.puc.ecommerce.output.boundary.inventario.EstoqueOutput;
import com.puc.ecommerce.output.boundary.produto.ProdutoDatabaseOutput;
import com.puc.ecommerce.output.boundary.repository.EstoqueRepository;
import com.puc.ecommerce.repository.mapper.EstoqueDataMapper;
import com.puc.ecommerce.repository.repositories.EstoqueRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EstoqueRepositoryServiceImpl implements EstoqueRepository {

    private EstoqueRepositoryJPA estoqueRepositoryJPA;

    @Override
    public void criarEstoque(ProdutoDatabaseOutput produto, Integer quantidade) {
        estoqueRepositoryJPA.save(EstoqueDataMapper.toEntity(produto, quantidade));
    }

    @Override
    public void atualizarProdutoEstoqueQuantidade(Long estoqueId, Integer quantidade) {
        // Implementação do método para adicionar produto ao estoque
        estoqueRepositoryJPA.updateQuantidade(estoqueId, quantidade);
    }

    @Override
    public Integer existeQuantidadeProdutoEstoque(Long produtoId) {
        return estoqueRepositoryJPA.findQuantidadeByProdutoId(produtoId);
    }

    @Override
    public Optional<EstoqueOutput> buscarProdutoEstoque(Long id) {
        return estoqueRepositoryJPA.findById(id).map(EstoqueDataMapper::toOutput);
    }

    @Override
    public void removerProdutoEstoque(Long produtoId) {
        estoqueRepositoryJPA.deleteByProdutoId(produtoId);
    }
}
