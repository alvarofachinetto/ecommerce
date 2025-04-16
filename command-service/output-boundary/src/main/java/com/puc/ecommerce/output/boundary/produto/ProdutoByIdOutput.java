package com.puc.ecommerce.output.boundary.produto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProdutoByIdOutput {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
