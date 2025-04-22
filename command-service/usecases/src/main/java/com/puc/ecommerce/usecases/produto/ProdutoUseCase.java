package com.puc.ecommerce.usecases.produto;

import com.puc.ecommerce.input.boundary.produto.ProdutoService;
import com.puc.ecommerce.input.boundary.produto.dto.ProdutoInput;
import com.puc.ecommerce.input.boundary.produto.dto.ProdutoUpdateInput;
import com.puc.ecommerce.output.boundary.exception.CustomException;
import com.puc.ecommerce.output.boundary.repository.EstoqueRepository;
import com.puc.ecommerce.output.boundary.repository.ProdutoRepository;
import com.puc.ecommerce.usecases.mapper.ProdutoDataMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
@AllArgsConstructor
public class ProdutoUseCase implements ProdutoService {

    private ProdutoRepository produtoRepository;

    private EstoqueRepository estoqueRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = REQUIRES_NEW)
    public void criarProduto(ProdutoInput produtoInput) {

        // Verifica se o produto já existe
        try {
            if (produtoRepository.produtoExistenteByNome(produtoInput.getNome())) {
                throw new CustomException(String.format("Produto com nome '%s já existe", produtoInput.getNome()));
            }

            //cria o estoque de produto
            estoqueRepository.criarEstoque(ProdutoDataMapper.toOutput(produtoInput), produtoInput.getQuantidadeEstoque());
        } catch (Exception e) {
            throw new CustomException("Erro ao criar produto: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = REQUIRES_NEW)
    public void atualizarProduto(Long id, ProdutoUpdateInput produtoInput) {
        try {
            // Verifica se o produto existe
            produtoRepository.buscarProdutoPorId(id).ifPresentOrElse(
                    (produto) -> {
                        // Atualiza o produto
                        try {
                            produtoRepository.atualizarProduto(ProdutoDataMapper.toUpdateOutput(
                                    produtoInput,
                                    produto.getDataHoraCriacao(),
                                    id
                            ));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }

                    },
                    () -> {
                        throw new CustomException("Produto não encontrado");
                    }
            );
        } catch (Exception e) {
            throw new CustomException("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = REQUIRES_NEW)
    public void deletarProduto(Long id) {
        try {
            if(!produtoRepository.produtoExistente(id)) {
                throw new CustomException("Produto não encontrado");
            }

            if(estoqueRepository.existeQuantidadeProdutoEstoque(id) > 0) {
                throw new CustomException("Produto não pode ser deletado, existe estoque vinculado");
            }

            //deleta estoque
            estoqueRepository.removerProdutoEstoque(id);
            produtoRepository.deletarProduto(id);
        } catch (Exception e) {
            throw new CustomException("Erro ao deletar produto: " + e.getMessage(), e);
        }
    }
}
