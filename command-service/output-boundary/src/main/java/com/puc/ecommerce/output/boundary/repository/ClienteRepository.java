package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;

public interface ClienteRepository {

    void cadastrarCliente(ClienteOutput clienteOutput);

    void atualizarCliente(ClienteOutput clienteOutput, Long id);

    void deletarCliente(Long id) throws Exception;

    Boolean clienteExistentePorId(Long id);

    Boolean clienteExistentePorDocumento(String documento);
}
