package com.puc.ecommerce.repository.pedido;

import com.puc.ecommerce.output.boundary.pedido.PedidoOutput;
import com.puc.ecommerce.output.boundary.repository.PedidoRepository;
import com.puc.ecommerce.repository.mapper.PedidoDataMapper;
import com.puc.ecommerce.repository.repositories.PedidoRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PedidoRepositoryServiceImpl implements PedidoRepository {

    private PedidoRepositoryJpa pedidoRepositoryJpa;

    @Override
    public PedidoOutput confirmarPedido(PedidoOutput pedidoOutput) {
        var pedidoEntity = PedidoDataMapper.toEntity(pedidoOutput);
        return PedidoDataMapper.toOutput(pedidoRepositoryJpa.save(pedidoEntity));
    }

    @Override
    public void cancelarPedido(Long id) {
        // Implementação do método para cancelar o pedido
    }
}
