package com.puc.ecommerce.input.boundary.cliente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Data
public class ClienteInput {

    private UUID keycloakId;

    @NotBlank(message = "Documento é obrigatório")
    @Size(max = 11, message = "O documento não pode exceder 11 caracteres")
    @CPF
    private String documento;

    @NotBlank(message = "Número de telefone é obrigatório")
    @Size(max = 15, message = "O número de telefone não pode exceder 15 caracteres")
    private String telefone;

    private EnderecoInput endereco;
}