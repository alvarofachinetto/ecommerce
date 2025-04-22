package com.puc.ecommerce.input.boundary.cliente;

import com.puc.ecommerce.input.boundary.cliente.dto.ClienteInput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteUpdateInput;

public interface ClienteService {
    void cadastrarCliente(ClienteInput clienteInput);

    void atualizarCliente(ClienteUpdateInput clienteInput, Long id);

    void deletarCliente(Long id);
}
