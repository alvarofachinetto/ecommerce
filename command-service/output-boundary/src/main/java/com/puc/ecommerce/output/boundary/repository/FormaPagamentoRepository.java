package com.puc.ecommerce.output.boundary.repository;

import com.puc.ecommerce.output.boundary.formapagamento.FormaPagamentoOutput;

import java.util.Optional;

public interface FormaPagamentoRepository {

    void criar(FormaPagamentoOutput formaPagamentoOutput);

    void remover(Long id);

}
