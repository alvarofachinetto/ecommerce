package com.puc.ecommerce.repository.cliente.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "clientes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID keycloakId;

    @Column(nullable = false, unique = true, length = 11)
    private String documento;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Embedded
    @Column(nullable = false)
    private EnderecoEntity endereco;

    @Column(nullable = false)
    private LocalDateTime dataHoraCadastro;

    @Column(nullable = false)
    private LocalDateTime dataHoraAtualizacao;

}