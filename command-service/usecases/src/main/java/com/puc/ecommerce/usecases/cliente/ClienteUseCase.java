package com.puc.ecommerce.usecases.cliente;

import com.puc.ecommerce.input.boundary.cliente.ClienteService;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteInput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteUpdateInput;
import com.puc.ecommerce.output.boundary.exception.CustomException;
import com.puc.ecommerce.output.boundary.repository.ClienteRepository;
import com.puc.ecommerce.usecases.mapper.ClienteDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteUseCase implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public void cadastrarCliente(ClienteInput clienteInput) {
        // Verifica se o cliente já existe
        try {
            if (clienteRepository.clienteExistentePorKeycloakId(clienteInput.getKeycloakId())) {
                throw new CustomException("Cliente já cadastrado com o documento: " + clienteInput.getDocumento());
            }
            clienteRepository.cadastrarCliente(ClienteDataMapper.toOutput(clienteInput));
        }catch (Exception e){
            throw new RuntimeException("Erro ao cadastrar cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public void atualizarCliente(ClienteUpdateInput clienteInput, UUID keycloakId) {
        // Verifica se o cliente existe
        try {
            if(clienteRepository.clienteExistentePorKeycloakId(keycloakId)){
                clienteRepository.atualizarCliente(ClienteDataMapper.toUpdateOutput(clienteInput), keycloakId);
            } else throw new CustomException("Cliente não encontrado");
        }catch (Exception e){
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage(), e);
        }
    }

    @Override
    public void deletarCliente(UUID keycloakId) {
        try {
            if(clienteRepository.clienteExistentePorKeycloakId(keycloakId)){
                clienteRepository.deletarCliente(keycloakId);
            } else throw new CustomException("Cliente não encontrado");
        }catch (Exception e){
            throw new RuntimeException("Erro ao deletar cliente: " + e.getMessage(), e);
        }
    }
}
