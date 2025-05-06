package com.puc.ecommerce.api;

import com.puc.ecommerce.output.boundary.pedido.PedidoOutput;
import com.puc.ecommerce.output.boundary.pedido.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<PedidoOutput> buscarPedidoPorId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(pedidoService.buscarPedidoPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PedidoOutput>> buscarPedidoPorCliente(@RequestParam Long idCliente) {
        return ResponseEntity.ok(pedidoService.buscarPedidoPorCliente(idCliente));
    }
}
