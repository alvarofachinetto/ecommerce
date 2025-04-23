package com.puc.ecommerce.usecases.mapper;

import com.puc.ecommerce.input.boundary.cliente.dto.EnderecoInput;
import com.puc.ecommerce.output.boundary.cliente.EnderecoOutput;

public class EnderecoDataMapper {

    public static EnderecoOutput toOutput(EnderecoInput input) {
        return EnderecoOutput.builder()
                .logradouro(input.getLogradouro())
                .numero(input.getNumero())
                .complemento(input.getComplemento())
                .bairro(input.getBairro())
                .cidade(input.getCidade())
                .estado(input.getEstado())
                .cep(input.getCep())
                .pais(input.getPais())
                .build();
    }
}
