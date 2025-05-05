package com.puc.ecommerce.repository.cliente;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.output.boundary.repository.ClienteRepository;
import com.puc.ecommerce.repository.mapper.ClienteDataMapper;
import com.puc.ecommerce.repository.repositories.ClienteRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static com.puc.ecommerce.repository.mapper.ClienteDataMapper.toOutput;

@Component
@AllArgsConstructor
public class ClienteRepositoryServiceImpl implements ClienteRepository {

    private ClienteRepositoryJPA clienteRepositoryJPA;

    // Verifica se o cliente já existe
    public Boolean clienteExistentePorKeycloakId(UUID KeycloakId) {
        return clienteRepositoryJPA.existsByKeycloakId(KeycloakId);

    }

    @Override
    public Optional<ClienteOutput> buscarClientePorKeycloakId(UUID KeycloakId) {
        return Optional.of(toOutput(clienteRepositoryJPA.findByKeycloakId(KeycloakId).get()));
    }

    @Override
    @Transactional
    public ClienteOutput cadastrarCliente(ClienteOutput cliente) {
        // Implementação do método para cadastrar cliente
        return toOutput(clienteRepositoryJPA.save(ClienteDataMapper.toEntity(cliente))) ;
    }

    @Override
    @Transactional
    public ClienteOutput atualizarCliente(ClienteOutput cliente, UUID keycloakId) {
        // Verifica se o cliente existe
        var clienteOld = clienteRepositoryJPA.findByKeycloakId(keycloakId).get();

        var newCliente = ClienteDataMapper.toEntityUpdate(clienteOld, cliente);

        // Atualiza os dados do cliente
        return toOutput(clienteRepositoryJPA.updateCliente(keycloakId, newCliente.getTelefone(), newCliente.getEndereco()));
    }


    @Override
    public void deletarCliente(UUID KeycloakId) throws Exception {
        // Verifica se o cliente existe
        clienteRepositoryJPA.deleteByKeycloakId(KeycloakId);
    }
}