package com.puc.ecommerce.input.boundary.pedido.dto;

import com.puc.ecommerce.input.boundary.formapagamento.dto.FormaPagamentoInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PedidoInput {

    @NotNull(message = "KeycloakId do cliente é obrigatório")
    private UUID keycloakId;

    @NotEmpty(message = "Lista de itens não pode estar vazia")
    @Size(min = 1, message = "Pedido deve ter pelo menos 1 item")
    @Valid
    private List<ItemPedidoInput> itens;

    @NotNull(message = "Forma de pagamento é obrigatória")
    @Valid
    private FormaPagamentoInput formaPagamento;
}