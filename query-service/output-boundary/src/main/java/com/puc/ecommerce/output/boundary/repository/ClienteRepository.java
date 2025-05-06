package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;

import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteOutput> buscarclientes(Long id);
}
