package com.puc.ecommerce.usecases.pedido;

import com.puc.ecommerce.input.boundary.pedido.PedidoService;
import com.puc.ecommerce.input.boundary.pedido.dto.PedidoInput;
import com.puc.ecommerce.output.boundary.exception.CustomException;
import com.puc.ecommerce.output.boundary.repository.ClienteRepository;
import com.puc.ecommerce.output.boundary.repository.FormaPagamentoRepository;
import com.puc.ecommerce.output.boundary.repository.PedidoRepository;
import com.puc.ecommerce.usecases.estoque.EstoqueUsecase;
import com.puc.ecommerce.usecases.mapper.PedidoDataMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class PedidoUsecase implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final EstoqueUsecase estoqueUsecase; // Injecting another usecase
    private final FormaPagamentoRepository formaPagamentoRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void criarPedido(PedidoInput pedidoInput) {
        try{
            // Verifica se a forma de pagamento existe
            var cliente = clienteRepository.buscarClientePorDocumento(pedidoInput.getDocumneto()).orElseThrow(
                    () -> new CustomException("Cliente não encontrado")
            );

            if (!formaPagamentoRepository.existeFormaPagamento(pedidoInput.getFormaPagamento().getTipoPagamento())) {
                throw new CustomException("Forma de pagamento não encontrada");
            }

            var pedidoOutput = PedidoDataMapper.toOutput(pedidoInput, cliente);

            //confirma o pedido
            pedidoRepository.confirmarPedido(pedidoOutput);

            //remove os itens do pedido no estoque
//        pedidoInput.getItens().forEach(item -> {
//            estoqueUsecase.removerProdutoEstoque(item.getProdutoId(), item.getQuantidade());
//        });
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cancelarPedido(Long id) {

    }
}