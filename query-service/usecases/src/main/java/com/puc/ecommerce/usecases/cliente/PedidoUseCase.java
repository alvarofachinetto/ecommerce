package com.puc.ecommerce.usecases.cliente;

import com.puc.ecommerce.output.boundary.pedido.PedidoOutput;
import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;
import com.puc.ecommerce.output.boundary.produtos.ProdutoService;
import com.puc.ecommerce.output.boundary.repository.PedidoRepository;
import com.puc.ecommerce.output.boundary.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PedidoUseCase implements ProdutoService {

    private final PedidoRepository pedidoRepository;

    @Override
    public List<PedidoRepository> buscarPedidoPorNome(String nome) {
        return pedidoRepository.buscarPedidoPorNome(nome);
    }

    @Override
    public PedidoOutput buscarPedidoPorid(Long id) {
        try {
            return pedidoRepository.buscarPedidoPorId(id)
                    .orElseThrow(() -> new Exception("Produto não encontrado com ID: "));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
