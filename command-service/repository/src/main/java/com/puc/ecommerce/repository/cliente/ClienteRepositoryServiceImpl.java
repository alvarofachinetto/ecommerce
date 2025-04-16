package com.puc.ecommerce.repository.cliente;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.output.boundary.repository.ClienteRepository;
import com.puc.ecommerce.repository.mapper.ClienteDataMapper;
import com.puc.ecommerce.repository.repositories.ClienteRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class ClienteRepositoryServiceImpl implements ClienteRepository {

    private ClienteRepositoryJPA clienteRepositoryJPA;

    @Override
    @Transactional
    public void cadastrarCliente(ClienteOutput cliente) throws Exception {
        // Implementação do método para cadastrar cliente
        clienteRepositoryJPA.save(ClienteDataMapper.toEntity(cliente));
    }

    @Override
    @Transactional
    public void atualizarCliente(ClienteOutput cliente, Long id) throws Exception {
        // Implementação do método para atualizar cliente

        // Verifica se o cliente existe
        var clienteOld = clienteRepositoryJPA.findById(id)
                .orElseThrow(() -> new Exception("Cliente não encontrado"));

        var newCliente = ClienteDataMapper.toEntityUpdate(clienteOld, cliente);

        // Atualiza os dados do cliente
        clienteRepositoryJPA.updateCliente(id, newCliente.getNome(), newCliente.getEmail(), newCliente.getTelefone(), newCliente.getSenha());

    }

    @Override
    public void deletarCliente(Long id) throws Exception {
        // Verifica se o cliente existe
        if(clienteRepositoryJPA.existsById(id)){
            clienteRepositoryJPA.deleteById(id);
        }else new Exception("Cliente não encontrado");
    }
}