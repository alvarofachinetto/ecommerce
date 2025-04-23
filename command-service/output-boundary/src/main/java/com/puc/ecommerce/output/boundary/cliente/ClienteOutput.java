package com.puc.ecommerce.output.boundary.cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteOutput {
    private String nome;
    private String email;
    private String documento;
    private String telefone;
    private EnderecoOutput endereco;
    private String senha;
}
