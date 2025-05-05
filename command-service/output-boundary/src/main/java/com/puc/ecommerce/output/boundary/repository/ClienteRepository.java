package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {

    ClienteOutput cadastrarCliente(ClienteOutput clienteOutput);

    ClienteOutput atualizarCliente(ClienteOutput clienteOutput, UUID keycloakId);

    void deletarCliente(UUID KeycloakId) throws Exception;

    Boolean clienteExistentePorKeycloakId(UUID keycloakId);

    Optional<ClienteOutput> buscarClientePorKeycloakId(UUID keycloakId);
}
