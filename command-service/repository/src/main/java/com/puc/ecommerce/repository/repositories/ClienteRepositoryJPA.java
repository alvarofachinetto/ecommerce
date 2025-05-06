package com.puc.ecommerce.repository.repositories;

import com.puc.ecommerce.repository.cliente.entities.ClienteEntity;
import com.puc.ecommerce.repository.cliente.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, Long> {

    @Modifying
    @Query("UPDATE ClienteEntity c SET c.telefone = :telefone, c.endereco = :endereco WHERE c.keycloakId = :keycloakId")
    ClienteEntity updateCliente(@Param("keycloakId") UUID keycloakId, @Param("telefone") String telefone, @Param("endereco") EnderecoEntity endereco);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ClienteEntity c WHERE c.keycloakId = :keycloakId")
    @Modifying
    boolean existsByKeycloakId(@Param("keycloakId") UUID keycloakId);

    Optional<ClienteEntity> findByKeycloakId(UUID keyCloqueId);

    void deleteByKeycloakId(UUID keycloakId);
}
