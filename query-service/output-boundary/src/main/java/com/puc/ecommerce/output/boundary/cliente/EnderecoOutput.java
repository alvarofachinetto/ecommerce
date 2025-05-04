package com.puc.ecommerce.output.boundary.cliente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnderecoOutput {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
}