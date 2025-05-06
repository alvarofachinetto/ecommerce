package com.puc.ecommerce.usecases.cliente;

import com.puc.ecommerce.output.boundary.pedido.PedidoOutput;
import com.puc.ecommerce.output.boundary.pedido.PedidoService;
import com.puc.ecommerce.output.boundary.produtos.ProdutoService;
import com.puc.ecommerce.output.boundary.repository.ClienteRepository;
import com.puc.ecommerce.output.boundary.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class PedidoUseCase implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public List<PedidoOutput> buscarPedidoPorCliente(Long idCliente) {
        return pedidoRepository.buscarPedidoPorCliente(idCliente);
    }

    @Override
    public PedidoOutput buscarPedidoPorId(Long id) {
        try {
            return pedidoRepository.buscarPedidoPorId(id)
                    .orElseThrow(() -> new Exception("Produto não encontrado com ID: "));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
