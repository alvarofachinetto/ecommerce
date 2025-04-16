package com.puc.ecommerce.api;

import com.puc.ecommerce.input.boundary.cliente.ClienteService;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteInput;
import com.puc.ecommerce.input.boundary.cliente.dto.ClienteUpdateInput;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> adicionarCliente(@RequestBody @Valid ClienteInput clienteInput) throws Exception {
        // Implementar a lógica para cadastrar o usuário
        clienteService.cadastrarCliente(clienteInput);
        return ResponseEntity.status(201).body("Cliente criado com sucesso");
    }

    /**
     * Endpoint para atualizar os dados de um cliente existente.
     *
     * @param clienteInput os novos dados do cliente
     * @return uma resposta indicando o sucesso ou falha da operação
     */
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarCliente(@RequestBody @Valid ClienteUpdateInput clienteInput, @PathVariable Long id) throws Exception {
        // Implementar a lógica para atualizar o usuário
        clienteService.atualizarCliente(clienteInput, id);
        return ResponseEntity.ok("Cliente atualizado com sucesso");
    }

    /**
     * Endpoint para deletar um cliente existente.
     *
     * @param id o ID do cliente a ser deletado
     * @return uma resposta indicando o sucesso ou falha da operação
     */

    @PostMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) throws Exception {
        // Implementar a lógica para deletar o usuário
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
