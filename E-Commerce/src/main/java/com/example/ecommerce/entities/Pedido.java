package com.example.ecommerce.entities;


import com.example.ecommerce.entities.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private Instant momento;
    private StatusPedido status;
    @ManyToOne
    private Usuario cliente;
    @OneToOne (mappedBy = "pedido" , cascade = CascadeType.ALL)
    private Pagamento pagamento;
}
