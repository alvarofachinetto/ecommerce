package com.puc.ecommerce.repository.mapper;

import com.puc.ecommerce.output.boundary.cliente.EnderecoOutput;
import com.puc.ecommerce.repository.cliente.entities.EnderecoEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnderecoDataMapper {

    public static EnderecoEntity toEntity(EnderecoOutput endereco) {
        return EnderecoEntity.builder()
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .pais(endereco.getPais())
                .build();
    }

    public static EnderecoOutput toOutput(EnderecoEntity entity) {
        return EnderecoOutput.builder()
                .logradouro(entity.getLogradouro())
                .numero(entity.getNumero())
                .complemento(entity.getComplemento())
                .bairro(entity.getBairro())
                .cidade(entity.getCidade())
                .estado(entity.getEstado())
                .cep(entity.getCep())
                .pais(entity.getPais())
                .build();
    }
}
