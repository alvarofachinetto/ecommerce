package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;

public class ClienteDataMapper {

    public static ClienteEntity toEntity(ClienteOutput clienteOutput) {
        if (clienteOutput == null) {
            return null;
        }

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(clienteOutput.getNome());
        clienteEntity.setEmail(clienteOutput.getEmail());
        clienteEntity.setDocumento(clienteOutput.getDocumento());
        clienteEntity.setTelefone(clienteOutput.getTelefone());
        clienteEntity.setSenha(clienteOutput.getSenha());

        return clienteEntity;
    }

    public static ClienteEntity toEntityUpdate(ClienteEntity clienteOld, ClienteOutput clienteOutput) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(clienteOutput.getNome());
        clienteEntity.setEmail(clienteOutput.getEmail());
        clienteEntity.setTelefone(clienteOutput.getTelefone());
        clienteEntity.setSenha(clienteOutput.getSenha());
        return clienteEntity;
    }
}
