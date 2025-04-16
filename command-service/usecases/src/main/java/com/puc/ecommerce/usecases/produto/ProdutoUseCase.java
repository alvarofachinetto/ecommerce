package com.puc.ecommerce.usecases.produto;

import com.puc.ecommerce.input.boundary.produto.ProdutoService;
import com.puc.ecommerce.input.boundary.produto.dto.ProdutoInput;
import com.puc.ecommerce.output.boundary.repository.ProdutoRepository;
import com.puc.ecommerce.usecases.mapper.ProdutoDataMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoUseCase implements ProdutoService {

    private ProdutoRepository produtoRepository;

    @Override
    public void criarProduto(ProdutoInput produtoInput) {
//        produtoRepository.buscarProdutoPorId(produtoInput.getId()); //dado unico de produto?
        produtoRepository.criarProduto(ProdutoDataMapper.toOutput(produtoInput));
    }

    @Override
    public void atualizarProduto(Long id, ProdutoInput produtoInput) throws Exception {
        // Verifica se o produto existe
        if (!produtoRepository.produtoExistente(id)) {
            throw new Exception("Produto não encontrado");
        }
        produtoRepository.atualizarProduto(id, ProdutoDataMapper.toOutput(produtoInput));
    }

    @Override
    public void deletarProduto(Long id) throws Exception {
        if(produtoRepository.produtoExistente(id)){
            throw new Exception("Produto não encontrado");
        }
        produtoRepository.deletarProduto(id);
    }
}
