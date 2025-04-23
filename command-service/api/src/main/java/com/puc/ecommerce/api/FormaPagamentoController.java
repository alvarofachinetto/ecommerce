package com.puc.ecommerce.api;

import com.puc.ecommerce.input.boundary.formapagamento.dto.FormaPagamentoInput;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.puc.ecommerce.input.boundary.formapagamento.FormaPagamentoService;

@RestController
@RequestMapping("/api/v1/formapagamento")
@AllArgsConstructor
public class FormaPagamentoController {

    private FormaPagamentoService formaPagamentoService;

    @PostMapping
    public ResponseEntity<Void> criarFormaPagamento(@Valid @RequestBody FormaPagamentoInput input) {
        formaPagamentoService.criar(input);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerFormaPagamento(@PathVariable Long id) {
        formaPagamentoService.remover(id);
        return ResponseEntity.noContent().build();
    }
}