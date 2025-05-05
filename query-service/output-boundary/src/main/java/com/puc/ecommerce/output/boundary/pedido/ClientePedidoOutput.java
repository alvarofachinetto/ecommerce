package com.puc.ecommerce.output.boundary.pedido;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientePedidoOutput {
    private Long id;
    private String nome;
    private String email;
    private String documento;
    private String telefone;
}
