package com.example.ecommerce.services;

import com.example.ecommerce.DTOs.PedidoDTO;
import com.example.ecommerce.entities.Pedido;
import com.example.ecommerce.entities.Usuario;
import com.example.ecommerce.entities.enums.StatusPedido;
import com.example.ecommerce.repositories.PedidoRepository;
import com.example.ecommerce.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository){
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }
    public String criarPedido(PedidoDTO dto){
        Usuario u = usuarioRepository.findById(dto.getIdCliente()).orElseThrow();
        Pedido p = new Pedido();
        p.setCliente(u);
        p.setMomento(Instant.now());
        p.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        pedidoRepository.save(p);
        return "Pedido criado com sucesso";
    }

    public String deletarPedido(long id){

        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedidoRepository.deleteById(id);
        return "Pedido exluido com sucesso";
    }
}
