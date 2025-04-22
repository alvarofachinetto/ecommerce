package com.puc.ecommerce.api;

import com.puc.ecommerce.input.boundary.inventario.EstoqueService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estoque")
@AllArgsConstructor
public class EstoqueController {

    private EstoqueService estoqueService;

    @PatchMapping("/{estoqueId}/adicionar/{quantidade}")
    public ResponseEntity<String> adicionarProdutoEstoque(
            @PathVariable Long estoqueId,
            @Valid
            @Min(value  = 1, message = "A quantidade deve ser maior ou igual a 1") @PathVariable Integer quantidade
    ){
        estoqueService.adicionarProdutoEstoque(estoqueId, quantidade);
        return ResponseEntity.ok("Quantidade adicionada com sucesso");
    }

    @PatchMapping("/{estoqueId}/remover/{quantidade}")
    public ResponseEntity<String> removerProdutoEstoque(@PathVariable Long estoqueId, @Min(1) @PathVariable Integer quantidade){
        estoqueService.removerProdutoEstoque(estoqueId, quantidade);
        return ResponseEntity.ok("Quantidade removida com sucesso");
    }
}