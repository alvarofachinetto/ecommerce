package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;

import java.time.LocalDateTime;

public class ClienteDataMapper {

    public static ClienteEntity toEntity(ClienteOutput clienteOutput) {
        return ClienteEntity.builder()
                .documento(clienteOutput.getDocumento())
                .telefone(clienteOutput.getTelefone())
                .endereco(EnderecoDataMapper.toEntity(clienteOutput.getEndereco()))
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

    public static ClienteOutput toOutput(ClienteEntity clienteEntity) {
        return ClienteOutput.builder()
                .id(clienteEntity.getId())
                .documento(clienteEntity.getDocumento())
                .telefone(clienteEntity.getTelefone())
                .endereco(EnderecoDataMapper.toOutput(clienteEntity.getEndereco()))
                .build();
    }
}
