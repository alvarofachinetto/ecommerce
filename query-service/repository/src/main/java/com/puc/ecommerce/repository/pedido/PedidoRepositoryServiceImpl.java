package com.puc.ecommerce.repository.pedido;

import com.puc.ecommerce.output.boundary.pedido.PedidoOutput;
import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;
import com.puc.ecommerce.output.boundary.repository.PedidoRepository;
import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;
import com.puc.ecommerce.repository.mapper.PedidoDataMapper;
import com.puc.ecommerce.repository.repositories.PedidoRepositoryJpa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.puc.ecommerce.repository.mapper.PedidoDataMapper.toListPedidoCliente;
import static com.puc.ecommerce.repository.mapper.PedidoDataMapper.toOutput;
import static com.puc.ecommerce.repository.mapper.ProdutoDataMapper.toOutputDTO;
import static com.puc.ecommerce.repository.mapper.ProdutoDataMapper.toOutputDTOList;

@Component
@AllArgsConstructor
public class PedidoRepositoryServiceImpl implements PedidoRepository {

    private PedidoRepositoryJpa pedidoRepositoryJpa;


    @Override
    public List<PedidoOutput> buscarPedidoPorCliente(Long idCliente) {
        return toListPedidoCliente(pedidoRepositoryJpa.findByClienteId(idCliente));
    }

    @Override
    public Optional<PedidoOutput> buscarPedidoPorId(Long id) {
        return Optional.of(toOutput(pedidoRepositoryJpa.findById(id).get()));
    }
}