package com.example.ecommerce.controllers;

import com.example.ecommerce.DTOs.PedidoDTO;
import com.example.ecommerce.services.PedidoService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("pedido")
public class PedidoController {
    private final PedidoService service;
    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveOrder(@RequestBody PedidoDTO dto){
        return ResponseEntity.ok(service.criarPedido(dto));
    }
}
