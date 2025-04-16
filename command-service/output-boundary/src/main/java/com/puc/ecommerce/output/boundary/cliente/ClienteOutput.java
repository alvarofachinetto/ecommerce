package com.puc.ecommerce.output.boundary.cliente;

import lombok.Data;

@Data
public class ClienteOutput {
    private String nome;
    private String email;
    private String documento;
    private String telefone;
    private String senha;
}
