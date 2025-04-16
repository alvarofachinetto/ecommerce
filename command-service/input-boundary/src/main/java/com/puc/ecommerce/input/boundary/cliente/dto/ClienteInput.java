package com.puc.ecommerce.input.boundary.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class ClienteInput {

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "O nome não pode exceder 100 caracteres")
    private String nome;

    @NotBlank(message = "Documento é obrigatório")
    @Size(max = 11, message = "O documento não pode exceder 11 caracteres")
    @CPF
    private String documento;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "O email deve ser válido")
    private String email;

    @NotBlank(message = "Número de telefone é obrigatório")
    @Size(max = 15, message = "O número de telefone não pode exceder 15 caracteres")
    private String telefone;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    private String senha;
}