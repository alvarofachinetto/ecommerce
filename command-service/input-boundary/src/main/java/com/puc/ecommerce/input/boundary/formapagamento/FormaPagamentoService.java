package com.puc.ecommerce.input.boundary.formapagamento;

import com.puc.ecommerce.input.boundary.formapagamento.dto.FormaPagamentoInput;

public interface FormaPagamentoService {

    void criar(FormaPagamentoInput input);

    void remover(Long id);
}
