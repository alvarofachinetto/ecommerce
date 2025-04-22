package com.puc.ecommerce.usecases.estoque;

import com.puc.ecommerce.input.boundary.inventario.EstoqueService;
import com.puc.ecommerce.output.boundary.exception.CustomException;
import com.puc.ecommerce.output.boundary.repository.EstoqueRepository;
import com.puc.ecommerce.output.boundary.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
@AllArgsConstructor
public class EstoqueUsecase implements EstoqueService {

    private ProdutoRepository produtoRepository;

    private EstoqueRepository estoqueRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = REQUIRES_NEW)
    public void adicionarProdutoEstoque(Long estoqueId, Integer quantidade) {
        try {
            estoqueRepository.buscarProdutoEstoque(estoqueId).ifPresentOrElse(
                    estoqueProduto -> {
                        try {
                            estoqueRepository.atualizarProdutoEstoqueQuantidade(
                                    estoqueProduto.getId(),
                                    estoqueProduto.incrementarQuantidade(quantidade)
                            );
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    },
                    () -> {
                        throw new RuntimeException("Estoque não encontrado");
                    }
            );
        }catch (Exception e){
            throw new CustomException("Erro ao adicionar produto ao estoque: " + e.getMessage(), e);
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class, propagation = REQUIRES_NEW)
    public void removerProdutoEstoque(Long estoqueId, Integer quantidade) {
        try{
            estoqueRepository.buscarProdutoEstoque(estoqueId).ifPresentOrElse(
                    estoqueProduto -> {
                        try {
                            if (!estoqueProduto.quantidadeSuficiente(quantidade)) {
                                throw new CustomException("Quantidade insuficiente no estoque");
                            }
                            estoqueRepository.atualizarProdutoEstoqueQuantidade(
                                    estoqueProduto.getId(),
                                    estoqueProduto.decrementarQuantidade(quantidade)
                            );
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    },
                    () -> {
                        throw new RuntimeException("Estoque não encontrado");
                    }
            );
        }catch (Exception e){
            throw new CustomException("Erro ao remover produto do estoque: " + e.getMessage(), e);
        }
    }
}
