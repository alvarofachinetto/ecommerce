package com.puc.ecommerce.usecases.cliente;

import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;
import com.puc.ecommerce.output.boundary.produtos.ProdutoService;
import com.puc.ecommerce.output.boundary.repository.ProdutoRepository;
import com.puc.ecommerce.repository.produto.entities.ProdutoEntity;
import com.puc.ecommerce.repository.repositories.ProdutoRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.puc.ecommerce.repository.mapper.ProdutoDataMapper.toOutputDTO;
import static com.puc.ecommerce.repository.mapper.ProdutoDataMapper.toOutputDTOList;

@AllArgsConstructor
@Service
public class ProdutoUseCase implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public List<ProdutoOutput> buscarProdutosPorNome(String nome) {
        return produtoRepository.buscarProdutosPorNome(nome);
    }

    @Override
    public ProdutoOutput buscarProdutoPorId(Long id) {
        try {
            return produtoRepository.buscarProdutoPorId(id)
                    .orElseThrow(() -> new Exception("Produto não encontrado com ID: "));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}


