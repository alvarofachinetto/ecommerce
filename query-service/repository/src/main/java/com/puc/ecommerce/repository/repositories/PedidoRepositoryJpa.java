package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;
import com.puc.ecommerce.repository.pedido.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepositoryJpa extends JpaRepository<PedidoEntity, Long> {

   @Query("SELECT p FROM PedidoEntity p WHERE p.cliente.id = :clienteId")
    List<PedidoEntity> findByClienteId(Long clienteId);;
    Optional<PedidoEntity> findById(Long id);
}
