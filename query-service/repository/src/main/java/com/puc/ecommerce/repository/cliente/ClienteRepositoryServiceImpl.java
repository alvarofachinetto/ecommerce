package com.puc.ecommerce.repository.cliente;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.output.boundary.repository.ClienteRepository;
import com.puc.ecommerce.repository.repositories.ClienteRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.puc.ecommerce.repository.mapper.ClienteDataMapper.toOutput;

@Component
@AllArgsConstructor
public class ClienteRepositoryServiceImpl implements ClienteRepository {

    private ClienteRepositoryJPA clienteRepositoryJPA;

    @Override
    public Optional<ClienteOutput> buscarclientes(Long id) {
        return Optional.of(toOutput(clienteRepositoryJPA.findById(id).get()));
    }
}