package com.puc.ecommerce.output.boundary.produtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ProdutoOutput {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAtualizacao;
}
