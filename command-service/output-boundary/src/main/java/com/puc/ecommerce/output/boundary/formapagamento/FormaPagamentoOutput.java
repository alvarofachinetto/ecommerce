package com.puc.ecommerce.output.boundary.formapagamento;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FormaPagamentoOutput {
    private String tipoPagamento;
}