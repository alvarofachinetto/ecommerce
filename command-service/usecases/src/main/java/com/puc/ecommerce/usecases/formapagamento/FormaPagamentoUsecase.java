package com.puc.ecommerce.usecases.formapagamento;

import com.puc.ecommerce.input.boundary.formapagamento.FormaPagamentoService;
import com.puc.ecommerce.input.boundary.formapagamento.dto.FormaPagamentoInput;
import com.puc.ecommerce.output.boundary.formapagamento.FormaPagamentoOutput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.puc.ecommerce.output.boundary.repository.FormaPagamentoRepository;

@Service
@AllArgsConstructor
public class FormaPagamentoUsecase implements FormaPagamentoService {

    private FormaPagamentoRepository formaPagamentoRepository;

    @Override
    public void criar(FormaPagamentoInput input) {

        formaPagamentoRepository.criar(FormaPagamentoOutput.builder()
                .tipoPagamento(input.getTipoPagamento())
                .build());
    }

    @Override
    public void remover(Long id) {
        formaPagamentoRepository.remover(id);
    }
}