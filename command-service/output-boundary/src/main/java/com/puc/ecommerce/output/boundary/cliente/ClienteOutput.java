package com.puc.ecommerce.output.boundary.cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteOutput {
    private Long id;
    private String documento;
    private String telefone;
    private EnderecoOutput endereco;
}
