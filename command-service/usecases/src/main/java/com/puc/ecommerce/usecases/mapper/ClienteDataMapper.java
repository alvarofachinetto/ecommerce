package com.puc.ecommerce.usecases.mapper;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteInput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteUpdateInput;

public class ClienteDataMapper {

    public static ClienteOutput toOutput(ClienteInput input) {
        return ClienteOutput.builder()
                .nome(input.getNome())
                .email(input.getEmail())
                .documento(input.getDocumento())
                .telefone(input.getTelefone())
                .endereco(EnderecoDataMapper.toOutput(input.getEndereco()))
                .senha(input.getSenha())
                .build();
    }

    public static ClienteOutput toUpdateOutput(ClienteUpdateInput input) {
        return ClienteOutput.builder()
                .nome(input.getNome())
                .email(input.getEmail())
                .telefone(input.getTelefone())
                .senha(input.getSenha())
                .endereco(EnderecoDataMapper.toOutput(input.getEndereco()))
                .build();
    }

}
