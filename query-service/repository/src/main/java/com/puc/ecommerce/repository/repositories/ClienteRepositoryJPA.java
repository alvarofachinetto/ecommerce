package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity,Long> {
}
