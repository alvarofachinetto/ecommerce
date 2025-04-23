package com.puc.ecommerce.input.boundary.cliente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EnderecoInput {
    @NotBlank(message = "Logradouro é obrigatório")
    @Size(max = 100, message = "O logradouro não pode exceder 100 caracteres")
    private String logradouro;

    @NotBlank(message = "Número é obrigatório")
    @Size(max = 10, message = "O número não pode exceder 10 caracteres")
    private String numero;

    @Size(max = 50, message = "O complemento não pode exceder 50 caracteres")
    private String complemento;

    @NotBlank(message = "Bairro é obrigatório")
    @Size(max = 50, message = "O bairro não pode exceder 50 caracteres")
    private String bairro;

    @NotBlank(message = "Cidade é obrigatória")
    @Size(max = 50, message = "A cidade não pode exceder 50 caracteres")
    private String cidade;

    @NotBlank(message = "Estado é obrigatório")
    @Size(max = 2, message = "O estado deve ter 2 caracteres")
    private String estado;

    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "\\d{8}", message = "CEP inválido")
    private String cep;

    @NotBlank(message = "País é obrigatório")
    @Size(max = 50, message = "O país não pode exceder 50 caracteres")
    private String pais;
}