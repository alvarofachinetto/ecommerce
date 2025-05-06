package com.puc.ecommerce.api;
import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;
import com.puc.ecommerce.output.boundary.produtos.ProdutoService;
import com.puc.ecommerce.security.annotations.PublicEndpoint;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PublicEndpoint
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoOutput> buscarProdutoPorId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(produtoService.buscarProdutoPorId(id));
    }

    @PublicEndpoint
    @GetMapping("/buscar")
    public ResponseEntity<List<ProdutoOutput>> buscarProdutosPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(produtoService.buscarProdutosPorNome(nome));
    }
}
