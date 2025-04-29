package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.formapagamento.entities.FormaPagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagamentoRepositoryJPA extends JpaRepository<FormaPagamentoEntity, Long> {
    Boolean existsByTipoPagamento(String tipoPagamento);
}
