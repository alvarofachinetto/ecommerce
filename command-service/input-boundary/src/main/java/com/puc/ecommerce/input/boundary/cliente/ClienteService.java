package com.puc.ecommerce.input.boundary.cliente;

import com.puc.ecommerce.input.boundary.cliente.dto.ClienteInput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteUpdateInput;

public interface ClienteService {
    void cadastrarCliente(ClienteInput clienteInput) throws Exception;

    void atualizarCliente(ClienteUpdateInput clienteInput, Long id) throws Exception;

    void deletarCliente(Long id) throws Exception;
}
