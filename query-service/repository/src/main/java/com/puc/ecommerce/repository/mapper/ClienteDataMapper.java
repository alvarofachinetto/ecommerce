package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;

import java.time.LocalDateTime;

public class ClienteDataMapper {


    public static ClienteOutput toOutput(ClienteEntity clienteEntity) {
        return ClienteOutput.builder()
                .nome(clienteEntity.getNome())
                .email(clienteEntity.getEmail())
                .documento(clienteEntity.getDocumento())
                .telefone(clienteEntity.getTelefone())
                .endereco(EnderecoDataMapper.toOutput(clienteEntity.getEndereco()))
                .build();
    }
}
