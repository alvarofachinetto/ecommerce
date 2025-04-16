package com.puc.ecommerce.usecases.cliente;

import com.puc.ecommerce.input.boundary.cliente.ClienteService;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteInput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteUpdateInput;
import com.puc.ecommerce.output.boundary.repository.ClienteRepository;
import com.puc.ecommerce.usecases.mapper.ClienteDataMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteUseCase implements ClienteService {

    private ClienteRepository clienteRepository;

    @Override
    public void cadastrarCliente(ClienteInput clienteInput) throws Exception {
        clienteRepository.cadastrarCliente(ClienteDataMapper.toOutput(clienteInput));
    }

    @Override
    public void atualizarCliente(ClienteUpdateInput clienteInput, Long id) throws Exception {
        clienteRepository.atualizarCliente(ClienteDataMapper.toUpdateOutput(clienteInput), id);
    }

    @Override
    public void deletarCliente(Long id) throws Exception {
        clienteRepository.deletarCliente(id);
    }
}
