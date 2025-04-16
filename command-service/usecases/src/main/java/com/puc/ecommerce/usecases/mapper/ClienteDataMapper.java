package com.puc.ecommerce.usecases.mapper;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteInput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteUpdateInput;

public class ClienteDataMapper {

    public static ClienteOutput toOutput(ClienteInput input) {
        var output = new ClienteOutput();
        output.setNome(input.getNome());
        output.setEmail(input.getEmail());
        output.setDocumento(input.getDocumento());
        output.setTelefone(input.getTelefone());
        output.setSenha(input.getSenha());
        return output;
    }

    public static ClienteOutput toUpdateOutput(ClienteUpdateInput input) {
        var output = new ClienteOutput();
        output.setNome(input.getNome());
        output.setEmail(input.getEmail());
        output.setTelefone(input.getTelefone());
        output.setSenha(input.getSenha());
        return output;
    }

}
