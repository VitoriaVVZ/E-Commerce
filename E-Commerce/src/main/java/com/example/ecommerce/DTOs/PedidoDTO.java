package com.example.ecommerce.DTOs;

import com.example.ecommerce.entities.Usuario;
import com.example.ecommerce.entities.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private long id;
    private Instant momento;
    private StatusPedido status;
    private long idCliente;

    public PedidoDTO(long idCliente) {
        this.momento = Instant.now();
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
        this.idCliente = idCliente;
    }
}
