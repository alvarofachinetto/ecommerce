package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.pedido.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositoryJpa extends JpaRepository<PedidoEntity, Long> {
}
