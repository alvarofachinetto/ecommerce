package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;

import java.time.LocalDateTime;

public class ClienteDataMapper {

    public static ClienteEntity toEntity(ClienteOutput clienteOutput) {
        return ClienteEntity.builder()
                .nome(clienteOutput.getNome())
                .email(clienteOutput.getEmail())
                .documento(clienteOutput.getDocumento())
                .telefone(clienteOutput.getTelefone())
                .endereco(EnderecoDataMapper.toEntity(clienteOutput.getEndereco()))
                .senha(clienteOutput.getSenha())
                .dataHoraCadastro(LocalDateTime.now())
                .dataHoraAtualizacao(LocalDateTime.now())
                .build();
    }

    public static ClienteEntity toEntityUpdate(ClienteEntity clienteOld, ClienteOutput clienteOutput) {
        return ClienteEntity.builder()
                .id(clienteOld.getId())
                .documento(clienteOutput.getDocumento())
                .endereco(EnderecoDataMapper.toEntity(clienteOutput.getEndereco()))
                .dataHoraCadastro(clienteOld.getDataHoraCadastro())
                .dataHoraAtualizacao(LocalDateTime.now())
                .build();
    }
}
