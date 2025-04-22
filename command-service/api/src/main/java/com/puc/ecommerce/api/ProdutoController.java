package com.puc.ecommerce.api;

import com.puc.ecommerce.input.boundary.produto.ProdutoService;
import com.puc.ecommerce.input.boundary.produto.dto.ProdutoInput;
import com.puc.ecommerce.input.boundary.produto.dto.ProdutoUpdateInput;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> criarProduto(@Valid @RequestBody ProdutoInput produtoInput) throws Exception {
        produtoService.criarProduto(produtoInput);
        return ResponseEntity.status(201).body("Produto criado com sucesso");
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoUpdateInput produtoInput) {
        produtoService.atualizarProduto(id, produtoInput);
        return ResponseEntity.ok("Produto atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) throws Exception {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}