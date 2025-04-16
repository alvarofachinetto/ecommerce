package com.puc.ecommerce.output.boundary.produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoOutput {
    private String nome;
    private String descricao;
    private BigDecimal preco;
}