package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;

public interface ClienteRepository {

    void cadastrarCliente(ClienteOutput clienteOutput) throws Exception;

    void atualizarCliente(ClienteOutput clienteOutput, Long id) throws Exception;

    void deletarCliente(Long id) throws Exception;
}
