package com.puc.ecommerce.usecases.formapagamento;

import com.puc.ecommerce.input.boundary.formapagamento.FormaPagamentoService;
import com.puc.ecommerce.input.boundary.formapagamento.dto.FormaPagamentoInput;
import com.puc.ecommerce.output.boundary.exception.CustomException;
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

        try {
            // Verifica se a forma de pagamento já existe
            if (formaPagamentoRepository.existeFormaPagamento(input.getTipoPagamento())) {
                throw new CustomException(String.format("Forma de pagamento com tipo '%s' já existe", input.getTipoPagamento()));
            }
            formaPagamentoRepository.criar(FormaPagamentoOutput.builder()
                    .tipoPagamento(input.getTipoPagamento())
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar forma de pagamento: " + e.getMessage(), e);
        }
    }

    @Override
    public void remover(Long id) {
        try {
            formaPagamentoRepository.remover(id);
        }catch (Exception e){
            throw new RuntimeException("Erro ao remover forma de pagamento: " + e.getMessage(), e);
        }

    }
}