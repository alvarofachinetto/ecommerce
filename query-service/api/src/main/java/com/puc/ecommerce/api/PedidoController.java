package com.puc.ecommerce.api;

import com.puc.ecommerce.output.boundary.pedidos.PedidoOutput;
import com.puc.ecommerce.output.boundary.pedidos.PedidoService;
import com.puc.ecommerce.output.boundary.produtos.ProdutoOutput;
import com.puc.ecommerce.output.boundary.produtos.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoOutput> buscarPedidoPorId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(pedidoService.buscarPedidoPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProdutoOutput>> buscarPedidoPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(pedidoService.buscarPedidoPorNome(nome));
    }
}
