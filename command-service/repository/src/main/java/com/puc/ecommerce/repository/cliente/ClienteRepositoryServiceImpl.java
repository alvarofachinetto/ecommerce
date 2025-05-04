package com.puc.ecommerce.repository.cliente;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.output.boundary.repository.ClienteRepository;
import com.puc.ecommerce.repository.mapper.ClienteDataMapper;
import com.puc.ecommerce.repository.repositories.ClienteRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.puc.ecommerce.repository.mapper.ClienteDataMapper.toOutput;

@Component
@AllArgsConstructor
public class ClienteRepositoryServiceImpl implements ClienteRepository {

    private ClienteRepositoryJPA clienteRepositoryJPA;

    // Verifica se o cliente já existe
    public Boolean clienteExistentePorDocumento(String documento) {
        return clienteRepositoryJPA.existsByDocumento(documento);

    }

    @Override
    public Optional<ClienteOutput> buscarClientePorDocumento(String documento) {
        return Optional.of(toOutput(clienteRepositoryJPA.findByDocumento(documento)));
    }

    @Override
    @Transactional
    public ClienteOutput cadastrarCliente(ClienteOutput cliente) {
        // Implementação do método para cadastrar cliente
        return toOutput(clienteRepositoryJPA.save(ClienteDataMapper.toEntity(cliente))) ;
    }

    @Override
    @Transactional
    public ClienteOutput atualizarCliente(ClienteOutput cliente, Long id) {
        // Verifica se o cliente existe
        var clienteOld = clienteRepositoryJPA.findById(id).get();

        var newCliente = ClienteDataMapper.toEntityUpdate(clienteOld, cliente);

        // Atualiza os dados do cliente
        return toOutput(clienteRepositoryJPA.updateCliente(id, newCliente.getNome(), newCliente.getEmail(), newCliente.getTelefone(), newCliente.getSenha()));

    }

    // metodo para verificar se o cliente existe
    public Boolean clienteExistentePorId(Long id) {
        return clienteRepositoryJPA.existsById(id);
    }

    @Override
    public void deletarCliente(Long id) throws Exception {
        // Verifica se o cliente existe
        clienteRepositoryJPA.deleteById(id);
    }
}