package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;

import java.util.Optional;

public interface ClienteRepository {

    ClienteOutput cadastrarCliente(ClienteOutput clienteOutput);

    ClienteOutput atualizarCliente(ClienteOutput clienteOutput, Long id);

    void deletarCliente(Long id) throws Exception;

    Boolean clienteExistentePorId(Long id);

    Boolean clienteExistentePorDocumento(String documento);

    Optional<ClienteOutput> buscarClientePorDocumento(String documento);
}
