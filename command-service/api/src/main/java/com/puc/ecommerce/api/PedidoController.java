package com.puc.ecommerce.api;

import com.puc.ecommerce.input.boundary.pedido.PedidoService;
import com.puc.ecommerce.input.boundary.pedido.dto.PedidoInput;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody @Valid PedidoInput pedidoInput) {
        pedidoService.criarPedido(pedidoInput);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pedido criado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelarPedido(@PathVariable Long id) {
        pedidoService.cancelarPedido(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Pedido cancelado com sucesso");
    }
}