package com.puc.ecommerce.api;

import com.puc.ecommerce.output.boundary.cliente.ClienteOutput;
import com.puc.ecommerce.output.boundary.cliente.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping("{id}")
    public ResponseEntity<ClienteOutput> findCliente(@PathVariable Long id) throws Exception {

        return ResponseEntity.ok(clienteService.buscarclientes(id));
    }

}
