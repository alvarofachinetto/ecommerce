package com.puc.ecommerce.input.boundary.formapagamento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FormaPagamentoInput {

    @NotBlank(message = "Tipo de pagamento é obrigatório")
    @Size(max = 50, message = "O nome não pode exceder 50 caracteres")
    private String tipoPagamento;
}