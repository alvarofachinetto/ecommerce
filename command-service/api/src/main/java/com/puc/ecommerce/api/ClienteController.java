package com.puc.ecommerce.api;

import com.puc.ecommerce.input.boundary.cliente.ClienteService;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteInput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteUpdateInput;
import com.puc.ecommerce.security.UserIdentityExtensions;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private ClienteService clienteService;

    /**
     * Endpoint para cadastrar um novo cliente.
     *
     * @param clienteInput os dados do cliente a serem cadastrados
     * @return uma resposta indicando o sucesso ou falha da operação
     */

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarCliente(@RequestBody @Valid ClienteInput clienteInput, @AuthenticationPrincipal Jwt jwt) throws Exception {
        var userIdentity = UserIdentityExtensions.getUserIdentity(jwt);

        // Implementar a lógica para cadastrar o usuário
        clienteInput.setKeycloakId(userIdentity.getId());
        clienteService.cadastrarCliente(clienteInput);
        return ResponseEntity.status(201).body("Cliente criado com sucesso");
    }

    /**
     * Endpoint para atualizar os dados de um cliente existente.
     *
     * @param clienteInput os novos dados do cliente
     * @return uma resposta indicando o sucesso ou falha da operação
     */
    @PostMapping("/atualizar/{keycloakId}")
    public ResponseEntity<String> atualizarCliente(@RequestBody @Valid ClienteUpdateInput clienteInput, @PathVariable UUID keycloakId) throws Exception {
        // Implementar a lógica para atualizar o usuário
        clienteService.atualizarCliente(clienteInput, keycloakId);
        return ResponseEntity.ok("Cliente atualizado com sucesso");
    }

    /**
     * Endpoint para deletar um cliente existente.
     *
     * @param keycloakId o ID do cliente a ser deletado
     * @return uma resposta indicando o sucesso ou falha da operação
     */

    @DeleteMapping("/deletar/{keycloakId}")
    public ResponseEntity<Void> deletarCliente(@PathVariable UUID keycloakId) throws Exception {
        // Implementar a lógica para deletar o usuário
        clienteService.deletarCliente(keycloakId);
        return ResponseEntity.noContent().build();
    }
}
