package com.lanchonete.sistema_pedido.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
