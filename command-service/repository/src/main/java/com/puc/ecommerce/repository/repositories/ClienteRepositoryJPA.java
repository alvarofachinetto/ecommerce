package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, Long> {

    @Modifying
    @Query("UPDATE ClienteEntity c SET c.nome = :nome, c.email = :email, c.telefone = :telefone, c.senha = :senha WHERE c.id = :id")
    void updateCliente(@Param("id") Long id, @Param("nome") String nome, @Param("email") String email, @Param("telefone") String numero, @Param("senha") String senha);
}
