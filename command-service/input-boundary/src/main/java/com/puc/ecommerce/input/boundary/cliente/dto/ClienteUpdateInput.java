package com.puc.ecommerce.input.boundary.cliente.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteUpdateInput {
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "O nome não pode exceder 100 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "O email deve ser válido")
    private String email;

    @NotBlank(message = "Número de telefone é obrigatório")
    @Size(max = 15, message = "O número de telefone não pode exceder 15 caracteres")
    private String telefone;

    private EnderecoInput endereco;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
    private String senha;
}

