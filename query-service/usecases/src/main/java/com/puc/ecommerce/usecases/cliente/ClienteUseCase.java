package com.puc.ecommerce.usecases.cliente;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.output.boundary.cliente.ClienteService;
import com.puc.ecommerce.output.boundary.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteUseCase implements ClienteService {

    private ClienteRepository clienteRepository;


    @Override
    public ClienteOutput buscarclientes(Long id) {
        return clienteRepository.buscarclientes(id).orElseThrow(()->new RuntimeException("cliente não encontrado"));
    }
}