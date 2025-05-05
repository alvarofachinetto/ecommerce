package com.puc.ecommerce.input.boundary.cliente;

import com.puc.ecommerce.input.boundary.cliente.dto.ClienteInput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteUpdateInput;

import java.util.UUID;

public interface ClienteService {
    void cadastrarCliente(ClienteInput clienteInput);

    void atualizarCliente(ClienteUpdateInput clienteInput, UUID keycloakId);

    void deletarCliente(UUID keycloakId);
}
