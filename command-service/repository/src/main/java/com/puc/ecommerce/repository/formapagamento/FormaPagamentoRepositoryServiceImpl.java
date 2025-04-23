package com.puc.ecommerce.repository.formapagamento;

import com.puc.ecommerce.output.boundary.formapagamento.FormaPagamentoOutput;
import com.puc.ecommerce.output.boundary.repository.FormaPagamentoRepository;
import com.puc.ecommerce.repository.formapagamento.entities.FormaPagamentoEntity;
import com.puc.ecommerce.repository.repositories.FormaPagamentoRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FormaPagamentoRepositoryServiceImpl implements FormaPagamentoRepository {

    private final FormaPagamentoRepositoryJPA formaPagamentoRepositoryJPA;

    @Override
    public void criar(FormaPagamentoOutput formaPagamentoOutput) {
        formaPagamentoRepositoryJPA.save(FormaPagamentoEntity.builder()
                .tipoPagamento(formaPagamentoOutput.getTipoPagamento())
                .build());
    }


    @Override
    public void remover(Long id) {
        formaPagamentoRepositoryJPA.deleteById(id);
    }
}